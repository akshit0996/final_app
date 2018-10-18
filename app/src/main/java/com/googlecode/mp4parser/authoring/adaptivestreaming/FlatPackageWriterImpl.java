package com.googlecode.mp4parser.authoring.adaptivestreaming;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder;
import com.googlecode.mp4parser.authoring.builder.FragmentedMp4Builder;
import com.googlecode.mp4parser.authoring.builder.SyncSampleIntersectFinderImpl;
import com.googlecode.mp4parser.authoring.tracks.ChangeTimeScaleTrack;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class FlatPackageWriterImpl implements PackageWriter {
    static final /* synthetic */ boolean $assertionsDisabled = (!FlatPackageWriterImpl.class.desiredAssertionStatus());
    private static Logger LOG = Logger.getLogger(FlatPackageWriterImpl.class.getName());
    private boolean debugOutput;
    FragmentIntersectionFinder intersectionFinder;
    private FragmentedMp4Builder ismvBuilder;
    ManifestWriter manifestWriter;
    private File outputDirectory;
    long timeScale = 10000000;

    public void setIntersectionFinder(FragmentIntersectionFinder intersectionFinder) {
        this.intersectionFinder = intersectionFinder;
    }

    public FlatPackageWriterImpl(int minFragmentDuration) {
    }

    public void setOutputDirectory(File outputDirectory) {
        if ($assertionsDisabled || outputDirectory.isDirectory()) {
            this.outputDirectory = outputDirectory;
            return;
        }
        throw new AssertionError();
    }

    public void setDebugOutput(boolean debugOutput) {
        this.debugOutput = debugOutput;
    }

    public void setIsmvBuilder(FragmentedMp4Builder ismvBuilder) {
        this.ismvBuilder = ismvBuilder;
        this.manifestWriter = new FlatManifestWriterImpl(ismvBuilder.getFragmentIntersectionFinder());
    }

    public void setManifestWriter(ManifestWriter manifestWriter) {
        this.manifestWriter = manifestWriter;
    }

    public void write(Movie source) throws IOException {
        if (this.intersectionFinder == null) {
            Track refTrack = null;
            for (Track track : source.getTracks()) {
                if (track.getHandler().equals("vide")) {
                    refTrack = track;
                    break;
                }
            }
            this.intersectionFinder = new SyncSampleIntersectFinderImpl(source, refTrack, -1);
        }
        if (this.ismvBuilder == null) {
            this.ismvBuilder = new FragmentedMp4Builder();
        }
        this.ismvBuilder.setIntersectionFinder(this.intersectionFinder);
        this.manifestWriter = new FlatManifestWriterImpl(this.intersectionFinder);
        if (this.debugOutput) {
            this.outputDirectory.mkdirs();
            Container muxed = new DefaultMp4Builder().build(source);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.outputDirectory, "debug_1_muxed.mp4"));
            muxed.writeContainer(fileOutputStream.getChannel());
            fileOutputStream.close();
        }
        Movie movieWithAdjustedTimescale = correctTimescale(removeUnknownTracks(source));
        if (this.debugOutput) {
            muxed = new DefaultMp4Builder().build(movieWithAdjustedTimescale);
            fileOutputStream = new FileOutputStream(new File(this.outputDirectory, "debug_2_timescale.mp4"));
            muxed.writeContainer(fileOutputStream.getChannel());
            fileOutputStream.close();
        }
        Container isoFile = this.ismvBuilder.build(movieWithAdjustedTimescale);
        if (this.debugOutput) {
            FileOutputStream allQualis = new FileOutputStream(new File(this.outputDirectory, "debug_3_fragmented.mp4"));
            isoFile.writeContainer(allQualis.getChannel());
            allQualis.close();
        }
        for (Track track2 : movieWithAdjustedTimescale.getTracks()) {
            String bitrate = Long.toString(this.manifestWriter.getBitrate(track2));
            long trackId = track2.getTrackMetaData().getTrackId();
            Iterator<Box> boxIt = isoFile.getBoxes().iterator();
            File file;
            if (track2.getMediaHeaderBox() instanceof SoundMediaHeaderBox) {
                file = new File(this.outputDirectory, "audio");
            } else if (track2.getMediaHeaderBox() instanceof VideoMediaHeaderBox) {
                file = new File(this.outputDirectory, "video");
            } else {
                System.err.println("Skipping Track with handler " + track2.getHandler() + " and " + track2.getMediaHeaderBox().getClass().getSimpleName());
            }
            File bitRateOutputDir = new File(mediaOutDir, bitrate);
            bitRateOutputDir.mkdirs();
            LOG.finer("Created : " + bitRateOutputDir.getCanonicalPath());
            long[] fragmentTimes = this.manifestWriter.calculateFragmentDurations(track2, movieWithAdjustedTimescale);
            long startTime = 0;
            int currentFragment = 0;
            while (boxIt.hasNext()) {
                Box b = (Box) boxIt.next();
                if (b instanceof MovieFragmentBox) {
                    if (!$assertionsDisabled && ((MovieFragmentBox) b).getTrackCount() != 1) {
                        throw new AssertionError();
                    } else if (((MovieFragmentBox) b).getTrackNumbers()[0] == trackId) {
                        FileOutputStream fos = new FileOutputStream(new File(bitRateOutputDir, Long.toString(startTime)));
                        int currentFragment2 = currentFragment + 1;
                        startTime += fragmentTimes[currentFragment];
                        FileChannel fc = fos.getChannel();
                        Box mdat = (Box) boxIt.next();
                        if (!$assertionsDisabled) {
                            if (!mdat.getType().equals(MediaDataBox.TYPE)) {
                                throw new AssertionError();
                            }
                        }
                        b.getBox(fc);
                        mdat.getBox(fc);
                        fc.truncate(fc.position());
                        fc.close();
                        currentFragment = currentFragment2;
                    } else {
                        continue;
                    }
                }
            }
            continue;
        }
        FileWriter fileWriter = new FileWriter(new File(this.outputDirectory, "Manifest"));
        fileWriter.write(this.manifestWriter.getManifest(movieWithAdjustedTimescale));
        fileWriter.close();
    }

    private Movie removeUnknownTracks(Movie source) {
        List<Track> tracks = new LinkedList();
        for (Track track : source.getTracks()) {
            if ("vide".equals(track.getHandler()) || "soun".equals(track.getHandler())) {
                tracks.add(track);
            } else {
                LOG.fine("Removed track " + track);
            }
        }
        source.setTracks(tracks);
        return source;
    }

    public Movie correctTimescale(Movie movie) {
        List<Track> tracks = new LinkedList();
        for (Track track : movie.getTracks()) {
            tracks.add(new ChangeTimeScaleTrack(track, this.timeScale, this.ismvBuilder.getFragmentIntersectionFinder().sampleNumbers(track)));
        }
        movie.setTracks(tracks);
        return movie;
    }
}
