package com.lema.android.heartbeatlistener.fragments;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.ToggleButton;
import com.lema.android.heartbeatlistener.Publisher;
import com.lema.android.heartbeatlistener.R;
import com.lema.android.heartbeatlistener.activities.RecordsAdapter;
import com.lema.android.heartbeatlistener.sound.Recorder.AudioRecorderManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecordingFragment extends Fragment {
    RecordsAdapter adapter;
    String currentSoundFilePath;
    MediaPlayer mp;
    ToggleButton playPauseButton;
    SeekBar playerProgressBar;
    Handler progressHandler;
    Runnable run = new Runnable() {
        public void run() {
            RecordingFragment.this.progressUpdate();
        }
    };
    Button shareButton;
    boolean stopUpdateProgressBar;

    public void progressUpdate() {
        if (!this.stopUpdateProgressBar && this.mp != null) {
            this.playerProgressBar.setProgress(this.mp.getCurrentPosition());
            this.progressHandler.postDelayed(this.run, 500);
        }
    }

    private void tryCopySample() throws IOException {
        InputStream in = getResources().openRawResource(R.raw.heartbeat_sample);
        File sampleFile = new File(AudioRecorderManager.getRecordsFile(getActivity()), new StringBuilder(String.valueOf(getResources().getString(R.string.sample_file_name))).append(".wav").toString());
        if (!sampleFile.exists()) {
            FileOutputStream out = new FileOutputStream(sampleFile);
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
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_player, container, false);
        this.progressHandler = new Handler();
        ListView recordslist = (ListView) rootView.findViewById(R.id.recordsList);
        this.mp = new MediaPlayer();
        this.playPauseButton = (ToggleButton) rootView.findViewById(R.id.playToggleButton);
        this.playerProgressBar = (SeekBar) rootView.findViewById(R.id.playerProgressBar);
        this.shareButton = (Button) rootView.findViewById(R.id.shareButton);
        this.stopUpdateProgressBar = false;
        try {
            tryCopySample();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.adapter = AudioRecorderManager.getInstance().getRecordAdapterInstance(getActivity());
        recordslist.setAdapter(this.adapter);
        recordslist.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                RecordingFragment.this.currentSoundFilePath = ((File) RecordingFragment.this.adapter.getItem(position)).getAbsolutePath();
                try {
                    RecordingFragment.this.playSong(RecordingFragment.this.currentSoundFilePath);
                } catch (Throwable throwable){
                    throwable.printStackTrace();
                }

            }
        });
        this.playPauseButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RecordingFragment.this.mp.isPlaying()) {
                    RecordingFragment.this.mp.pause();
                    return;
                }
                RecordingFragment.this.mp.start();
                RecordingFragment.this.progressUpdate();
            }
        });
        this.playerProgressBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                RecordingFragment.this.mp.seekTo(seekBar.getProgress());
                RecordingFragment.this.stopUpdateProgressBar = false;
                RecordingFragment.this.progressUpdate();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                RecordingFragment.this.stopUpdateProgressBar = true;
            }

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
        });
        this.mp.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                RecordingFragment.this.playPauseButton.setChecked(false);
                RecordingFragment.this.playerProgressBar.setProgress(0);
            }
        });
        this.shareButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (RecordingFragment.this.currentSoundFilePath != null) {
                    Publisher.publishAudioFile(v.getContext(), RecordingFragment.this.currentSoundFilePath);
                }
            }
        });
        recordslist.setItemChecked(0, true);
        return rootView;
    }

    private void playSong(String songPath) throws Throwable{
        Throwable th;
        try {
            this.mp.reset();
            this.mp.setDataSource("file://" + songPath);
            this.mp.prepare();
            this.playPauseButton.setChecked(true);
            this.mp.start();
            this.playerProgressBar.setMax(this.mp.getDuration());
            progressUpdate();
        } catch (IOException e) {
            this.mp.reset();
            FileInputStream fis = null;
            try {
                FileInputStream fis2 = new FileInputStream(new File(songPath));
                try {
                    this.mp.setDataSource(fis2.getFD());
                    this.mp.setAudioStreamType(3);
                    this.mp.prepare();
                    this.playPauseButton.setChecked(true);
                    this.mp.start();
                    this.playerProgressBar.setMax(this.mp.getDuration());
                    progressUpdate();
                    if (fis2 != null) {
                        try {
                            fis2.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Exception e3) {
                    fis = fis2;
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fis = fis2;
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                if (fis != null) {
                    fis.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (fis != null) {
                    fis.close();
                }
                throw th;
            }
        }
    }

    public void onStop() {
        super.onStop();
        if (this.mp.isPlaying()) {
            this.mp.stop();
        }
        this.mp.release();
        this.mp = null;
    }

    public void onStart() {
        super.onStart();
        if (this.mp == null) {
            this.mp = new MediaPlayer();
        }
    }
}
