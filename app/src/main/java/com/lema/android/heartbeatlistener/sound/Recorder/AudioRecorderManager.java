package com.lema.android.heartbeatlistener.sound.Recorder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.lema.android.heartbeatlistener.activities.RecordsAdapter;
import com.lema.android.heartbeatlistener.sound.Recorder.waveFile.WavFile;
import com.lema.android.heartbeatlistener.sound.Recorder.waveFile.WavFileException;
import com.lema.android.heartbeatlistener.sound.signal.Buffer;
import com.lema.android.heartbeatlistener.sound.signal.Extrapolator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class AudioRecorderManager {
    private static AudioRecorderManager instance;
    ArrayList<Short> recordBuffer = new ArrayList();
    double sampleRate = 44100.0d;
    boolean shallRecord = false;

    public static AudioRecorderManager getInstance() {
        if (instance == null) {
            instance = new AudioRecorderManager();
        }
        return instance;
    }

    public static File getRecordsFile(Context ctxt) {
        File recordsFolder = new File(ctxt.getFilesDir(), "Records");
        if (!recordsFolder.exists()) {
            recordsFolder.mkdir();
        }
        return recordsFolder;
    }

    public synchronized void startRecord() {
        this.shallRecord = true;
    }

    public synchronized void stopRecord() {
        this.shallRecord = false;
    }

    public synchronized void writeFile(Context ctxt) {
        this.shallRecord = false;
        if (!this.recordBuffer.isEmpty()) {
            createAudioFile(ctxt, this.recordBuffer, (int) this.sampleRate, "record");
        }
    }

    public synchronized void reset(double finalSampleRate) {
        this.sampleRate = finalSampleRate;
        this.recordBuffer.clear();
    }

    public synchronized void recordData(Short data) {
        if (this.shallRecord) {
            this.recordBuffer.add(data);
        }
    }

    public synchronized void recordData(Buffer data) {
        if (this.shallRecord) {
            for (int i = 0; i < data.bufferSize; i++) {
                this.recordBuffer.add(Short.valueOf(data.buffer[i]));
            }
        }
    }

    public synchronized boolean isRecording() {
        return this.shallRecord;
    }

    public void createAudioFile(Context ctxt, ArrayList<Short> recordBuffer, int sampleRate, String fileName) {
        try {
            File file = createFile(ctxt, fileName, ".wav");
            if (file != null) {
                writeWaveFile(file, overSampleRecording(4, recordBuffer), sampleRate * 4);
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(file));
                ctxt.sendBroadcast(intent);
                Toast.makeText(ctxt, new StringBuilder(String.valueOf(fileName)).append(" saved").toString(), Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Short> overSampleRecording(int overSpamplingRatio, ArrayList<Short> recordBuffer) {
        ArrayList<Short> overSampledRecording = new ArrayList();
        Buffer initialBuffer = new Buffer((ArrayList) recordBuffer);
        Buffer finalBuffer = new Buffer(recordBuffer.size() * overSpamplingRatio);
        new Extrapolator(overSpamplingRatio).extrapolate(initialBuffer, finalBuffer);
        for (int i = 0; i < finalBuffer.bufferSize; i++) {
            overSampledRecording.add(Short.valueOf(finalBuffer.buffer[i]));
        }
        return overSampledRecording;
    }

    private File generateFile(File parentFile, Context ctxt) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctxt);
        int i = sharedPref.getInt("saved_recording_item_number", 0);
        String fileName = "Audio recording " + i + " .wav";
        Editor editor = sharedPref.edit();
        editor.putInt("saved_recording_item_number", i + 1);
        editor.commit();
        return new File(parentFile, fileName);
    }

    private File createFile(Context ctxt, String fileName, String fileExtension) throws IOException {
        File file = generateFile(getRecordsFile(ctxt), ctxt);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static void writeWaveFile(File file, ArrayList<Short> recordBuffer, int sampleRate) {
        try {
            WavFile wavFile = WavFile.newWavFile(file, 1, (long) recordBuffer.size(), 16, (long) sampleRate);
            short[] buffer = new short[recordBuffer.size()];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = ((Short) recordBuffer.get(i)).shortValue();
            }
            wavFile.writeFrames(buffer, recordBuffer.size());
            wavFile.close();
        } catch (IOException e) {
        } catch (WavFileException e2) {
        }
    }

    public static String getDateFromFileName(String fileName) {
        return fileName.substring(fileName.lastIndexOf("record") + 6, fileName.lastIndexOf("_"));
    }

    public static String getHourFromFileName(String fileName) {
        return fileName.substring(fileName.lastIndexOf("_") + 1, fileName.length() - 4);
    }

    public RecordsAdapter getRecordAdapterInstance(Context context) {
        File[] fileList = getRecordsFile(context).listFiles();
        TreeSet<File> fileSet = new TreeSet(new Comparator<File>() {
            public int compare(File lhs, File rhs) {
                if (lhs == null || rhs == null) {
                    if (lhs == null && rhs == null) {
                        return 0;
                    }
                    if (lhs != null || rhs == null) {
                        return 1;
                    }
                    return -1;
                } else if (lhs.exists() && rhs.exists()) {
                    return (int) Math.signum((float) (rhs.lastModified() - lhs.lastModified()));
                } else {
                    if (!lhs.exists() && !rhs.exists()) {
                        return 0;
                    }
                    if (!lhs.exists() || rhs.exists()) {
                        return 1;
                    }
                    return -1;
                }
            }
        });

        for (File add : fileList) {
            fileSet.add(add);
        }
        return new RecordsAdapter(context, new ArrayList(fileSet));
    }
}
