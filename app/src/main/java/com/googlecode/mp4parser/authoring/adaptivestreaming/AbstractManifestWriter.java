package com.googlecode.mp4parser.authoring.adaptivestreaming;

import com.coremedia.iso.boxes.OriginalFormatBox;
import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public abstract class AbstractManifestWriter implements ManifestWriter {
    private static final Logger LOG = Logger.getLogger(AbstractManifestWriter.class.getName());
    protected long[] audioFragmentsDurations;
    private FragmentIntersectionFinder intersectionFinder;
    protected long[] videoFragmentsDurations;

    protected AbstractManifestWriter(FragmentIntersectionFinder intersectionFinder) {
        this.intersectionFinder = intersectionFinder;
    }

    public long[] calculateFragmentDurations(Track track, Movie movie) {
        long[] startSamples = this.intersectionFinder.sampleNumbers(track);
        long[] durations = new long[startSamples.length];
        int currentFragment = 0;
        int currentSample = 1;
        for (long delta : track.getSampleDurations()) {
            int max = currentSample + 1;
            while (currentSample < max) {
                if (currentFragment != startSamples.length - 1 && ((long) currentSample) == startSamples[currentFragment + 1]) {
                    currentFragment++;
                }
                durations[currentFragment] = durations[currentFragment] + delta;
                currentSample++;
            }
        }
        return durations;
    }

    public long getBitrate(Track track) {
        long bitrate = 0;
        for (Sample sample : track.getSamples()) {
            bitrate += sample.getSize();
        }
        return ((long) (((double) bitrate) / (((double) track.getDuration()) / ((double) track.getTrackMetaData().getTimescale())))) * 8;
    }

    protected long[] checkFragmentsAlign(long[] referenceTimes, long[] checkTimes) throws IOException {
        if (!(referenceTimes == null || referenceTimes.length == 0)) {
            long[] referenceTimesMinusLast = new long[(referenceTimes.length - 1)];
            System.arraycopy(referenceTimes, 0, referenceTimesMinusLast, 0, referenceTimes.length - 1);
            long[] checkTimesMinusLast = new long[(checkTimes.length - 1)];
            System.arraycopy(checkTimes, 0, checkTimesMinusLast, 0, checkTimes.length - 1);
            if (!Arrays.equals(checkTimesMinusLast, referenceTimesMinusLast)) {
                String log = new StringBuilder(String.valueOf("" + referenceTimes.length)).append("Reference     :  [").toString();
                for (long l : referenceTimes) {
                    log = new StringBuilder(String.valueOf(log)).append(String.format("%10d,", new Object[]{Long.valueOf(l)})).toString();
                }
                LOG.warning(new StringBuilder(String.valueOf(log)).append("]").toString());
                log = new StringBuilder(String.valueOf("" + checkTimes.length)).append("Current       :  [").toString();
                for (long l2 : checkTimes) {
                    log = new StringBuilder(String.valueOf(log)).append(String.format("%10d,", new Object[]{Long.valueOf(l2)})).toString();
                }
                LOG.warning(new StringBuilder(String.valueOf(log)).append("]").toString());
                throw new IOException("Track does not have the same fragment borders as its predecessor.");
            }
        }
        return checkTimes;
    }

    protected String getFormat(AbstractSampleEntry se) {
        String type = se.getType();
        if (type.equals(VisualSampleEntry.TYPE_ENCRYPTED) || type.equals(AudioSampleEntry.TYPE_ENCRYPTED) || type.equals(VisualSampleEntry.TYPE_ENCRYPTED)) {
            return ((OriginalFormatBox) se.getBoxes(OriginalFormatBox.class, true).get(0)).getDataFormat();
        }
        return type;
    }
}
