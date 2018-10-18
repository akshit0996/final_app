package com.googlecode.mp4parser.authoring.samples;

import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleToChunkBox.Entry;
import com.coremedia.iso.boxes.TrackBox;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.List;

public class DefaultMp4SampleList extends AbstractList<Sample> {
    SoftReference<ByteBuffer>[] cache = null;
    int[] chunkNumsStartSampleNum;
    long[] chunkOffsets;
    int[] chunkSizes;
    int lastChunk = 0;
    SampleSizeBox ssb;
    Container topLevel;
    TrackBox trackBox = null;

    public DefaultMp4SampleList(long track, Container topLevel) {
        this.topLevel = topLevel;
        for (TrackBox tb : ((MovieBox) topLevel.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (tb.getTrackHeaderBox().getTrackId() == track) {
                this.trackBox = tb;
            }
        }
        if (this.trackBox == null) {
            throw new RuntimeException("This MP4 does not contain track " + track);
        }
        int s2cIndex;
        int currentChunkNo;
        this.chunkOffsets = this.trackBox.getSampleTableBox().getChunkOffsetBox().getChunkOffsets();
        this.chunkSizes = new int[this.chunkOffsets.length];
        this.cache = (SoftReference[]) Array.newInstance(SoftReference.class, this.chunkOffsets.length);
        this.ssb = this.trackBox.getSampleTableBox().getSampleSizeBox();
        List<Entry> s2chunkEntries = this.trackBox.getSampleTableBox().getSampleToChunkBox().getEntries();
        Entry[] entries = (Entry[]) s2chunkEntries.toArray(new Entry[s2chunkEntries.size()]);
        int s2cIndex2 = 0 + 1;
        Entry next = entries[0];
        int currentChunkNo2 = 0;
        int currentSamplePerChunk = 0;
        long nextFirstChunk = next.getFirstChunk();
        int nextSamplePerChunk = CastUtils.l2i(next.getSamplesPerChunk());
        int currentSampleNo = 1;
        int lastSampleNo = size();
        while (true) {
            currentChunkNo2++;
            if (((long) currentChunkNo2) == nextFirstChunk) {
                currentSamplePerChunk = nextSamplePerChunk;
                if (entries.length > s2cIndex2) {
                    s2cIndex = s2cIndex2 + 1;
                    next = entries[s2cIndex2];
                    nextSamplePerChunk = CastUtils.l2i(next.getSamplesPerChunk());
                    nextFirstChunk = next.getFirstChunk();
                } else {
                    nextSamplePerChunk = -1;
                    nextFirstChunk = Long.MAX_VALUE;
                    s2cIndex = s2cIndex2;
                }
            } else {
                s2cIndex = s2cIndex2;
            }
            currentSampleNo += currentSamplePerChunk;
            if (currentSampleNo > lastSampleNo) {
                break;
            }
            s2cIndex2 = s2cIndex;
        }
        this.chunkNumsStartSampleNum = new int[(currentChunkNo2 + 1)];
        s2cIndex2 = 0 + 1;
        next = entries[0];
        currentChunkNo2 = 0;
        currentSamplePerChunk = 0;
        nextFirstChunk = next.getFirstChunk();
        nextSamplePerChunk = CastUtils.l2i(next.getSamplesPerChunk());
        currentSampleNo = 1;
        s2cIndex = s2cIndex2;
        while (true) {
            currentChunkNo = currentChunkNo2 + 1;
            this.chunkNumsStartSampleNum[currentChunkNo2] = currentSampleNo;
            if (((long) currentChunkNo) == nextFirstChunk) {
                currentSamplePerChunk = nextSamplePerChunk;
                if (entries.length > s2cIndex) {
                    s2cIndex2 = s2cIndex + 1;
                    next = entries[s2cIndex];
                    nextSamplePerChunk = CastUtils.l2i(next.getSamplesPerChunk());
                    nextFirstChunk = next.getFirstChunk();
                    s2cIndex = s2cIndex2;
                } else {
                    nextSamplePerChunk = -1;
                    nextFirstChunk = Long.MAX_VALUE;
                }
            }
            currentSampleNo += currentSamplePerChunk;
            if (currentSampleNo > lastSampleNo) {
                break;
            }
            currentChunkNo2 = currentChunkNo;
        }
        this.chunkNumsStartSampleNum[currentChunkNo] = Integer.MAX_VALUE;
        currentChunkNo2 = 0;
        for (int i = 1; ((long) i) <= this.ssb.getSampleCount(); i++) {
            if (i == this.chunkNumsStartSampleNum[currentChunkNo2]) {
                currentChunkNo2++;
            }
            int[] iArr = this.chunkSizes;
            int i2 = currentChunkNo2 - 1;
            iArr[i2] = (int) (((long) iArr[i2]) + this.ssb.getSampleSizeAtIndex(i - 1));
        }
    }

    synchronized int getChunkForSample(int index) {
        int i;
        int sampleNum = index + 1;
        if (sampleNum >= this.chunkNumsStartSampleNum[this.lastChunk] && sampleNum < this.chunkNumsStartSampleNum[this.lastChunk + 1]) {
            i = this.lastChunk;
        } else if (sampleNum < this.chunkNumsStartSampleNum[this.lastChunk]) {
            this.lastChunk = 0;
            while (this.chunkNumsStartSampleNum[this.lastChunk + 1] <= sampleNum) {
                this.lastChunk++;
            }
            i = this.lastChunk;
        } else {
            this.lastChunk++;
            while (this.chunkNumsStartSampleNum[this.lastChunk + 1] <= sampleNum) {
                this.lastChunk++;
            }
            i = this.lastChunk;
        }
        return i;
    }

    public Sample get(int index) {
        if (((long) index) >= this.ssb.getSampleCount()) {
            throw new IndexOutOfBoundsException();
        }
        int currentChunkNoZeroBased = getChunkForSample(index);
        int currentSampleNo = this.chunkNumsStartSampleNum[currentChunkNoZeroBased];
        long offset = this.chunkOffsets[CastUtils.l2i((long) currentChunkNoZeroBased)];
        ByteBuffer chunk = this.cache[CastUtils.l2i((long) currentChunkNoZeroBased)] != null ? (ByteBuffer) this.cache[CastUtils.l2i((long) currentChunkNoZeroBased)].get() : null;
        if (chunk == null) {
            try {
                chunk = this.topLevel.getByteBuffer(offset, (long) this.chunkSizes[CastUtils.l2i((long) currentChunkNoZeroBased)]);
                this.cache[CastUtils.l2i((long) currentChunkNoZeroBased)] = new SoftReference(chunk);
            } catch (IOException e) {
                throw new IndexOutOfBoundsException(e.getMessage());
            }
        }
        int offsetWithinChunk = 0;
        int currentSampleNo2 = currentSampleNo;
        while (currentSampleNo2 < index + 1) {
            offsetWithinChunk = (int) (((long) offsetWithinChunk) + this.ssb.getSampleSizeAtIndex(currentSampleNo2 - 1));
            currentSampleNo2++;
        }
        long sampleSize = this.ssb.getSampleSizeAtIndex(currentSampleNo2 - 1);
        return new SampleImpl((long) offsetWithinChunk, sampleSize, (ByteBuffer) ((ByteBuffer) chunk.position(offsetWithinChunk)).slice().limit(CastUtils.l2i(sampleSize)));
    }

    public int size() {
        return CastUtils.l2i(this.trackBox.getSampleTableBox().getSampleSizeBox().getSampleCount());
    }
}
