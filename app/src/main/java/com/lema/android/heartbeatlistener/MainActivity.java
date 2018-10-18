package com.lema.android.heartbeatlistener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.lema.android.heartbeatlistener.activities.HelpActivity;
import com.lema.android.heartbeatlistener.activities.SettingsActivity;
import com.lema.android.heartbeatlistener.fragments.MainFragment;
import com.lema.android.heartbeatlistener.fragments.RecordingFragment;
import com.lema.android.heartbeatlistener.sound.AudioStateManager;

public class MainActivity extends ActionBarActivity {
    private AdView adView;
    public InterstitialAd recordLaunchInterstitialAd;
    public InterstitialAd recordingPlayerShowInterstitialAd;

    /* renamed from: com.lema.android.heartbeatlistener.MainActivity$1 */
    class C12821 extends AdListener {
        C12821() {
        }

        public void onAdClosed() {
            MainActivity.this.requestNewInterstitial(MainActivity.this.recordLaunchInterstitialAd);
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.MainActivity$2 */
    class C12832 extends AdListener {
        C12832() {
        }

        public void onAdClosed() {
            MainActivity.this.requestNewInterstitial(MainActivity.this.recordingPlayerShowInterstitialAd);
            if (MainActivity.this != null) {
                MainActivity.this.showRecordingFragment();
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0722R.layout.activity_main);
        this.adView = new AdView(this);
        this.adView.setAdUnitId("ca-app-pub-3071667822056799/1982683064");
        this.adView.setAdSize(AdSize.SMART_BANNER);
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
        ((LinearLayout) findViewById(C0722R.id.adLayout)).addView(this.adView);
        this.adView.loadAd(new Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("00FE3A2FC06401B3ECF61E9B7343A0F6").build());
    }

    private void requestNewInterstitial(InterstitialAd interAd) {
        interAd.loadAd(new Builder().addTestDevice("00FE3A2FC06401B3ECF61E9B7343A0F6").build());
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
