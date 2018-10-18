package com.lema.android.heartbeatlistener.video;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.lema.android.heartbeatlistener.C0722R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class VideoCreator extends AsyncTask<Void, Void, Void> {
    public static final String AppDirectory = "HeartbeatListener";
    public static final int BUFFER_SIZE = 48000;
    public static final int CODEC_TIMEOUT_IN_MS = 60000;
    public static final int COMPRESSED_AUDIO_FILE_BIT_RATE = 64000;
    public static final String COMPRESSED_AUDIO_FILE_MIME_TYPE = "audio/mp4a-latm";
    public static final String COMPRESSED_AUDIO_FILE_NAME = "convertedmp4.m4a";
    public static final String ConvertorDirectory = "HeartbeatListener/videoConvertor";
    public static final int INPUT_SAMPLING_RATE = 11025;
    public static final int SAMPLING_RATE = 11025;
    public static final String VIDEO_FILE_NAME = "video_base.mp4";
    private String CompressedAudioFilePath;
    private String InputAudioFilePath;
    private String InputVideoFilePath;
    String LOGTAG = "CONVERT AUDIO";
    private String OutputCreatedVideoFilePath;
    Context ctxt;
    ProgressDialog dialog;
    private String outputFileName;
    String videoPath;
    private String workingDirectory;

    private static class BufferedWritableFileByteChannel implements WritableByteChannel {
        private static final int BUFFER_CAPACITY = 1000000;
        private final ByteBuffer byteBuffer;
        private boolean isOpen;
        private final OutputStream outputStream;
        private final byte[] rawBuffer;

        private BufferedWritableFileByteChannel(OutputStream outputStream) {
            this.isOpen = true;
            this.rawBuffer = new byte[BUFFER_CAPACITY];
            this.outputStream = outputStream;
            this.byteBuffer = ByteBuffer.wrap(this.rawBuffer);
        }

        public int write(ByteBuffer inputBuffer) throws IOException {
            int inputBytes = inputBuffer.remaining();
            if (inputBytes > this.byteBuffer.remaining()) {
                dumpToFile();
                this.byteBuffer.clear();
                if (inputBytes > this.byteBuffer.remaining()) {
                    throw new BufferOverflowException();
                }
            }
            this.byteBuffer.put(inputBuffer);
            return inputBytes;
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        public void close() throws IOException {
            dumpToFile();
            this.isOpen = false;
        }

        private void dumpToFile() {
            try {
                this.outputStream.write(this.rawBuffer, 0, this.byteBuffer.position());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void copyVideoBaseFile() throws IOException {
        InputStream in = this.ctxt.getResources().openRawResource(C0722R.raw.video_base);
        FileOutputStream out = new FileOutputStream(this.InputVideoFilePath);
        byte[] buff = new byte[1024];
        while (true) {
            int read = in.read(buff);
            if (read <= 0) {
                break;
            }
            try {
                out.write(buff, 0, read);
            } finally {
                in.close();
                out.close();
            }
        }
    }

    public VideoCreator(Context ctxt, String inputAudioFilePath, String outputFileName) {
        this.ctxt = ctxt;
        this.InputAudioFilePath = inputAudioFilePath;
        this.outputFileName = outputFileName;
    }

    public void launch() {
        execute(new Void[0]);
    }

    protected void onPreExecute() {
        this.dialog = new ProgressDialog(this.ctxt);
        this.dialog.setMessage(this.ctxt.getResources().getText(C0722R.string.video_generating_progress_text));
        this.dialog.setCancelable(false);
        this.dialog.show();
        this.workingDirectory = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath())).append("/").append(ConvertorDirectory).append("/").toString();
        this.InputVideoFilePath = this.workingDirectory + VIDEO_FILE_NAME;
        this.OutputCreatedVideoFilePath = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath())).append("/").append(AppDirectory).append("/").append(this.outputFileName).toString();
        this.CompressedAudioFilePath = this.workingDirectory + COMPRESSED_AUDIO_FILE_NAME;
        File workingDir = new File(this.workingDirectory);
        if (!workingDir.exists()) {
            workingDir.mkdirs();
        }
        if (!new File(this.InputVideoFilePath).exists()) {
            try {
                copyVideoBaseFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @TargetApi(18)
    protected Void doInBackground(Void... params) {
        try {
            File file = new File(this.InputAudioFilePath);
            FileInputStream fis = new FileInputStream(file);
            file = new File(this.CompressedAudioFilePath);
            if (file.exists()) {
                file.delete();
            }
            MediaMuxer mediaMuxer = new MediaMuxer(file.getAbsolutePath(), 0);
            MediaFormat outputFormat = MediaFormat.createAudioFormat(COMPRESSED_AUDIO_FILE_MIME_TYPE, 11025, 1);
            outputFormat.setInteger("bitrate", COMPRESSED_AUDIO_FILE_BIT_RATE);
            MediaCodec codec = MediaCodec.createEncoderByType(COMPRESSED_AUDIO_FILE_MIME_TYPE);
            codec.configure(outputFormat, null, null, 1);
            codec.start();
            ByteBuffer[] codecInputBuffers = codec.getInputBuffers();
            ByteBuffer[] codecOutputBuffers = codec.getOutputBuffers();
            BufferInfo outBuffInfo = new BufferInfo();
            byte[] tempBuffer = new byte[BUFFER_SIZE];
            boolean hasMoreData = true;
            double presentationTimeUs = 0.0d;
            int audioTrackIdx = 0;
            int totalBytesRead = 0;
            do {
                int inputBufIndex = 0;
                while (inputBufIndex != -1 && hasMoreData) {
                    inputBufIndex = codec.dequeueInputBuffer(60000);
                    if (inputBufIndex >= 0) {
                        ByteBuffer dstBuf = codecInputBuffers[inputBufIndex];
                        dstBuf.clear();
                        int bytesRead = fis.read(tempBuffer, 0, dstBuf.limit());
                        if (bytesRead == -1) {
                            hasMoreData = false;
                            codec.queueInputBuffer(inputBufIndex, 0, 0, (long) presentationTimeUs, 4);
                        } else {
                            totalBytesRead += bytesRead;
                            dstBuf.put(tempBuffer, 0, bytesRead);
                            codec.queueInputBuffer(inputBufIndex, 0, bytesRead, (long) presentationTimeUs, 0);
                            presentationTimeUs = (double) ((1000000 * ((long) (totalBytesRead / 2))) / 11025);
                        }
                    }
                }
                int outputBufIndex = 0;
                while (outputBufIndex != -1) {
                    outputBufIndex = codec.dequeueOutputBuffer(outBuffInfo, 60000);
                    if (outputBufIndex >= 0) {
                        ByteBuffer encodedData = codecOutputBuffers[outputBufIndex];
                        encodedData.position(outBuffInfo.offset);
                        encodedData.limit(outBuffInfo.offset + outBuffInfo.size);
                        if ((outBuffInfo.flags & 2) == 0 || outBuffInfo.size == 0) {
                            mediaMuxer.writeSampleData(audioTrackIdx, codecOutputBuffers[outputBufIndex], outBuffInfo);
                            codec.releaseOutputBuffer(outputBufIndex, false);
                        } else {
                            codec.releaseOutputBuffer(outputBufIndex, false);
                        }
                    } else if (outputBufIndex == -2) {
                        outputFormat = codec.getOutputFormat();
                        Log.v(this.LOGTAG, "Output format changed - " + outputFormat);
                        audioTrackIdx = mediaMuxer.addTrack(outputFormat);
                        mediaMuxer.start();
                    } else if (outputBufIndex == -3) {
                        Log.e(this.LOGTAG, "Output buffers changed during encode!");
                    } else if (outputBufIndex != -1) {
                        Log.e(this.LOGTAG, "Unknown return code from dequeueOutputBuffer - " + outputBufIndex);
                    }
                }
                Log.v(this.LOGTAG, "Conversion % - " + ((int) Math.round(((double) (((float) totalBytesRead) / ((float) file.length()))) * 100.0d)));
            } while (outBuffInfo.flags != 4);
            fis.close();
            mediaMuxer.stop();
            mediaMuxer.release();
            Log.v(this.LOGTAG, "Compression done ...");
        } catch (FileNotFoundException e) {
            Log.e(this.LOGTAG, "File not found!", e);
        } catch (IOException e2) {
            Log.e(this.LOGTAG, "IO exception!", e2);
        }
        mux(this.InputVideoFilePath, this.CompressedAudioFilePath, this.OutputCreatedVideoFilePath);
        this.ctxt.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + this.OutputCreatedVideoFilePath)));
        this.ctxt.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + this.CompressedAudioFilePath)));
        return null;
    }

    protected void onPostExecute(Void result) {
        File workingDir = new File(this.workingDirectory);
        if (workingDir.exists()) {
            try {
                delete(workingDir);
            } catch (IOException e) {
            }
        }
        this.dialog.dismiss();
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        Uri videoUri = Uri.parse("file://" + this.OutputCreatedVideoFilePath);
        sharingIntent.setType("video/*");
        sharingIntent.putExtra("android.intent.extra.STREAM", videoUri);
        this.ctxt.startActivity(Intent.createChooser(sharingIntent, this.ctxt.getResources().getString(C0722R.string.share_video_message)));
    }

    private static void delete(File file) throws IOException {
        if (!file.isDirectory()) {
            file.delete();
        } else if (file.list().length == 0) {
            file.delete();
        } else {
            for (String temp : file.list()) {
                delete(new File(file, temp));
            }
            if (file.list().length == 0) {
                file.delete();
            }
        }
    }

    public boolean mux(String videoFile, String audioFile, String outputFile) {
        try {
            MovieCreator movieCreator = new MovieCreator();
            Movie video = MovieCreator.build(videoFile);
            try {
                movieCreator = new MovieCreator();
                video.addTrack((Track) MovieCreator.build(audioFile).getTracks().get(0));
                Container out = new DefaultMp4Builder().build(video);
                try {
                    FileOutputStream fos = new FileOutputStream(outputFile);
                    BufferedWritableFileByteChannel byteBufferByteChannel = new BufferedWritableFileByteChannel(fos);
                    try {
                        out.writeContainer(byteBufferByteChannel);
                        byteBufferByteChannel.close();
                        fos.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    return false;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                return false;
            } catch (NullPointerException e4) {
                e4.printStackTrace();
                return false;
            }
        } catch (RuntimeException e5) {
            e5.printStackTrace();
            return false;
        } catch (IOException e32) {
            e32.printStackTrace();
            return false;
        }
    }
}
