package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.AbstractMediaHeaderBox;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample.Entry;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.SampleFlags;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.mdat.SampleList;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.boxes.cenc.CencSampleAuxiliaryDataFormat;
import com.googlecode.mp4parser.boxes.ultraviolet.SampleEncryptionBox;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Mp4TrackImpl extends AbstractTrack {
    private List<Entry> compositionTimeEntries;
    private long[] decodingTimes;
    private String handler;
    private AbstractMediaHeaderBox mihd;
    private List<SampleDependencyTypeBox.Entry> sampleDependencies;
    private SampleDescriptionBox sampleDescriptionBox;
    private List<CencSampleAuxiliaryDataFormat> sampleEncryptionEntries;
    private List<Sample> samples;
    private long[] syncSamples = new long[0];
    private TrackMetaData trackMetaData = new TrackMetaData();

    public Mp4TrackImpl(TrackBox trackBox, IsoFile... fragments) {
        long trackId = trackBox.getTrackHeaderBox().getTrackId();
        this.samples = new SampleList(trackBox, fragments);
        SampleTableBox stbl = trackBox.getMediaBox().getMediaInformationBox().getSampleTableBox();
        this.handler = trackBox.getMediaBox().getHandlerBox().getHandlerType();
        this.mihd = trackBox.getMediaBox().getMediaInformationBox().getMediaHeaderBox();
        List<TimeToSampleBox.Entry> decodingTimeEntries = new ArrayList();
        this.compositionTimeEntries = new ArrayList();
        this.sampleDependencies = new ArrayList();
        this.sampleEncryptionEntries = new ArrayList();
        decodingTimeEntries.addAll(stbl.getTimeToSampleBox().getEntries());
        if (stbl.getCompositionTimeToSample() != null) {
            this.compositionTimeEntries.addAll(stbl.getCompositionTimeToSample().getEntries());
        }
        if (stbl.getSampleDependencyTypeBox() != null) {
            this.sampleDependencies.addAll(stbl.getSampleDependencyTypeBox().getEntries());
        }
        if (stbl.getSyncSampleBox() != null) {
            this.syncSamples = stbl.getSyncSampleBox().getSampleNumber();
        }
        this.sampleDescriptionBox = stbl.getSampleDescriptionBox();
        List<MovieExtendsBox> movieExtendsBoxes = trackBox.getParent().getBoxes(MovieExtendsBox.class);
        if (movieExtendsBoxes.size() > 0) {
            for (MovieExtendsBox mvex : movieExtendsBoxes) {
                for (TrackExtendsBox trex : mvex.getBoxes(TrackExtendsBox.class)) {
                    if (trex.getTrackId() == trackId) {
                        List<Long> syncSampleList = new LinkedList();
                        long sampleNumber = 1;
                        for (MovieFragmentBox movieFragmentBox : ((Box) trackBox.getParent()).getParent().getBoxes(MovieFragmentBox.class)) {
                            for (TrackFragmentBox traf : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                                if (traf.getTrackFragmentHeaderBox().getTrackId() == trackId) {
                                    for (SampleEncryptionBox senc : traf.getBoxes(SampleEncryptionBox.class)) {
                                        this.sampleEncryptionEntries.addAll(senc.getEntries());
                                    }
                                    for (TrackRunBox trun : traf.getBoxes(TrackRunBox.class)) {
                                        TrackFragmentHeaderBox tfhd = ((TrackFragmentBox) trun.getParent()).getTrackFragmentHeaderBox();
                                        boolean first = true;
                                        for (TrackRunBox.Entry entry : trun.getEntries()) {
                                            SampleFlags sampleFlags;
                                            if (trun.isSampleDurationPresent()) {
                                                if (decodingTimeEntries.size() == 0 || ((TimeToSampleBox.Entry) decodingTimeEntries.get(decodingTimeEntries.size() - 1)).getDelta() != entry.getSampleDuration()) {
                                                    decodingTimeEntries.add(new TimeToSampleBox.Entry(1, entry.getSampleDuration()));
                                                } else {
                                                    TimeToSampleBox.Entry e = (TimeToSampleBox.Entry) decodingTimeEntries.get(decodingTimeEntries.size() - 1);
                                                    e.setCount(e.getCount() + 1);
                                                }
                                            } else if (tfhd.hasDefaultSampleDuration()) {
                                                decodingTimeEntries.add(new TimeToSampleBox.Entry(1, tfhd.getDefaultSampleDuration()));
                                            } else {
                                                decodingTimeEntries.add(new TimeToSampleBox.Entry(1, trex.getDefaultSampleDuration()));
                                            }
                                            if (trun.isSampleCompositionTimeOffsetPresent()) {
                                                if (this.compositionTimeEntries.size() != 0) {
                                                    if (((long) ((Entry) this.compositionTimeEntries.get(this.compositionTimeEntries.size() - 1)).getOffset()) == entry.getSampleCompositionTimeOffset()) {
                                                        Entry e2 = (Entry) this.compositionTimeEntries.get(this.compositionTimeEntries.size() - 1);
                                                        e2.setCount(e2.getCount() + 1);
                                                    }
                                                }
                                                this.compositionTimeEntries.add(new Entry(1, CastUtils.l2i(entry.getSampleCompositionTimeOffset())));
                                            }
                                            if (trun.isSampleFlagsPresent()) {
                                                sampleFlags = entry.getSampleFlags();
                                            } else if (first && trun.isFirstSampleFlagsPresent()) {
                                                sampleFlags = trun.getFirstSampleFlags();
                                            } else if (tfhd.hasDefaultSampleFlags()) {
                                                sampleFlags = tfhd.getDefaultSampleFlags();
                                            } else {
                                                sampleFlags = trex.getDefaultSampleFlags();
                                            }
                                            if (!(sampleFlags == null || sampleFlags.isSampleIsDifferenceSample())) {
                                                syncSampleList.add(Long.valueOf(sampleNumber));
                                            }
                                            sampleNumber++;
                                            first = false;
                                        }
                                    }
                                }
                            }
                        }
                        Object oldSS = this.syncSamples;
                        this.syncSamples = new long[(this.syncSamples.length + syncSampleList.size())];
                        System.arraycopy(oldSS, 0, this.syncSamples, 0, oldSS.length);
                        int i = oldSS.length;
                        for (Long syncSampleNumber : syncSampleList) {
                            int i2 = i + 1;
                            this.syncSamples[i] = syncSampleNumber.longValue();
                            i = i2;
                        }
                    }
                }
            }
        }
        this.decodingTimes = TimeToSampleBox.blowupTimeToSamples(decodingTimeEntries);
        MediaHeaderBox mdhd = trackBox.getMediaBox().getMediaHeaderBox();
        TrackHeaderBox tkhd = trackBox.getTrackHeaderBox();
        this.trackMetaData.setTrackId(tkhd.getTrackId());
        this.trackMetaData.setCreationTime(mdhd.getCreationTime());
        this.trackMetaData.setLanguage(mdhd.getLanguage());
        this.trackMetaData.setModificationTime(mdhd.getModificationTime());
        this.trackMetaData.setTimescale(mdhd.getTimescale());
        this.trackMetaData.setHeight(tkhd.getHeight());
        this.trackMetaData.setWidth(tkhd.getWidth());
        this.trackMetaData.setLayer(tkhd.getLayer());
        this.trackMetaData.setMatrix(tkhd.getMatrix());
        this.trackMetaData.setEditList((EditListBox) Path.getPath((AbstractContainerBox) trackBox, "edts/elst"));
    }

    public List<Sample> getSamples() {
        return this.samples;
    }

    public synchronized long[] getSampleDurations() {
        return this.decodingTimes;
    }

    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    public List<Entry> getCompositionTimeEntries() {
        return this.compositionTimeEntries;
    }

    public long[] getSyncSamples() {
        if (this.syncSamples.length == this.samples.size()) {
            return null;
        }
        return this.syncSamples;
    }

    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return this.sampleDependencies;
    }

    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    public String getHandler() {
        return this.handler;
    }

    public AbstractMediaHeaderBox getMediaHeaderBox() {
        return this.mihd;
    }

    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }

    public List<CencSampleAuxiliaryDataFormat> getSampleEncryptionEntries() {
        return this.sampleEncryptionEntries;
    }

    public String toString() {
        return "Mp4TrackImpl{handler='" + this.handler + '\'' + '}';
    }
}
