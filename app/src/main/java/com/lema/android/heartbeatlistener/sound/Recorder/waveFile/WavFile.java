package com.lema.android.heartbeatlistener.sound.Recorder.waveFile;

import android.support.v4.view.MotionEventCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class WavFile {
    private static final int BUFFER_SIZE = 4096;
    private static final int DATA_CHUNK_ID = 1635017060;
    private static final int FMT_CHUNK_ID = 544501094;
    private static final int RIFF_CHUNK_ID = 1179011410;
    private static final int RIFF_TYPE_ID = 1163280727;
    private int blockAlign;
    private byte[] buffer = new byte[4096];
    private int bufferPointer;
    private int bytesPerSample;
    private int bytesRead;
    private File file;
    private double floatOffset;
    private double floatScale;
    private long frameCounter;
    private FileInputStream iStream;
    private IOState ioState;
    private int numChannels;
    private long numFrames;
    private FileOutputStream oStream;
    private long sampleRate;
    private int validBits;
    private boolean wordAlignAdjust;

    private enum IOState {
        READING,
        WRITING,
        CLOSED
    }

    private WavFile() {
    }

    public int getNumChannels() {
        return this.numChannels;
    }

    public long getNumFrames() {
        return this.numFrames;
    }

    public long getFramesRemaining() {
        return this.numFrames - this.frameCounter;
    }

    public long getSampleRate() {
        return this.sampleRate;
    }

    public int getValidBits() {
        return this.validBits;
    }

    public static WavFile newWavFile(File file, int numChannels, long numFrames, int validBits, long sampleRate) throws IOException, WavFileException {
        WavFile wavFile = new WavFile();
        wavFile.file = file;
        wavFile.numChannels = numChannels;
        wavFile.numFrames = numFrames;
        wavFile.sampleRate = sampleRate;
        wavFile.bytesPerSample = (validBits + 7) / 8;
        wavFile.blockAlign = wavFile.bytesPerSample * numChannels;
        wavFile.validBits = validBits;
        if (numChannels < 1 || numChannels > 65535) {
            throw new WavFileException("Illegal number of channels, valid range 1 to 65536");
        } else if (numFrames < 0) {
            throw new WavFileException("Number of frames must be positive");
        } else if (validBits < 2 || validBits > 65535) {
            throw new WavFileException("Illegal number of valid bits, valid range 2 to 65536");
        } else if (sampleRate < 0) {
            throw new WavFileException("Sample rate must be positive");
        } else {
            wavFile.oStream = new FileOutputStream(file);
            long dataChunkSize = ((long) wavFile.blockAlign) * numFrames;
            long mainChunkSize = 36 + dataChunkSize;
            if (dataChunkSize % 2 == 1) {
                mainChunkSize++;
                wavFile.wordAlignAdjust = true;
            } else {
                wavFile.wordAlignAdjust = false;
            }
            putLE(1179011410, wavFile.buffer, 0, 4);
            putLE(mainChunkSize, wavFile.buffer, 4, 4);
            putLE(1163280727, wavFile.buffer, 8, 4);
            wavFile.oStream.write(wavFile.buffer, 0, 12);
            long averageBytesPerSecond = sampleRate * ((long) wavFile.blockAlign);
            putLE(544501094, wavFile.buffer, 0, 4);
            putLE(16, wavFile.buffer, 4, 4);
            putLE(1, wavFile.buffer, 8, 2);
            putLE((long) numChannels, wavFile.buffer, 10, 2);
            putLE(sampleRate, wavFile.buffer, 12, 4);
            putLE(averageBytesPerSecond, wavFile.buffer, 16, 4);
            putLE((long) wavFile.blockAlign, wavFile.buffer, 20, 2);
            putLE((long) validBits, wavFile.buffer, 22, 2);
            wavFile.oStream.write(wavFile.buffer, 0, 24);
            putLE(1635017060, wavFile.buffer, 0, 4);
            putLE(dataChunkSize, wavFile.buffer, 4, 4);
            wavFile.oStream.write(wavFile.buffer, 0, 8);
            if (wavFile.validBits > 8) {
                wavFile.floatOffset = 0.0d;
                wavFile.floatScale = (double) (Long.MAX_VALUE >> (64 - wavFile.validBits));
            } else {
                wavFile.floatOffset = 1.0d;
                wavFile.floatScale = 0.5d * ((double) ((1 << wavFile.validBits) - 1));
            }
            wavFile.bufferPointer = 0;
            wavFile.bytesRead = 0;
            wavFile.frameCounter = 0;
            wavFile.ioState = IOState.WRITING;
            return wavFile;
        }
    }

    public static WavFile openWavFile(File file) throws IOException, WavFileException {
        WavFile wavFile = new WavFile();
        wavFile.iStream = new FileInputStream(file);
        if (wavFile.iStream.read(wavFile.buffer, 0, 12) != 12) {
            throw new WavFileException("Not enough wav file bytes for header");
        }
        long riffChunkID = getLE(wavFile.buffer, 0, 4);
        long chunkSize = getLE(wavFile.buffer, 4, 4);
        long riffTypeID = getLE(wavFile.buffer, 8, 4);
        if (riffChunkID != 1179011410) {
            throw new WavFileException("Invalid Wav Header data, incorrect riff chunk ID");
        } else if (riffTypeID != 1163280727) {
            throw new WavFileException("Invalid Wav Header data, incorrect riff type ID");
        } else if (file.length() != 8 + chunkSize) {
            throw new WavFileException("Header chunk size (" + chunkSize + ") does not match file size (" + file.length() + ")");
        } else {
            boolean foundFormat = false;
            while (true) {
                int bytesRead = wavFile.iStream.read(wavFile.buffer, 0, 8);
                if (bytesRead == -1) {
                    throw new WavFileException("Reached end of file without finding format chunk");
                } else if (bytesRead != 8) {
                    throw new WavFileException("Could not read chunk header");
                } else {
                    long numChunkBytes;
                    long chunkID = getLE(wavFile.buffer, 0, 4);
                    chunkSize = getLE(wavFile.buffer, 4, 4);
                    if (chunkSize % 2 == 1) {
                        numChunkBytes = chunkSize + 1;
                    } else {
                        numChunkBytes = chunkSize;
                    }
                    if (chunkID == 544501094) {
                        foundFormat = true;
                        bytesRead = wavFile.iStream.read(wavFile.buffer, 0, 16);
                        int compressionCode = (int) getLE(wavFile.buffer, 0, 2);
                        if (compressionCode != 1) {
                            throw new WavFileException("Compression Code " + compressionCode + " not supported");
                        }
                        wavFile.numChannels = (int) getLE(wavFile.buffer, 2, 2);
                        wavFile.sampleRate = getLE(wavFile.buffer, 4, 4);
                        wavFile.blockAlign = (int) getLE(wavFile.buffer, 12, 2);
                        wavFile.validBits = (int) getLE(wavFile.buffer, 14, 2);
                        if (wavFile.numChannels == 0) {
                            throw new WavFileException("Number of channels specified in header is equal to zero");
                        } else if (wavFile.blockAlign == 0) {
                            throw new WavFileException("Block Align specified in header is equal to zero");
                        } else if (wavFile.validBits < 2) {
                            throw new WavFileException("Valid Bits specified in header is less than 2");
                        } else if (wavFile.validBits > 64) {
                            throw new WavFileException("Valid Bits specified in header is greater than 64, this is greater than a long can hold");
                        } else {
                            wavFile.bytesPerSample = (wavFile.validBits + 7) / 8;
                            if (wavFile.bytesPerSample * wavFile.numChannels != wavFile.blockAlign) {
                                throw new WavFileException("Block Align does not agree with bytes required for validBits and number of channels");
                            }
                            numChunkBytes -= 16;
                            if (numChunkBytes > 0) {
                                wavFile.iStream.skip(numChunkBytes);
                            }
                        }
                    } else if (chunkID == 1635017060) {
                        break;
                    } else {
                        wavFile.iStream.skip(numChunkBytes);
                    }
                }
            }
            if (!foundFormat) {
                throw new WavFileException("Data chunk found before Format chunk");
            } else if (chunkSize % ((long) wavFile.blockAlign) != 0) {
                throw new WavFileException("Data Chunk size is not multiple of Block Align");
            } else {
                wavFile.numFrames = chunkSize / ((long) wavFile.blockAlign);
                if (true) {
                    if (wavFile.validBits > 8) {
                        wavFile.floatOffset = 0.0d;
                        wavFile.floatScale = (double) (1 << (wavFile.validBits - 1));
                    } else {
                        wavFile.floatOffset = -1.0d;
                        wavFile.floatScale = 0.5d * ((double) ((1 << wavFile.validBits) - 1));
                    }
                    wavFile.bufferPointer = 0;
                    wavFile.bytesRead = 0;
                    wavFile.frameCounter = 0;
                    wavFile.ioState = IOState.READING;
                    return wavFile;
                }
                throw new WavFileException("Did not find a data chunk");
            }
        }
    }

    private static long getLE(byte[] buffer, int pos, int numBytes) {
        numBytes--;
        pos += numBytes;
        long val = (long) (buffer[pos] & MotionEventCompat.ACTION_MASK);
        for (int b = 0; b < numBytes; b++) {
            pos--;
            val = (val << 8) + ((long) (buffer[pos] & MotionEventCompat.ACTION_MASK));
        }
        return val;
    }

    private static void putLE(long val, byte[] buffer, int pos, int numBytes) {
        for (int b = 0; b < numBytes; b++) {
            buffer[pos] = (byte) ((int) (255 & val));
            val >>= 8;
            pos++;
        }
    }

    private void writeSample(long val) throws IOException {
        for (int b = 0; b < this.bytesPerSample; b++) {
            if (this.bufferPointer == 4096) {
                this.oStream.write(this.buffer, 0, 4096);
                this.bufferPointer = 0;
            }
            this.buffer[this.bufferPointer] = (byte) ((int) (255 & val));
            val >>= 8;
            this.bufferPointer++;
        }
    }

    private long readSample() throws IOException, WavFileException {
        long val = 0;
        for (int b = 0; b < this.bytesPerSample; b++) {
            if (this.bufferPointer == this.bytesRead) {
                int read = this.iStream.read(this.buffer, 0, 4096);
                if (read == -1) {
                    throw new WavFileException("Not enough data available");
                }
                this.bytesRead = read;
                this.bufferPointer = 0;
            }
            int v = this.buffer[this.bufferPointer];
            if (b < this.bytesPerSample - 1 || this.bytesPerSample == 1) {
                v &= MotionEventCompat.ACTION_MASK;
            }
            val += (long) (v << (b * 8));
            this.bufferPointer++;
        }
        return val;
    }

    public int readFrames(short[] sampleBuffer, int numFramesToRead) throws IOException, WavFileException {
        return readFrames(sampleBuffer, 0, numFramesToRead);
    }

    public int readFrames(short[] sampleBuffer, int offset, int numFramesToRead) throws IOException, WavFileException {
        if (this.ioState != IOState.READING) {
            throw new IOException("Cannot read from WavFile instance");
        }
        for (int f = 0; f < numFramesToRead; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                sampleBuffer[offset] = (short) ((int) readSample());
                offset++;
            }
            this.frameCounter++;
        }
        return numFramesToRead;
    }

    public int readFrames(short[][] sampleBuffer, int numFramesToRead) throws IOException, WavFileException {
        return readFrames(sampleBuffer, 0, numFramesToRead);
    }

    public int readFrames(short[][] sampleBuffer, int offset, int numFramesToRead) throws IOException, WavFileException {
        if (this.ioState != IOState.READING) {
            throw new IOException("Cannot read from WavFile instance");
        }
        for (int f = 0; f < numFramesToRead; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                sampleBuffer[c][offset] = (short) ((int) readSample());
            }
            offset++;
            this.frameCounter++;
        }
        return numFramesToRead;
    }

    public int writeFrames(short[] sampleBuffer, int numFramesToWrite) throws IOException, WavFileException {
        return writeFrames(sampleBuffer, 0, numFramesToWrite);
    }

    public int writeFrames(short[] sampleBuffer, int offset, int numFramesToWrite) throws IOException, WavFileException {
        if (this.ioState != IOState.WRITING) {
            throw new IOException("Cannot write to WavFile instance");
        }
        for (int f = 0; f < numFramesToWrite; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                writeSample((long) sampleBuffer[offset]);
                offset++;
            }
            this.frameCounter++;
        }
        return numFramesToWrite;
    }

    public int writeFrames(short[][] sampleBuffer, int numFramesToWrite) throws IOException, WavFileException {
        return writeFrames(sampleBuffer, 0, numFramesToWrite);
    }

    public int writeFrames(short[][] sampleBuffer, int offset, int numFramesToWrite) throws IOException, WavFileException {
        if (this.ioState != IOState.WRITING) {
            throw new IOException("Cannot write to WavFile instance");
        }
        for (int f = 0; f < numFramesToWrite; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                writeSample((long) sampleBuffer[c][offset]);
            }
            offset++;
            this.frameCounter++;
        }
        return numFramesToWrite;
    }

    public int readFrames(int[] sampleBuffer, int numFramesToRead) throws IOException, WavFileException {
        return readFrames(sampleBuffer, 0, numFramesToRead);
    }

    public int readFrames(int[] sampleBuffer, int offset, int numFramesToRead) throws IOException, WavFileException {
        if (this.ioState != IOState.READING) {
            throw new IOException("Cannot read from WavFile instance");
        }
        for (int f = 0; f < numFramesToRead; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                sampleBuffer[offset] = (int) readSample();
                offset++;
            }
            this.frameCounter++;
        }
        return numFramesToRead;
    }

    public int readFrames(int[][] sampleBuffer, int numFramesToRead) throws IOException, WavFileException {
        return readFrames(sampleBuffer, 0, numFramesToRead);
    }

    public int readFrames(int[][] sampleBuffer, int offset, int numFramesToRead) throws IOException, WavFileException {
        if (this.ioState != IOState.READING) {
            throw new IOException("Cannot read from WavFile instance");
        }
        for (int f = 0; f < numFramesToRead; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                sampleBuffer[c][offset] = (int) readSample();
            }
            offset++;
            this.frameCounter++;
        }
        return numFramesToRead;
    }

    public int writeFrames(int[] sampleBuffer, int numFramesToWrite) throws IOException, WavFileException {
        return writeFrames(sampleBuffer, 0, numFramesToWrite);
    }

    public int writeFrames(int[] sampleBuffer, int offset, int numFramesToWrite) throws IOException, WavFileException {
        if (this.ioState != IOState.WRITING) {
            throw new IOException("Cannot write to WavFile instance");
        }
        for (int f = 0; f < numFramesToWrite; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                writeSample((long) sampleBuffer[offset]);
                offset++;
            }
            this.frameCounter++;
        }
        return numFramesToWrite;
    }

    public int writeFrames(int[][] sampleBuffer, int numFramesToWrite) throws IOException, WavFileException {
        return writeFrames(sampleBuffer, 0, numFramesToWrite);
    }

    public int writeFrames(int[][] sampleBuffer, int offset, int numFramesToWrite) throws IOException, WavFileException {
        if (this.ioState != IOState.WRITING) {
            throw new IOException("Cannot write to WavFile instance");
        }
        for (int f = 0; f < numFramesToWrite; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                writeSample((long) sampleBuffer[c][offset]);
            }
            offset++;
            this.frameCounter++;
        }
        return numFramesToWrite;
    }

    public int readFrames(long[] sampleBuffer, int numFramesToRead) throws IOException, WavFileException {
        return readFrames(sampleBuffer, 0, numFramesToRead);
    }

    public int readFrames(long[] sampleBuffer, int offset, int numFramesToRead) throws IOException, WavFileException {
        if (this.ioState != IOState.READING) {
            throw new IOException("Cannot read from WavFile instance");
        }
        for (int f = 0; f < numFramesToRead; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                sampleBuffer[offset] = readSample();
                offset++;
            }
            this.frameCounter++;
        }
        return numFramesToRead;
    }

    public int readFrames(long[][] sampleBuffer, int numFramesToRead) throws IOException, WavFileException {
        return readFrames(sampleBuffer, 0, numFramesToRead);
    }

    public int readFrames(long[][] sampleBuffer, int offset, int numFramesToRead) throws IOException, WavFileException {
        if (this.ioState != IOState.READING) {
            throw new IOException("Cannot read from WavFile instance");
        }
        for (int f = 0; f < numFramesToRead; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                sampleBuffer[c][offset] = readSample();
            }
            offset++;
            this.frameCounter++;
        }
        return numFramesToRead;
    }

    public int writeFrames(long[] sampleBuffer, int numFramesToWrite) throws IOException, WavFileException {
        return writeFrames(sampleBuffer, 0, numFramesToWrite);
    }

    public int writeFrames(long[] sampleBuffer, int offset, int numFramesToWrite) throws IOException, WavFileException {
        if (this.ioState != IOState.WRITING) {
            throw new IOException("Cannot write to WavFile instance");
        }
        for (int f = 0; f < numFramesToWrite; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                writeSample(sampleBuffer[offset]);
                offset++;
            }
            this.frameCounter++;
        }
        return numFramesToWrite;
    }

    public int writeFrames(long[][] sampleBuffer, int numFramesToWrite) throws IOException, WavFileException {
        return writeFrames(sampleBuffer, 0, numFramesToWrite);
    }

    public int writeFrames(long[][] sampleBuffer, int offset, int numFramesToWrite) throws IOException, WavFileException {
        if (this.ioState != IOState.WRITING) {
            throw new IOException("Cannot write to WavFile instance");
        }
        for (int f = 0; f < numFramesToWrite; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                writeSample(sampleBuffer[c][offset]);
            }
            offset++;
            this.frameCounter++;
        }
        return numFramesToWrite;
    }

    public int readFrames(double[] sampleBuffer, int numFramesToRead) throws IOException, WavFileException {
        return readFrames(sampleBuffer, 0, numFramesToRead);
    }

    public int readFrames(double[] sampleBuffer, int offset, int numFramesToRead) throws IOException, WavFileException {
        if (this.ioState != IOState.READING) {
            throw new IOException("Cannot read from WavFile instance");
        }
        for (int f = 0; f < numFramesToRead; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                sampleBuffer[offset] = this.floatOffset + (((double) readSample()) / this.floatScale);
                offset++;
            }
            this.frameCounter++;
        }
        return numFramesToRead;
    }

    public int readFrames(double[][] sampleBuffer, int numFramesToRead) throws IOException, WavFileException {
        return readFrames(sampleBuffer, 0, numFramesToRead);
    }

    public int readFrames(double[][] sampleBuffer, int offset, int numFramesToRead) throws IOException, WavFileException {
        if (this.ioState != IOState.READING) {
            throw new IOException("Cannot read from WavFile instance");
        }
        for (int f = 0; f < numFramesToRead; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                sampleBuffer[c][offset] = this.floatOffset + (((double) readSample()) / this.floatScale);
            }
            offset++;
            this.frameCounter++;
        }
        return numFramesToRead;
    }

    public int writeFrames(double[] sampleBuffer, int numFramesToWrite) throws IOException, WavFileException {
        return writeFrames(sampleBuffer, 0, numFramesToWrite);
    }

    public int writeFrames(double[] sampleBuffer, int offset, int numFramesToWrite) throws IOException, WavFileException {
        if (this.ioState != IOState.WRITING) {
            throw new IOException("Cannot write to WavFile instance");
        }
        for (int f = 0; f < numFramesToWrite; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                writeSample((long) (this.floatScale * (this.floatOffset + sampleBuffer[offset])));
                offset++;
            }
            this.frameCounter++;
        }
        return numFramesToWrite;
    }

    public int writeFrames(double[][] sampleBuffer, int numFramesToWrite) throws IOException, WavFileException {
        return writeFrames(sampleBuffer, 0, numFramesToWrite);
    }

    public int writeFrames(double[][] sampleBuffer, int offset, int numFramesToWrite) throws IOException, WavFileException {
        if (this.ioState != IOState.WRITING) {
            throw new IOException("Cannot write to WavFile instance");
        }
        for (int f = 0; f < numFramesToWrite; f++) {
            if (this.frameCounter == this.numFrames) {
                return f;
            }
            for (int c = 0; c < this.numChannels; c++) {
                writeSample((long) (this.floatScale * (this.floatOffset + sampleBuffer[c][offset])));
            }
            offset++;
            this.frameCounter++;
        }
        return numFramesToWrite;
    }

    public void close() throws IOException {
        if (this.iStream != null) {
            this.iStream.close();
            this.iStream = null;
        }
        if (this.oStream != null) {
            if (this.bufferPointer > 0) {
                this.oStream.write(this.buffer, 0, this.bufferPointer);
            }
            if (this.wordAlignAdjust) {
                this.oStream.write(0);
            }
            this.oStream.close();
            this.oStream = null;
        }
        this.ioState = IOState.CLOSED;
    }

    public void display() {
        display(System.out);
    }

    public void display(PrintStream out) {
        out.printf("Channels: %d, Frames: %d\n", new Object[]{Integer.valueOf(this.numChannels), Long.valueOf(this.numFrames)});
        out.printf("IO State: %s\n", new Object[]{this.ioState});
        out.printf("Sample Rate: %d, Block Align: %d\n", new Object[]{Long.valueOf(this.sampleRate), Integer.valueOf(this.blockAlign)});
        out.printf("Valid Bits: %d, Bytes per sample: %d\n", new Object[]{Integer.valueOf(this.validBits), Integer.valueOf(this.bytesPerSample)});
    }
}
