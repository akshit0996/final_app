package com.googlecode.mp4parser.authoring.samples;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox.Entry;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

public class FragmentedMp4SampleList extends AbstractList<Sample> {
    private List<TrackFragmentBox> allTrafs;
    IsoFile[] fragments;
    private SoftReference<Sample>[] sampleCache;
    private int size_ = -1;
    Container topLevel;
    TrackBox trackBox = null;
    TrackExtendsBox trex = null;

    public FragmentedMp4SampleList(long track, Container topLevel, IsoFile... fragments) {
        this.topLevel = topLevel;
        this.fragments = fragments;
        for (TrackBox tb : ((MovieBox) topLevel.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (tb.getTrackHeaderBox().getTrackId() == track) {
                this.trackBox = tb;
            }
        }
        if (this.trackBox == null) {
            throw new RuntimeException("This MP4 does not contain track " + track);
        }
        for (Box box : Path.getPaths(topLevel, "moov/mvex/trex")) {
            if (((TrackExtendsBox) box).getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                this.trex = (TrackExtendsBox) box;
            }
        }
        this.sampleCache = (SoftReference[]) Array.newInstance(SoftReference.class, size());
    }

    private List<TrackFragmentBox> allFragments() {
        if (this.allTrafs != null) {
            return this.allTrafs;
        }
        List<TrackFragmentBox> trafs = new LinkedList();
        for (MovieFragmentBox moof : this.topLevel.getBoxes(MovieFragmentBox.class)) {
            for (TrackFragmentBox trackFragmentBox : moof.getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                    trafs.add(trackFragmentBox);
                }
            }
        }
        if (this.fragments != null) {
            for (IsoFile fragment : this.fragments) {
                for (MovieFragmentBox moof2 : fragment.getBoxes(MovieFragmentBox.class)) {
                    for (TrackFragmentBox trackFragmentBox2 : moof2.getBoxes(TrackFragmentBox.class)) {
                        if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                            trafs.add(trackFragmentBox2);
                        }
                    }
                }
            }
        }
        this.allTrafs = trafs;
        return trafs;
    }

    private int getTrafSize(TrackFragmentBox traf) {
        return CastUtils.l2i(((TrackRunBox) traf.getBoxes(TrackRunBox.class).get(0)).getSampleCount());
    }

    public Sample get(int index) {
        if (this.sampleCache[index] != null) {
            Sample cachedSample = (Sample) this.sampleCache[index].get();
            if (cachedSample != null) {
                return cachedSample;
            }
        }
        int currentIndex = 1;
        int targetIndex = index + 1;
        for (TrackFragmentBox trackFragmentBox : allFragments()) {
            int trafSize = getTrafSize(trackFragmentBox);
            if (targetIndex < currentIndex || targetIndex >= currentIndex + trafSize) {
                currentIndex += trafSize;
            } else {
                long sampleSize;
                int sampleIndexWithInTraf = targetIndex - currentIndex;
                MovieFragmentBox moof = (MovieFragmentBox) trackFragmentBox.getParent();
                TrackRunBox trun = (TrackRunBox) trackFragmentBox.getBoxes(TrackRunBox.class).get(0);
                long offset = 0;
                if (trun.isDataOffsetPresent()) {
                    offset = 0 + ((long) trun.getDataOffset());
                }
                List<Entry> trackRunEntries = trun.getEntries();
                if (trackFragmentBox.getTrackFragmentHeaderBox().hasBaseDataOffset()) {
                    offset += trackFragmentBox.getTrackFragmentHeaderBox().getBaseDataOffset();
                } else {
                    offset += moof.getOffset();
                }
                for (int i = 0; i < sampleIndexWithInTraf; i++) {
                    if (trun.isSampleSizePresent()) {
                        offset += ((Entry) trackRunEntries.get(i)).getSampleSize();
                    } else if (trackFragmentBox.getTrackFragmentHeaderBox().hasDefaultSampleSize()) {
                        offset += trackFragmentBox.getTrackFragmentHeaderBox().getDefaultSampleSize();
                    } else if (this.trex == null) {
                        throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                    } else {
                        offset += this.trex.getDefaultSampleSize();
                    }
                }
                if (trun.isSampleSizePresent()) {
                    sampleSize = ((Entry) trackRunEntries.get(sampleIndexWithInTraf)).getSampleSize();
                } else if (trackFragmentBox.getTrackFragmentHeaderBox().hasDefaultSampleSize()) {
                    sampleSize = trackFragmentBox.getTrackFragmentHeaderBox().getDefaultSampleSize();
                } else if (this.trex == null) {
                    throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                } else {
                    sampleSize = this.trex.getDefaultSampleSize();
                }
                SampleImpl sample = new SampleImpl(offset, sampleSize, moof.getParent());
                this.sampleCache[index] = new SoftReference(sample);
                return sample;
            }
        }
        return null;
    }

    public int size() {
        if (this.size_ != -1) {
            return this.size_;
        }
        int i = 0;
        for (MovieFragmentBox moof : this.topLevel.getBoxes(MovieFragmentBox.class)) {
            for (TrackFragmentBox trackFragmentBox : moof.getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                    i = (int) (((long) i) + ((TrackRunBox) trackFragmentBox.getBoxes(TrackRunBox.class).get(0)).getSampleCount());
                }
            }
        }
        for (IsoFile fragment : this.fragments) {
            for (MovieFragmentBox moof2 : fragment.getBoxes(MovieFragmentBox.class)) {
                for (TrackFragmentBox trackFragmentBox2 : moof2.getBoxes(TrackFragmentBox.class)) {
                    if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                        i = (int) (((long) i) + ((TrackRunBox) trackFragmentBox2.getBoxes(TrackRunBox.class).get(0)).getSampleCount());
                    }
                }
            }
        }
        this.size_ = i;
        return i;
    }
}
