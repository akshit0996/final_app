package com.project.heart.myapplication;


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
import com.lema.android.heartbeatlistener.activities.HelpActivity;
import com.lema.android.heartbeatlistener.sound.AudioStateManager;
import com.lema.android.heartbeatlistener.sound.IAudioFunctions;

public class SecondFragment extends Fragment {
    //public static com.lema.android.heartbeatlistener.fragments.MainFragment instance = null;
    public static com.project.heart.myapplication.SecondFragment instance = null;

    MainActivity activity;
    //ImageView helpIcon;
    ToggleButton listenButton;
    AnimationDrawable mainImageFrame;
    ToggleButton recordButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        if (getActivity() instanceof MainActivity) {
            this.activity = (MainActivity) getActivity();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        //  ImageView animated_image = (ImageView) rootView.findViewById(R.id.main_animated_image);
        // animated_image.setBackgroundResource(R.drawable.pregnant_animation);
        // this.mainImageFrame = (AnimationDrawable) animated_image.getBackground();
        this.listenButton = (ToggleButton) rootView.findViewById(R.id.listenToggleButton);
        this.listenButton.setChecked(AudioStateManager.getInstance().isListenning());
        this.listenButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (com.project.heart.myapplication.SecondFragment.this.listenButton.isChecked()) {
                    AudioStateManager.getInstance().startListenning(com.project.heart.myapplication.SecondFragment.this.getActivity());
                } else {
                    AudioStateManager.getInstance().stopListenning(com.project.heart.myapplication.SecondFragment.this.getActivity());
                }
            }
        });
//        this.recordButton = (ToggleButton) rootView.findViewById(R.id.recordToggleButton);
//        this.recordButton.setChecked(AudioStateManager.getInstance().isRecording());
//        this.recordButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (com.project.heart.myapplication.SecondFragment.this.recordButton.isChecked()) {
//                    AudioStateManager.getInstance().startRecording(com.project.heart.myapplication.SecondFragment.this.getActivity());
//                } else {
//                    AudioStateManager.getInstance().stopRecording(com.project.heart.myapplication.SecondFragment.this.getActivity());
//                }
//            }
//        });
//        ((Button) rootView.findViewById(R.id.replay_activity_button)).setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//
//                if (com.project.heart.myapplication.SecondFragment.this.activity != null) {
//                    com.project.heart.myapplication.SecondFragment.this.activity.showRecordingFragment();
//                }
//            }
//        });
//        this.helpIcon = (ImageView) rootView.findViewById(R.id.main_page_help);
//        this.helpIcon.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                com.project.heart.myapplication.SecondFragment.this.startActivity(new Intent(v.getContext(), HelpActivity.class));
//            }
//        });
        AudioStateManager.getInstance().setAudioFunction(new IAudioFunctions() {
            public void stopRecord() {
                com.project.heart.myapplication.SecondFragment.this.recordButton.setChecked(false);
            }

            public void stopListenning() {
                com.project.heart.myapplication.SecondFragment.this.listenButton.setChecked(false);
              //  com.project.heart.myapplication.SecondFragment.this.mainImageFrame.stop();
            }

            public void startRecord() {
                com.project.heart.myapplication.SecondFragment.this.recordButton.setChecked(true);
            }

            public void startListenning() {
                com.project.heart.myapplication.SecondFragment.this.listenButton.setChecked(true);
              //  com.project.heart.myapplication.SecondFragment.this.mainImageFrame.start();
            }

            @Override
            public void displayStopRecordAd() {

            }
        });
        // requestForRating(getActivity());
        return rootView;
    }

//    private void logAdDisplay(Context ctxt) {
//        Editor prefEdit = PreferenceManager.getDefaultSharedPreferences(ctxt).edit();
//        prefEdit.putLong("lastAdDisplayTime", System.currentTimeMillis());
//        prefEdit.commit();
//    }
    public void onDestroy() {
        AudioStateManager.getInstance().stop(getActivity());
        super.onStop();
        super.onDestroy();
    }

//    public void onHiddenChanged(boolean hidden) {
//        if (hidden && this.mainImageFrame.isRunning()) {
//            this.mainImageFrame.stop();
//        } else if (!hidden && !this.mainImageFrame.isRunning() && AudioStateManager.getInstance().isListenning()) {
//            this.mainImageFrame.start();
//        }
//    }

//    private void requestForRating(Context ctxt) {
//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctxt);
//        long lastRequestForRatingTime = preferences.getLong("requestForRating", 0);
//        int requestForRatingNumber = preferences.getInt("requestForRatingNumber", 0);
//        Editor prefEdit;
//        if (lastRequestForRatingTime == 0) {
//            prefEdit = preferences.edit();
//            prefEdit.putLong("requestForRating", System.currentTimeMillis());
//            prefEdit.putInt("requestForRatingNumber", 0);
//            prefEdit.commit();
//        } else if (requestForRatingNumber < 2) {
//            long noRequestDuration = System.currentTimeMillis() - lastRequestForRatingTime;
//            long timebeforeRequest = (long) 604800000;
//            if (noRequestDuration >= 0 && noRequestDuration > timebeforeRequest) {
//                prefEdit = preferences.edit();
//                prefEdit.putLong("requestForRating", System.currentTimeMillis());
//                prefEdit.putInt("requestForRatingNumber", requestForRatingNumber + 1);
//                prefEdit.commit();
//                Builder builder = new Builder(ctxt);
//                builder.setMessage(ctxt.getResources().getText(R.string.rate_request_message)).setTitle(ctxt.getResources().getText(R.string.rate_request_title));
//                builder.setPositiveButton(ctxt.getResources().getText(R.string.rate_message), new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        MainFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.lema.android.heartbeatlistener")));
//                    }
//                });
//                builder.setNegativeButton(ctxt.getResources().getText(R.string.ignore_message), new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                    }
//                });
//                builder.create().show();
//            }
//        }
//    }

//    private long computeTimeFromInstall(Context ctxt) {
//        try {
//            return System.currentTimeMillis() - ctxt.getPackageManager().getPackageInfo("com.lema.android.heartbeatlistener", 0).firstInstallTime;
//        } catch (NameNotFoundException e) {
//            return -1;
//        }
//    }

//    private boolean shallDisplayInterstitial(Context context) {
//        if (!isAdDisplayDelayRespected(context)) {
//            return false;
//        }
//        double coef = 0.3d;
//        long installDuration = computeTimeFromInstall(context);
//        long timebeforeFullCoef = (long) 1209600000;
//        if (installDuration < 0) {
//            coef = 0.5d;
//        }
//        if (installDuration > timebeforeFullCoef) {
//            coef = 1.0d;
//        } else if (installDuration > 0 && installDuration < timebeforeFullCoef) {
//            coef = 0.2d + ((0.8d * ((double) installDuration)) / ((double) timebeforeFullCoef));
//        }
//        return Math.random() * coef > 0.5d;
//    }

//    private boolean isAdDisplayDelayRespected(Context ctxt) {
//        if (System.currentTimeMillis() - PreferenceManager.getDefaultSharedPreferences(ctxt).getLong("lastAdDisplayTime", 0) > 100000) {
//            return true;
//        }
//        return false;
//    }


}
