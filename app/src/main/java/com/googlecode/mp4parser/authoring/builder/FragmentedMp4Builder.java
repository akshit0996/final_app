package com.googlecode.mp4parser.authoring.builder;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.ProgressiveDownloadInformationBox;
import com.coremedia.iso.boxes.ProgressiveDownloadInformationBox.Entry;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessOffsetBox;
import com.coremedia.iso.boxes.fragment.SampleFlags;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class FragmentedMp4Builder implements Mp4Builder {
    private static final Logger LOG = Logger.getLogger(FragmentedMp4Builder.class.getName());
    protected FragmentIntersectionFinder intersectionFinder;

    public Date getDate() {
        return new Date();
    }

    public List<String> getAllowedHandlers() {
        return Arrays.asList(new String[]{"soun", "vide"});
    }

    public Box createFtyp(Movie movie) {
        List<String> minorBrands = new LinkedList();
        minorBrands.add("isom");
        minorBrands.add("iso2");
        minorBrands.add(VisualSampleEntry.TYPE3);
        return new FileTypeBox("isom", 0, minorBrands);
    }

    protected List<Track> sortTracksInSequence(List<Track> tracks, final int cycle, final Map<Track, long[]> intersectionMap) {
        List<Track> tracks2 = new LinkedList(tracks);
        Collections.sort(tracks2, new Comparator<Track>() {
            public int compare(Track o1, Track o2) {
                int i;
                long startSample1 = ((long[]) intersectionMap.get(o1))[cycle];
                long startSample2 = ((long[]) intersectionMap.get(o2))[cycle];
                long[] decTimes1 = o1.getSampleDurations();
                long[] decTimes2 = o2.getSampleDurations();
                long startTime1 = 0;
                long startTime2 = 0;
                for (i = 1; ((long) i) < startSample1; i++) {
                    startTime1 += decTimes1[i - 1];
                }
                for (i = 1; ((long) i) < startSample2; i++) {
                    startTime2 += decTimes2[i - 1];
                }
                return (int) (((((double) startTime1) / ((double) o1.getTrackMetaData().getTimescale())) - (((double) startTime2) / ((double) o2.getTrackMetaData().getTimescale()))) * 100.0d);
            }
        });
        return tracks2;
    }

    protected Box createPdin(Movie movie) {
        ProgressiveDownloadInformationBox pdin = new ProgressiveDownloadInformationBox();
        LinkedList<Entry> entries = new LinkedList();
        double size = 0.0d;
        long durationInSeconds = 0;
        for (Track track : movie.getTracks()) {
            long tracksDuration = track.getDuration() / track.getTrackMetaData().getTimescale();
            if (tracksDuration > durationInSeconds) {
                durationInSeconds = tracksDuration;
            }
            List<Sample> samples = track.getSamples();
            if (samples.size() < 10000) {
                for (Sample sample : samples) {
                    size += (double) sample.getSize();
                }
            } else {
                long _size = 0;
                for (int i = 0; i < 10000; i++) {
                    _size += ((Sample) samples.get(i)).getSize();
                }
                size += (double) ((((long) samples.size()) * _size) / 10000);
            }
        }
        double byteRate = (size * 1.2d) / ((double) durationInSeconds);
        long dlRate = 10000;
        do {
            long waitTimeMilliseconds = Math.round(((((double) durationInSeconds) * byteRate) / ((double) dlRate)) - ((double) durationInSeconds)) * 1000;
            entries.add(new Entry(dlRate, waitTimeMilliseconds > 0 ? 3000 + waitTimeMilliseconds : 0));
            dlRate *= 2;
        } while (byteRate > ((double) dlRate));
        pdin.setEntries(entries);
        return pdin;
    }

    protected List<Box> createMoofMdat(Movie movie) {
        List<Box> moofsMdats = new LinkedList();
        HashMap<Track, long[]> intersectionMap = new HashMap();
        int maxNumberOfFragments = 0;
        for (Track track : movie.getTracks()) {
            long[] intersects = this.intersectionFinder.sampleNumbers(track);
            intersectionMap.put(track, intersects);
            maxNumberOfFragments = Math.max(maxNumberOfFragments, intersects.length);
        }
        int sequence = 1;
        for (int cycle = 0; cycle < maxNumberOfFragments; cycle++) {
            for (Track track2 : sortTracksInSequence(movie.getTracks(), cycle, intersectionMap)) {
                if (getAllowedHandlers().isEmpty() || getAllowedHandlers().contains(track2.getHandler())) {
                    sequence = createFragment(moofsMdats, track2, (long[]) intersectionMap.get(track2), cycle, sequence);
                }
            }
        }
        return moofsMdats;
    }

    protected int createFragment(List<Box> moofsMdats, Track track, long[] startSamples, int cycle, int sequence) {
        if (cycle >= startSamples.length) {
            return sequence;
        }
        long startSample = startSamples[cycle];
        long endSample = cycle + 1 < startSamples.length ? startSamples[cycle + 1] : (long) (track.getSamples().size() + 1);
        if (startSample == endSample) {
            return sequence;
        }
        moofsMdats.add(createMoof(startSample, endSample, track, sequence));
        int sequence2 = sequence + 1;
        moofsMdats.add(createMdat(startSample, endSample, track, sequence));
        return sequence2;
    }

    public Container build(Movie movie) {
        LOG.fine("Creating movie " + movie);
        if (this.intersectionFinder == null) {
            Track refTrack = null;
            for (Track track : movie.getTracks()) {
                if (track.getHandler().equals("vide")) {
                    refTrack = track;
                    break;
                }
            }
            this.intersectionFinder = new SyncSampleIntersectFinderImpl(movie, refTrack, -1);
        }
        BasicContainer isoFile = new BasicContainer();
        isoFile.addBox(createFtyp(movie));
        isoFile.addBox(createMoov(movie));
        for (Box box : createMoofMdat(movie)) {
            isoFile.addBox(box);
        }
        isoFile.addBox(createMfra(movie, isoFile));
        return isoFile;
    }

    protected Box createMdat(long startSample, long endSample, Track track, int i) {
        final long j = startSample;
        final long j2 = endSample;
        final Track track2 = track;
        final int i2 = i;
        return new Box() {
            Container parent;
            long size_ = -1;

            public Container getParent() {
                return this.parent;
            }

            public long getOffset() {
                throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
            }

            public void setParent(Container parent) {
                this.parent = parent;
            }

            public long getSize() {
                if (this.size_ != -1) {
                    return this.size_;
                }
                long size = 8;
                for (Sample sample : FragmentedMp4Builder.this.getSamples(j, j2, track2, i2)) {
                    size += sample.getSize();
                }
                this.size_ = size;
                return size;
            }

            public String getType() {
                return MediaDataBox.TYPE;
            }

            public void getBox(WritableByteChannel writableByteChannel) throws IOException {
                ByteBuffer header = ByteBuffer.allocate(8);
                IsoTypeWriter.writeUInt32(header, (long) CastUtils.l2i(getSize()));
                header.put(IsoFile.fourCCtoBytes(getType()));
                header.rewind();
                writableByteChannel.write(header);
                for (Sample sample : FragmentedMp4Builder.this.getSamples(j, j2, track2, i2)) {
                    sample.writeTo(writableByteChannel);
                }
            }

            public void parse(DataSource fileChannel, ByteBuffer header, long contentSize, BoxParser boxParser) throws IOException {
            }
        };
    }

    protected Box createTfhd(long startSample, long endSample, Track track, int sequenceNumber) {
        TrackFragmentHeaderBox tfhd = new TrackFragmentHeaderBox();
        tfhd.setDefaultSampleFlags(new SampleFlags());
        tfhd.setBaseDataOffset(-1);
        tfhd.setTrackId(track.getTrackMetaData().getTrackId());
        return tfhd;
    }

    protected Box createMfhd(long startSample, long endSample, Track track, int sequenceNumber) {
        MovieFragmentHeaderBox mfhd = new MovieFragmentHeaderBox();
        mfhd.setSequenceNumber((long) sequenceNumber);
        return mfhd;
    }

    protected Box createTraf(long startSample, long endSample, Track track, int sequenceNumber) {
        TrackFragmentBox traf = new TrackFragmentBox();
        traf.addBox(createTfhd(startSample, endSample, track, sequenceNumber));
        traf.addBox(createTfdt(startSample, track));
        traf.addBox(createTrun(startSample, endSample, track, sequenceNumber));
        return traf;
    }

    protected List<Sample> getSamples(long startSample, long endSample, Track track, int sequenceNumber) {
        return track.getSamples().subList(CastUtils.l2i(startSample) - 1, CastUtils.l2i(endSample) - 1);
    }

    protected long[] getSampleSizes(long startSample, long endSample, Track track, int sequenceNumber) {
        List<Sample> samples = getSamples(startSample, endSample, track, sequenceNumber);
        long[] sampleSizes = new long[samples.size()];
        for (int i = 0; i < sampleSizes.length; i++) {
            sampleSizes[i] = ((Sample) samples.get(i)).getSize();
        }
        return sampleSizes;
    }

    protected TrackFragmentBaseMediaDecodeTimeBox createTfdt(long startSample, Track track) {
        TrackFragmentBaseMediaDecodeTimeBox tfdt = new TrackFragmentBaseMediaDecodeTimeBox();
        tfdt.setVersion(1);
        long startTime = 0;
        long[] times = track.getSampleDurations();
        for (int i = 1; ((long) i) < startSample; i++) {
            startTime += times[i];
        }
        tfdt.setBaseMediaDecodeTime(startTime);
        return tfdt;
    }

    protected TrackRunBox createTrun(long startSample, long endSample, Track track, int sequenceNumber) {
        int i;
        TrackRunBox trun = new TrackRunBox();
        long[] sampleSizes = getSampleSizes(startSample, endSample, track, sequenceNumber);
        trun.setSampleDurationPresent(true);
        trun.setSampleSizePresent(true);
        List<TrackRunBox.Entry> entries = new ArrayList(CastUtils.l2i(endSample - startSample));
        List<CompositionTimeToSample.Entry> compositionTimeEntries = track.getCompositionTimeEntries();
        int compositionTimeQueueIndex = 0;
        CompositionTimeToSample.Entry[] compositionTimeQueue = (compositionTimeEntries == null || compositionTimeEntries.size() <= 0) ? null : (CompositionTimeToSample.Entry[]) compositionTimeEntries.toArray(new CompositionTimeToSample.Entry[compositionTimeEntries.size()]);
        long compositionTimeEntriesLeft = (long) (compositionTimeQueue != null ? compositionTimeQueue[0].getCount() : -1);
        trun.setSampleCompositionTimeOffsetPresent(compositionTimeEntriesLeft > 0);
        for (i = 1; i < startSample; i++) {
            if (compositionTimeQueue != null) {
                compositionTimeEntriesLeft--;
                if (compositionTimeEntriesLeft == 0 && compositionTimeQueue.length - compositionTimeQueueIndex > 1) {
                    compositionTimeQueueIndex++;
                    compositionTimeEntriesLeft = (long) compositionTimeQueue[compositionTimeQueueIndex].getCount();
                }
            }
        }
        boolean sampleFlagsRequired = ((track.getSampleDependencies() == null || track.getSampleDependencies().isEmpty()) && (track.getSyncSamples() == null || track.getSyncSamples().length == 0)) ? false : true;
        trun.setSampleFlagsPresent(sampleFlagsRequired);
        for (i = 0; i < sampleSizes.length; i++) {
            TrackRunBox.Entry entry = new TrackRunBox.Entry();
            entry.setSampleSize(sampleSizes[i]);
            if (sampleFlagsRequired) {
                SampleFlags sflags = new SampleFlags();
                if (!(track.getSampleDependencies() == null || track.getSampleDependencies().isEmpty())) {
                    SampleDependencyTypeBox.Entry e = (SampleDependencyTypeBox.Entry) track.getSampleDependencies().get(i);
                    sflags.setSampleDependsOn(e.getSampleDependsOn());
                    sflags.setSampleIsDependedOn(e.getSampleIsDependentOn());
                    sflags.setSampleHasRedundancy(e.getSampleHasRedundancy());
                }
                if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                    if (Arrays.binarySearch(track.getSyncSamples(), ((long) i) + startSample) >= 0) {
                        sflags.setSampleIsDifferenceSample(false);
                        sflags.setSampleDependsOn(2);
                    } else {
                        sflags.setSampleIsDifferenceSample(true);
                        sflags.setSampleDependsOn(1);
                    }
                }
                entry.setSampleFlags(sflags);
            }
            entry.setSampleDuration(track.getSampleDurations()[CastUtils.l2i((((long) i) + startSample) - 1)]);
            if (compositionTimeQueue != null) {
                entry.setSampleCompositionTimeOffset(compositionTimeQueue[compositionTimeQueueIndex].getOffset());
                compositionTimeEntriesLeft--;
                if (compositionTimeEntriesLeft == 0 && compositionTimeQueue.length - compositionTimeQueueIndex > 1) {
                    compositionTimeQueueIndex++;
                    compositionTimeEntriesLeft = (long) compositionTimeQueue[compositionTimeQueueIndex].getCount();
                }
            }
            entries.add(entry);
        }
        trun.setEntries(entries);
        return trun;
    }

    protected Box createMoof(long startSample, long endSample, Track track, int sequenceNumber) {
        MovieFragmentBox moof = new MovieFragmentBox();
        moof.addBox(createMfhd(startSample, endSample, track, sequenceNumber));
        moof.addBox(createTraf(startSample, endSample, track, sequenceNumber));
        TrackRunBox firstTrun = (TrackRunBox) moof.getTrackRunBoxes().get(0);
        firstTrun.setDataOffset(1);
        firstTrun.setDataOffset((int) (8 + moof.getSize()));
        return moof;
    }

    protected Box createMvhd(Movie movie) {
        MovieHeaderBox mvhd = new MovieHeaderBox();
        mvhd.setVersion(1);
        mvhd.setCreationTime(getDate());
        mvhd.setModificationTime(getDate());
        mvhd.setDuration(0);
        mvhd.setTimescale(movie.getTimescale());
        long nextTrackId = 0;
        for (Track track : movie.getTracks()) {
            if (nextTrackId < track.getTrackMetaData().getTrackId()) {
                nextTrackId = track.getTrackMetaData().getTrackId();
            }
        }
        mvhd.setNextTrackId(nextTrackId + 1);
        return mvhd;
    }

    protected Box createMoov(Movie movie) {
        MovieBox movieBox = new MovieBox();
        movieBox.addBox(createMvhd(movie));
        for (Track track : movie.getTracks()) {
            movieBox.addBox(createTrak(track, movie));
        }
        movieBox.addBox(createMvex(movie));
        return movieBox;
    }

    protected Box createTfra(Track track, Container isoFile) {
        TrackFragmentRandomAccessBox tfra = new TrackFragmentRandomAccessBox();
        tfra.setVersion(1);
        List<TrackFragmentRandomAccessBox.Entry> offset2timeEntries = new LinkedList();
        TrackExtendsBox trex = null;
        for (Box innerTrex : Path.getPaths(isoFile, "moov/mvex/trex")) {
            if (((TrackExtendsBox) innerTrex).getTrackId() == track.getTrackMetaData().getTrackId()) {
                trex = (TrackExtendsBox) innerTrex;
            }
        }
        long offset = 0;
        long duration = 0;
        for (Box box : isoFile.getBoxes()) {
            if (box instanceof MovieFragmentBox) {
                List<TrackFragmentBox> trafs = ((MovieFragmentBox) box).getBoxes(TrackFragmentBox.class);
                for (int i = 0; i < trafs.size(); i++) {
                    TrackFragmentBox traf = (TrackFragmentBox) trafs.get(i);
                    if (traf.getTrackFragmentHeaderBox().getTrackId() == track.getTrackMetaData().getTrackId()) {
                        List<TrackRunBox> truns = traf.getBoxes(TrackRunBox.class);
                        for (int j = 0; j < truns.size(); j++) {
                            List<TrackFragmentRandomAccessBox.Entry> offset2timeEntriesThisTrun = new LinkedList();
                            TrackRunBox trun = (TrackRunBox) truns.get(j);
                            for (int k = 0; k < trun.getEntries().size(); k++) {
                                SampleFlags sf;
                                TrackRunBox.Entry trunEntry = (TrackRunBox.Entry) trun.getEntries().get(k);
                                if (k == 0 && trun.isFirstSampleFlagsPresent()) {
                                    sf = trun.getFirstSampleFlags();
                                } else if (trun.isSampleFlagsPresent()) {
                                    sf = trunEntry.getSampleFlags();
                                } else {
                                    sf = trex.getDefaultSampleFlags();
                                }
                                if (sf == null && track.getHandler().equals("vide")) {
                                    throw new RuntimeException("Cannot find SampleFlags for video track but it's required to build tfra");
                                }
                                if (sf == null || sf.getSampleDependsOn() == 2) {
                                    offset2timeEntriesThisTrun.add(new TrackFragmentRandomAccessBox.Entry(duration, offset, (long) (i + 1), (long) (j + 1), (long) (k + 1)));
                                }
                                duration += trunEntry.getSampleDuration();
                            }
                            if (offset2timeEntriesThisTrun.size() != trun.getEntries().size() || trun.getEntries().size() <= 0) {
                                offset2timeEntries.addAll(offset2timeEntriesThisTrun);
                            } else {
                                offset2timeEntries.add((TrackFragmentRandomAccessBox.Entry) offset2timeEntriesThisTrun.get(0));
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
            offset += box.getSize();
        }
        tfra.setEntries(offset2timeEntries);
        tfra.setTrackId(track.getTrackMetaData().getTrackId());
        return tfra;
    }

    protected Box createMfra(Movie movie, Container isoFile) {
        MovieFragmentRandomAccessBox mfra = new MovieFragmentRandomAccessBox();
        for (Track track : movie.getTracks()) {
            mfra.addBox(createTfra(track, isoFile));
        }
        MovieFragmentRandomAccessOffsetBox mfro = new MovieFragmentRandomAccessOffsetBox();
        mfra.addBox(mfro);
        mfro.setMfraSize(mfra.getSize());
        return mfra;
    }

    protected Box createTrex(Movie movie, Track track) {
        TrackExtendsBox trex = new TrackExtendsBox();
        trex.setTrackId(track.getTrackMetaData().getTrackId());
        trex.setDefaultSampleDescriptionIndex(1);
        trex.setDefaultSampleDuration(0);
        trex.setDefaultSampleSize(0);
        SampleFlags sf = new SampleFlags();
        if ("soun".equals(track.getHandler()) || "subt".equals(track.getHandler())) {
            sf.setSampleDependsOn(2);
            sf.setSampleIsDependedOn(2);
        }
        trex.setDefaultSampleFlags(sf);
        return trex;
    }

    protected Box createMvex(Movie movie) {
        MovieExtendsBox mvex = new MovieExtendsBox();
        MovieExtendsHeaderBox mved = new MovieExtendsHeaderBox();
        mved.setVersion(1);
        for (Track track : movie.getTracks()) {
            long trackDuration = getTrackDuration(movie, track);
            if (mved.getFragmentDuration() < trackDuration) {
                mved.setFragmentDuration(trackDuration);
            }
        }
        mvex.addBox(mved);
        for (Track track2 : movie.getTracks()) {
            mvex.addBox(createTrex(movie, track2));
        }
        return mvex;
    }

    protected Box createTkhd(Movie movie, Track track) {
        TrackHeaderBox tkhd = new TrackHeaderBox();
        tkhd.setVersion(1);
        tkhd.setFlags(7);
        tkhd.setAlternateGroup(track.getTrackMetaData().getGroup());
        tkhd.setCreationTime(track.getTrackMetaData().getCreationTime());
        tkhd.setDuration(0);
        tkhd.setHeight(track.getTrackMetaData().getHeight());
        tkhd.setWidth(track.getTrackMetaData().getWidth());
        tkhd.setLayer(track.getTrackMetaData().getLayer());
        tkhd.setModificationTime(getDate());
        tkhd.setTrackId(track.getTrackMetaData().getTrackId());
        tkhd.setVolume(track.getTrackMetaData().getVolume());
        return tkhd;
    }

    private long getTrackDuration(Movie movie, Track track) {
        return (track.getDuration() * movie.getTimescale()) / track.getTrackMetaData().getTimescale();
    }

    protected Box createMdhd(Movie movie, Track track) {
        MediaHeaderBox mdhd = new MediaHeaderBox();
        mdhd.setCreationTime(track.getTrackMetaData().getCreationTime());
        mdhd.setModificationTime(getDate());
        mdhd.setDuration(0);
        mdhd.setTimescale(track.getTrackMetaData().getTimescale());
        mdhd.setLanguage(track.getTrackMetaData().getLanguage());
        return mdhd;
    }

    protected Box createStbl(Movie movie, Track track) {
        SampleTableBox stbl = new SampleTableBox();
        createStsd(track, stbl);
        stbl.addBox(new TimeToSampleBox());
        stbl.addBox(new SampleToChunkBox());
        stbl.addBox(new SampleSizeBox());
        stbl.addBox(new StaticChunkOffsetBox());
        return stbl;
    }

    protected void createStsd(Track track, SampleTableBox stbl) {
        stbl.addBox(track.getSampleDescriptionBox());
    }

    protected Box createMinf(Track track, Movie movie) {
        MediaInformationBox minf = new MediaInformationBox();
        minf.addBox(track.getMediaHeaderBox());
        minf.addBox(createDinf(movie, track));
        minf.addBox(createStbl(movie, track));
        return minf;
    }

    protected Box createMdiaHdlr(Track track, Movie movie) {
        HandlerBox hdlr = new HandlerBox();
        hdlr.setHandlerType(track.getHandler());
        return hdlr;
    }

    protected Box createMdia(Track track, Movie movie) {
        MediaBox mdia = new MediaBox();
        mdia.addBox(createMdhd(movie, track));
        mdia.addBox(createMdiaHdlr(track, movie));
        mdia.addBox(createMinf(track, movie));
        return mdia;
    }

    protected Box createTrak(Track track, Movie movie) {
        LOG.fine("Creating Track " + track);
        TrackBox trackBox = new TrackBox();
        trackBox.addBox(createTkhd(movie, track));
        Box edts = createEdts(track, movie);
        if (edts != null) {
            trackBox.addBox(edts);
        }
        trackBox.addBox(createMdia(track, movie));
        return trackBox;
    }

    protected Box createEdts(Track track, Movie movie) {
        EditListBox elst = track.getTrackMetaData().getEditList();
        if (elst == null) {
            return null;
        }
        EditBox edts = new EditBox();
        edts.addBox(elst);
        return edts;
    }

    protected DataInformationBox createDinf(Movie movie, Track track) {
        DataInformationBox dinf = new DataInformationBox();
        DataReferenceBox dref = new DataReferenceBox();
        dinf.addBox(dref);
        DataEntryUrlBox url = new DataEntryUrlBox();
        url.setFlags(1);
        dref.addBox(url);
        return dinf;
    }

    public FragmentIntersectionFinder getFragmentIntersectionFinder() {
        return this.intersectionFinder;
    }

    public void setIntersectionFinder(FragmentIntersectionFinder intersectionFinder) {
        this.intersectionFinder = intersectionFinder;
    }
}
