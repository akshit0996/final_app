package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample.Entry;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.AudioSpecificConfig;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.SLConfigDescriptor;
import com.lema.android.heartbeatlistener.sound.SoundManager;
import com.lema.android.heartbeatlistener.video.VideoCreator;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AACTrackImpl extends AbstractTrack {
    static Map<Integer, String> audioObjectTypes = new HashMap();
    public static Map<Integer, Integer> samplingFrequencyIndexMap = new HashMap();
    long avgBitRate;
    int bufferSizeDB;
    long[] decTimes;
    AdtsHeader firstHeader;
    private String lang = "eng";
    long maxBitRate;
    SampleDescriptionBox sampleDescriptionBox;
    private List<Sample> samples;
    TrackMetaData trackMetaData = new TrackMetaData();

    class AdtsHeader {
        int bufferFullness;
        int channelconfig;
        int copyrightStart;
        int copyrightedStream;
        int frameLength;
        int home;
        int layer;
        int mpegVersion;
        int numAacFramesPerAdtsFrame;
        int original;
        int profile;
        int protectionAbsent;
        int sampleFrequencyIndex;
        int sampleRate;

        AdtsHeader() {
        }

        int getSize() {
            return (this.protectionAbsent == 0 ? 2 : 0) + 7;
        }
    }

    public AACTrackImpl(DataSource channel, String lang) throws IOException {
        this.lang = lang;
        parse(channel);
    }

    public AACTrackImpl(DataSource channel) throws IOException {
        parse(channel);
    }

    private void parse(DataSource channel) throws IOException {
        this.samples = new ArrayList();
        this.firstHeader = readSamples(channel);
        double packetsPerSecond = ((double) this.firstHeader.sampleRate) / 1024.0d;
        double duration = ((double) this.samples.size()) / packetsPerSecond;
        long dataSize = 0;
        LinkedList<Integer> queue = new LinkedList();
        for (Sample sample : this.samples) {
            int size = (int) sample.getSize();
            dataSize += (long) size;
            queue.add(Integer.valueOf(size));
            while (((double) queue.size()) > packetsPerSecond) {
                queue.pop();
            }
            if (queue.size() == ((int) packetsPerSecond)) {
                int currSize = 0;
                Iterator it = queue.iterator();
                while (it.hasNext()) {
                    currSize += ((Integer) it.next()).intValue();
                }
                double currBitrate = ((8.0d * ((double) currSize)) / ((double) queue.size())) * packetsPerSecond;
                if (currBitrate > ((double) this.maxBitRate)) {
                    this.maxBitRate = (long) ((int) currBitrate);
                }
            }
        }
        this.avgBitRate = (long) ((int) (((double) (8 * dataSize)) / duration));
        this.bufferSizeDB = 1536;
        this.sampleDescriptionBox = new SampleDescriptionBox();
        AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE3);
        if (this.firstHeader.channelconfig == 7) {
            audioSampleEntry.setChannelCount(8);
        } else {
            audioSampleEntry.setChannelCount(this.firstHeader.channelconfig);
        }
        audioSampleEntry.setSampleRate((long) this.firstHeader.sampleRate);
        audioSampleEntry.setDataReferenceIndex(1);
        audioSampleEntry.setSampleSize(16);
        ESDescriptorBox esds = new ESDescriptorBox();
        ESDescriptor descriptor = new ESDescriptor();
        descriptor.setEsId(0);
        SLConfigDescriptor slConfigDescriptor = new SLConfigDescriptor();
        slConfigDescriptor.setPredefined(2);
        descriptor.setSlConfigDescriptor(slConfigDescriptor);
        DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
        decoderConfigDescriptor.setObjectTypeIndication(64);
        decoderConfigDescriptor.setStreamType(5);
        decoderConfigDescriptor.setBufferSizeDB(this.bufferSizeDB);
        decoderConfigDescriptor.setMaxBitRate(this.maxBitRate);
        decoderConfigDescriptor.setAvgBitRate(this.avgBitRate);
        AudioSpecificConfig audioSpecificConfig = new AudioSpecificConfig();
        audioSpecificConfig.setAudioObjectType(2);
        audioSpecificConfig.setSamplingFrequencyIndex(this.firstHeader.sampleFrequencyIndex);
        audioSpecificConfig.setChannelConfiguration(this.firstHeader.channelconfig);
        decoderConfigDescriptor.setAudioSpecificInfo(audioSpecificConfig);
        descriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
        ByteBuffer data = descriptor.serialize();
        esds.setEsDescriptor(descriptor);
        esds.setData(data);
        audioSampleEntry.addBox(esds);
        this.sampleDescriptionBox.addBox(audioSampleEntry);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setLanguage(this.lang);
        this.trackMetaData.setVolume(1.0f);
        this.trackMetaData.setTimescale((long) this.firstHeader.sampleRate);
        this.decTimes = new long[this.samples.size()];
        Arrays.fill(this.decTimes, 1024);
    }

    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    public long[] getSampleDurations() {
        return this.decTimes;
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
        return "soun";
    }

    public List<Sample> getSamples() {
        return this.samples;
    }

    public Box getMediaHeaderBox() {
        return new SoundMediaHeaderBox();
    }

    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }

    private AdtsHeader readADTSHeader(DataSource channel) throws IOException {
        AdtsHeader hdr = new AdtsHeader();
        ByteBuffer bb = ByteBuffer.allocate(7);
        while (bb.position() < 7) {
            if (channel.read(bb) == -1) {
                return null;
            }
        }
        BitReaderBuffer brb = new BitReaderBuffer((ByteBuffer) bb.rewind());
        if (brb.readBits(12) != 4095) {
            throw new IOException("Expected Start Word 0xfff");
        }
        hdr.mpegVersion = brb.readBits(1);
        hdr.layer = brb.readBits(2);
        hdr.protectionAbsent = brb.readBits(1);
        hdr.profile = brb.readBits(2) + 1;
        hdr.sampleFrequencyIndex = brb.readBits(4);
        hdr.sampleRate = ((Integer) samplingFrequencyIndexMap.get(Integer.valueOf(hdr.sampleFrequencyIndex))).intValue();
        brb.readBits(1);
        hdr.channelconfig = brb.readBits(3);
        hdr.original = brb.readBits(1);
        hdr.home = brb.readBits(1);
        hdr.copyrightedStream = brb.readBits(1);
        hdr.copyrightStart = brb.readBits(1);
        hdr.frameLength = brb.readBits(13);
        hdr.bufferFullness = brb.readBits(11);
        hdr.numAacFramesPerAdtsFrame = brb.readBits(2) + 1;
        if (hdr.numAacFramesPerAdtsFrame != 1) {
            throw new IOException("This muxer can only work with 1 AAC frame per ADTS frame");
        } else if (hdr.protectionAbsent != 0) {
            return hdr;
        } else {
            channel.read(ByteBuffer.allocate(2));
            return hdr;
        }
    }

    private AdtsHeader readSamples(DataSource channel) throws IOException {
        AdtsHeader first = null;
        while (true) {
            AdtsHeader hdr = readADTSHeader(channel);
            if (hdr == null) {
                return first;
            }
            if (first == null) {
                first = hdr;
            }
            ByteBuffer data = channel.map(channel.position(), (long) (hdr.frameLength - hdr.getSize()));
            this.samples.add(new SampleImpl(data));
            channel.position((channel.position() + ((long) hdr.frameLength)) - ((long) hdr.getSize()));
            data.rewind();
        }
    }

    public String toString() {
        return "AACTrackImpl{sampleRate=" + this.firstHeader.sampleRate + ", channelconfig=" + this.firstHeader.channelconfig + '}';
    }
}
