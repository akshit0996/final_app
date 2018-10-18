package com.project.heart.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.lema.android.heartbeatlistener.C0722R;
import com.lema.android.heartbeatlistener.activities.HelpActivity;
import com.lema.android.heartbeatlistener.activities.SettingsActivity;
import com.lema.android.heartbeatlistener.fragments.MainFragment;
import com.lema.android.heartbeatlistener.fragments.RecordingFragment;
import com.lema.android.heartbeatlistener.sound.AudioStateManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView((int) C0722R.layout.activity_main);

            this.recordLaunchInterstitialAd = new InterstitialAd(this);
            this.recordLaunchInterstitialAd.setAdUnitId("ca-app-pub-3071667822056799/4148128662");
            this.recordLaunchInterstitialAd.setAdListener(new C12821());
            requestNewInterstitial(this.recordLaunchInterstitialAd);
            this.recordingPlayerShowInterstitialAd = new InterstitialAd(this);
            this.recordingPlayerShowInterstitialAd.setAdUnitId("ca-app-pub-3071667822056799/5624861868");
            this.recordingPlayerShowInterstitialAd.setAdListener(new C12832());
            requestNewInterstitial(this.recordingPlayerShowInterstitialAd);
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().add((int) C0722R.id.container, new MainFragment()).commit();
            }
             }



        public void showRecordingFragment() {
            RecordingFragment recordingFragment = new RecordingFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(C0722R.id.container, recordingFragment);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();
        }

        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(C0722R.menu.main, menu);
            return true;
        }

        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == C0722R.id.action_settings) {
                Intent intent = new Intent(this, SettingsActivity.class);
                if (MainFragment.instance != null) {
                    AudioStateManager.getInstance().stopListenning(this);
                }
                startActivity(intent);
                return true;
            } else if (id != C0722R.id.action_help) {
                return super.onOptionsItemSelected(item);
            } else {
                startActivity(new Intent(this, HelpActivity.class));
                return true;
            }
        }
    }
}


