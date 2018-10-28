package com.lema.android.heartbeatlistener.fragments;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;
import com.lema.android.heartbeatlistener.C0722R;
import com.project.heart.myapplication.MainActivity;
import com.lema.android.heartbeatlistener.activities.HelpActivity;
import com.lema.android.heartbeatlistener.sound.AudioStateManager;
import com.lema.android.heartbeatlistener.sound.IAudioFunctions;

public class MainFragment extends Fragment {
    public static MainFragment instance = null;
    MainActivity activity;
    ImageView helpIcon;
    ToggleButton listenButton;
    AnimationDrawable mainImageFrame;
    ToggleButton recordButton;

    /* renamed from: com.lema.android.heartbeatlistener.fragments.MainFragment$1 */
    class C07241 implements OnCheckedChangeListener {
        C07241() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (MainFragment.this.listenButton.isChecked()) {
                AudioStateManager.getInstance().startListenning(MainFragment.this.getActivity());
            } else {
                AudioStateManager.getInstance().stopListenning(MainFragment.this.getActivity());
            }
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.fragments.MainFragment$2 */
    class C07252 implements OnCheckedChangeListener {
        C07252() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (MainFragment.this.recordButton.isChecked()) {
                AudioStateManager.getInstance().startRecording(MainFragment.this.getActivity());
            } else {
                AudioStateManager.getInstance().stopRecording(MainFragment.this.getActivity());
            }
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.fragments.MainFragment$3 */
    class C07263 implements OnClickListener {
        C07263() {
        }

        public void onClick(View v) {
             if(MainFragment.this.activity != null)
            {
                MainFragment.this.activity.showRecordingFragment();
            }
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.fragments.MainFragment$4 */
    class C07274 implements OnClickListener {
        C07274() {
        }

        public void onClick(View v) {
            MainFragment.this.startActivity(new Intent(v.getContext(), HelpActivity.class));
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.fragments.MainFragment$6 */
    class C07286 implements DialogInterface.OnClickListener {
        C07286() {
        }

        public void onClick(DialogInterface dialog, int id) {
            MainFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.lema.android.heartbeatlistener")));
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.fragments.MainFragment$7 */
    class C07297 implements DialogInterface.OnClickListener {
        C07297() {
        }

        public void onClick(DialogInterface dialog, int id) {
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.fragments.MainFragment$5 */
    class C12845 implements IAudioFunctions {
        C12845() {
        }

        public void stopRecord() {
            MainFragment.this.recordButton.setChecked(false);
        }

        public void stopListenning() {
            MainFragment.this.listenButton.setChecked(false);
            MainFragment.this.mainImageFrame.stop();
        }

        public void startRecord() {
            MainFragment.this.recordButton.setChecked(true);
        }

        @Override
        public void displayStopRecordAd() {

        }

        public void startListenning() {
            MainFragment.this.listenButton.setChecked(true);
            MainFragment.this.mainImageFrame.start();
        }


        }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        if (getActivity() instanceof MainActivity) {
            this.activity = (MainActivity) getActivity();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C0722R.layout.fragment_main, container, false);
        //ImageView animated_image = (ImageView) rootView.findViewById(C0722R.id.main_animated_image);
       // animated_image.setBackgroundResource(C0722R.drawable.pregnant_animation);
       // this.mainImageFrame = (AnimationDrawable) animated_image.getBackground();
        this.listenButton = (ToggleButton) rootView.findViewById(C0722R.id.listenToggleButton);
        this.listenButton.setChecked(AudioStateManager.getInstance().isListenning());
        this.listenButton.setOnCheckedChangeListener(new C07241());
        this.recordButton = (ToggleButton) rootView.findViewById(C0722R.id.recordToggleButton);
        this.recordButton.setChecked(AudioStateManager.getInstance().isRecording());
        this.recordButton.setOnCheckedChangeListener(new C07252());
      //  ((Button) rootView.findViewById(C0722R.id.replay_activity_button)).setOnClickListener(new C07263());
       // this.helpIcon = (ImageView) rootView.findViewById(C0722R.id.main_page_help);
       // this.helpIcon.setOnClickListener(new C07274());
        AudioStateManager.getInstance().setAudioFunction(new C12845());
        requestForRating(getActivity());
        return rootView;
    }

    private void logAdDisplay(Context ctxt) {
        Editor prefEdit = PreferenceManager.getDefaultSharedPreferences(ctxt).edit();
        prefEdit.putLong("lastAdDisplayTime", System.currentTimeMillis());
        prefEdit.commit();
    }

    private void requestForRating(Context ctxt) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctxt);
        long lastRequestForRatingTime = preferences.getLong("requestForRating", 0);
        int requestForRatingNumber = preferences.getInt("requestForRatingNumber", 0);
        Editor prefEdit;
        if (lastRequestForRatingTime == 0) {
            prefEdit = preferences.edit();
            prefEdit.putLong("requestForRating", System.currentTimeMillis());
            prefEdit.putInt("requestForRatingNumber", 0);
            prefEdit.commit();
        } else if (requestForRatingNumber < 2) {
            long noRequestDuration = System.currentTimeMillis() - lastRequestForRatingTime;
            long timebeforeRequest = (long) 604800000;
            if (noRequestDuration >= 0 && noRequestDuration > timebeforeRequest) {
                prefEdit = preferences.edit();
                prefEdit.putLong("requestForRating", System.currentTimeMillis());
                prefEdit.putInt("requestForRatingNumber", requestForRatingNumber + 1);
                prefEdit.commit();
                Builder builder = new Builder(ctxt);
                builder.setMessage(ctxt.getResources().getText(C0722R.string.rate_request_message)).setTitle(ctxt.getResources().getText(C0722R.string.rate_request_title));
                builder.setPositiveButton(ctxt.getResources().getText(C0722R.string.rate_message), new C07286());
                builder.setNegativeButton(ctxt.getResources().getText(C0722R.string.ignore_message), new C07297());
                builder.create().show();
            }
        }
    }

    private long computeTimeFromInstall(Context ctxt) {
        try {
            return System.currentTimeMillis() - ctxt.getPackageManager().getPackageInfo("com.lema.android.heartbeatlistener", 0).firstInstallTime;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private boolean shallDisplayInterstitial(Context context) {
        if (!isAdDisplayDelayRespected(context)) {
            return false;
        }
        double coef = 0.3d;
        long installDuration = computeTimeFromInstall(context);
        long timebeforeFullCoef = (long) 1209600000;
        if (installDuration < 0) {
            coef = 0.5d;
        }
        if (installDuration > timebeforeFullCoef) {
            coef = 1.0d;
        } else if (installDuration > 0 && installDuration < timebeforeFullCoef) {
            coef = 0.2d + ((0.8d * ((double) installDuration)) / ((double) timebeforeFullCoef));
        }
        return Math.random() * coef > 0.5d;
    }

    private boolean isAdDisplayDelayRespected(Context ctxt) {
        if (System.currentTimeMillis() - PreferenceManager.getDefaultSharedPreferences(ctxt).getLong("lastAdDisplayTime", 0) > 100000) {
            return true;
        }
        return false;
    }

    public void onDestroy() {
        AudioStateManager.getInstance().stop(getActivity());
        super.onStop();
        super.onDestroy();
    }

    public void onHiddenChanged(boolean hidden) {
        if (hidden && this.mainImageFrame.isRunning()) {
            this.mainImageFrame.stop();
        } else if (!hidden && !this.mainImageFrame.isRunning() && AudioStateManager.getInstance().isListenning()) {
            this.mainImageFrame.start();
        }
    }
}
