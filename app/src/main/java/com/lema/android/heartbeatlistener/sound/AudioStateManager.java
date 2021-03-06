package com.lema.android.heartbeatlistener.sound;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.lema.android.heartbeatlistener.C0722R;
import com.lema.android.heartbeatlistener.sound.Recorder.AudioRecorderManager;

public class AudioStateManager {
    private static AudioStateManager instance;
    IAudioFunctions audioFunctions = new C12851();
    ISoundManager soundManager = null;

    /* renamed from: com.lema.android.heartbeatlistener.sound.AudioStateManager$6 */
    class C07386 implements OnClickListener {
        C07386() {
        }

        public void onClick(DialogInterface dialog, int id) {
            AudioStateManager.this.clearDisplay();
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.sound.AudioStateManager$1 */
    class C12851 implements IAudioFunctions {
        C12851() {
        }

        public void stopRecord() {
        }

        public void stopListenning() {
        }

        public void startRecord() {
        }

        public void startListenning() {
        }

        public void displayStopRecordAd() {
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.sound.AudioStateManager$2 */
    class C12862 implements IAction {
        C12862() {
        }

        public void executeAction(Context ctxt) {
            AudioStateManager.this.soundManager = AudioStateManager.this.createSoundSensor(ctxt);
            AudioStateManager.this.soundManager.launch();
            AudioStateManager.this.audioFunctions.startListenning();
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.sound.AudioStateManager$3 */
    class C12873 implements IAction {
        C12873() {
        }

        public void executeAction(Context ctxt) {
            AudioStateManager.this.soundManager = AudioStateManager.this.createSoundSensor(ctxt);
            AudioStateManager.this.soundManager.launch();
            AudioStateManager.this.audioFunctions.startListenning();
            AudioRecorderManager.getInstance().startRecord();
            AudioStateManager.this.audioFunctions.startRecord();
        }
    }

    private AudioStateManager() {
    }

    public void startListenning(Context ctxt) {
        if (!isListenning()) {
            warningMessageActionDecorator(ctxt, new C12862());
        }
    }

    public void stopListenning(Context ctxt) {
        stop(ctxt);
    }

    public void startRecording(Context ctxt) {
        if (isListenning()) {
            AudioRecorderManager.getInstance().startRecord();
            this.audioFunctions.startRecord();
            return;
        }
        warningMessageActionDecorator(ctxt, new C12873());
    }

    public void stopRecording(Context ctxt) {
        stop(ctxt);
    }

    public void stop(Context ctxt) {
        boolean shallDisplayAd = isRecording();
        if (isListenning()) {
            this.soundManager.interupt();
            this.audioFunctions.stopListenning();
        }
        if (isRecording()) {
            AudioRecorderManager.getInstance().stopRecord();
            this.audioFunctions.stopRecord();
            AudioRecorderManager.getInstance().writeFile(ctxt);
        }
        if (shallDisplayAd) {
            this.audioFunctions.displayStopRecordAd();
        }
    }

    public boolean isListenning() {
        if (this.soundManager != null) {
            return this.soundManager.isRunning();
        }
        return false;
    }

    public boolean isRecording() {
        return AudioRecorderManager.getInstance().isRecording();
    }

    public static AudioStateManager getInstance() {
        if (instance == null) {
            instance = new AudioStateManager();
        }
        return instance;
    }

    public void setAudioFunction(IAudioFunctions functions) {
        this.audioFunctions = functions;
    }

    private ISoundManager createSoundSensor(Context ctxt) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctxt);
        if (preferences.getBoolean("filterSelector", true)) {
            return new SoundManager(getPrefAmplification(preferences), getPrefNoiseRed(preferences));
        }
        return new SoundSensor((float) getPrefAmplification(preferences), (int) getPrefNoiseRed(preferences));
    }

    private static double getPrefAmplification(SharedPreferences preferences) {
        return preferences.getBoolean("filterSelector", true) ? 10.0d + (((double) preferences.getInt("amplificationLevel", 50)) * 0.75d) : 20.0d + (((double) preferences.getInt("amplificationLevel", 50)) / 3.0d);
    }

    private static double getPrefNoiseRed(SharedPreferences preferences) {
        if (preferences.getBoolean("filterSelector", true)) {
            return (double) ((100 - preferences.getInt("noiseRedLevel", 75)) + 100);
        }
        return (double) ((preferences.getInt("noiseRedLevel", 50) / 5) + 20);
    }

    private void warningMessageActionDecorator(final Context ctxt, final IAction action) {
        AudioManager audioManager = (AudioManager) ctxt.getSystemService("audio");
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ctxt);
        boolean shallPromptWarning = sharedPref.getBoolean("saved_shall_display_listen_warning_message", true);
        if (audioManager.isWiredHeadsetOn() || !shallPromptWarning) {
            action.executeAction(ctxt);
            return;
        }
        View checkBoxView = View.inflate(ctxt, C0722R.layout.checkbox, null);
        CheckBox checkBox = (CheckBox) checkBoxView.findViewById(C0722R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Editor editor = sharedPref.edit();
                editor.putBoolean("saved_shall_display_listen_warning_message", false);
                editor.commit();
            }
        });
        checkBox.setText(ctxt.getResources().getString(C0722R.string.listen_launch_warning_checkbox_text));
        Builder builder = new Builder(ctxt);
        builder.setMessage(ctxt.getResources().getText(C0722R.string.listen_launch_warning_message)).setTitle(ctxt.getResources().getText(C0722R.string.listen_launch_warning_title)).setView(checkBoxView);
        builder.setPositiveButton(ctxt.getResources().getText(C0722R.string.continue_message), new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                action.executeAction(ctxt);
            }
        });
        builder.setNegativeButton(ctxt.getResources().getText(C0722R.string.cancel_message), new C07386());
        builder.create().show();
    }

    private void clearDisplay() {
        this.audioFunctions.stopRecord();
        this.audioFunctions.stopListenning();
    }
}
