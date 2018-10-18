package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample.Entry;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.apple.BaseMediaInfoAtom;
import com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderAtom;
import com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderTextAtom;
import com.googlecode.mp4parser.boxes.apple.QuicktimeTextSampleEntry;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class QuicktimeTextTrackImpl extends AbstractTrack {
    SampleDescriptionBox sampleDescriptionBox = new SampleDescriptionBox();
    List<Line> subs = new LinkedList();
    TrackMetaData trackMetaData = new TrackMetaData();

    public static class Line {
        long from;
        String text;
        long to;

        public Line(long from, long to, String text) {
            this.from = from;
            this.to = to;
            this.text = text;
        }

        public long getFrom() {
            return this.from;
        }

        public String getText() {
            return this.text;
        }

        public long getTo() {
            return this.to;
        }
    }

    public List<Line> getSubs() {
        return this.subs;
    }

    public QuicktimeTextTrackImpl() {
        QuicktimeTextSampleEntry textTrack = new QuicktimeTextSampleEntry();
        textTrack.setDataReferenceIndex(1);
        this.sampleDescriptionBox.addBox(textTrack);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setTimescale(1000);
    }

    public List<Sample> getSamples() {
        List<Sample> samples = new LinkedList();
        long lastEnd = 0;
        for (Line sub : this.subs) {
            long silentTime = sub.from - lastEnd;
            if (silentTime > 0) {
                samples.add(new SampleImpl(ByteBuffer.wrap(new byte[2])));
            } else if (silentTime < 0) {
                throw new Error("Subtitle display times may not intersect");
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            try {
                dos.writeShort(sub.text.getBytes("UTF-8").length);
                dos.write(sub.text.getBytes("UTF-8"));
                dos.close();
                samples.add(new SampleImpl(ByteBuffer.wrap(baos.toByteArray())));
                lastEnd = sub.to;
            } catch (IOException e) {
                throw new Error("VM is broken. Does not support UTF-8");
            }
        }
        return samples;
    }

    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    public long[] getSampleDurations() {
        List<Long> decTimes = new ArrayList();
        long lastEnd = 0;
        for (Line sub : this.subs) {
            long silentTime = sub.from - lastEnd;
            if (silentTime > 0) {
                decTimes.add(Long.valueOf(silentTime));
            } else if (silentTime < 0) {
                throw new Error("Subtitle display times may not intersect");
            }
            decTimes.add(Long.valueOf(sub.to - sub.from));
            lastEnd = sub.to;
        }
        long[] decTimesArray = new long[decTimes.size()];
        int index = 0;
        for (Long decTime : decTimes) {
            int index2 = index + 1;
            decTimesArray[index] = decTime.longValue();
            index = index2;
        }
        return decTimesArray;
    }

    public List<Entry> getCompositionTimeEntries() {
        return null;
    }

    public long[] getSyncSamples() {
        return null;
    }

    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return null;
    }

    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    public String getHandler() {
        return "text";
    }

    public Box getMediaHeaderBox() {
        GenericMediaHeaderAtom ghmd = new GenericMediaHeaderAtom();
        ghmd.addBox(new BaseMediaInfoAtom());
        ghmd.addBox(new GenericMediaHeaderTextAtom());
        return ghmd;
    }

    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }
}
