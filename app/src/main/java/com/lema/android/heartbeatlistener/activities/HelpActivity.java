package com.lema.android.heartbeatlistener.activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ToggleButton;
import com.lema.android.heartbeatlistener.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HelpActivity extends Activity {
    ExpandableListView expListView;
    ExpandableListAdapter listAdapter;
    HashMap<String, List<String>> listDataChild;
    List<String> listDataHeader;
    private MediaPlayer mPlayer;
    ToggleButton playButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        this.expListView = (ExpandableListView) findViewById(R.id.helpExpandableListView);
        prepareListData();
        this.listAdapter = new HelpExpandableListViewAdapter(this, this.listDataHeader, this.listDataChild);
        this.expListView.setAdapter(this.listAdapter);
        this.playButton = (ToggleButton) findViewById(R.id.help_play_button);
        this.playButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (HelpActivity.this.playButton.isChecked()) {
                    HelpActivity.this.playSample();
                } else {
                    HelpActivity.this.stopPlayingSample();
                }
            }
        });
    }

    private void stopPlayingSample() {
        this.mPlayer.stop();
        this.mPlayer.release();
        this.mPlayer = null;
    }

    private void playSample() {
        if (this.mPlayer != null) {
            stopPlayingSample();
            return;
        }
        this.mPlayer = MediaPlayer.create(this, R.raw.heartbeat_sample);
        this.mPlayer.setLooping(true);
        this.mPlayer.start();
    }

    public void onPause() {
        super.onPause();
        if (this.mPlayer != null) {
            stopPlayingSample();
        }
    }

    protected void onStart() {
        super.onStart();
        this.playButton.setChecked(this.mPlayer != null);
    }

    protected void onStop() {
        super.onStop();
        if (this.mPlayer != null) {
            this.mPlayer.stop();
            this.mPlayer.release();
            this.mPlayer = null;
        }
    }

    private void prepareListData() {
        this.listDataHeader = new ArrayList();
        this.listDataChild = new HashMap();
        this.listDataHeader.add(getResources().getString(R.string.help_disclamer_title));
        this.listDataHeader.add(getResources().getString(R.string.help_usage_title));
        this.listDataHeader.add(getResources().getString(R.string.help_check_title));
        this.listDataHeader.add(getResources().getString(R.string.help_own_heart_test_title));
        this.listDataHeader.add(getResources().getString(R.string.help_quality_1_title));
        this.listDataHeader.add(getResources().getString(R.string.help_quality_2_title));
        List<String> disclamerList = new ArrayList();
        disclamerList.add(getResources().getString(R.string.help_disclamer));
        List<String> usageList = new ArrayList();
        usageList.add(getResources().getString(R.string.help_usage_element1));
        usageList.add(getResources().getString(R.string.help_usage_element2));
        usageList.add(getResources().getString(R.string.help_usage_element3));
        List<String> checkList = new ArrayList();
        checkList.add(getResources().getString(R.string.help_check_element1));
        checkList.add(getResources().getString(R.string.help_check_element2));
        checkList.add(getResources().getString(R.string.help_check_element3));
        checkList.add(getResources().getString(R.string.help_check_element4));
        List<String> ownHeart = new ArrayList();
        ownHeart.add(getResources().getString(R.string.help_own_heart_test_1));
        ownHeart.add(getResources().getString(R.string.help_own_heart_test_2));
        ownHeart.add(getResources().getString(R.string.help_own_heart_test_3));
        ownHeart.add(getResources().getString(R.string.help_own_heart_test_4));
        ownHeart.add(getResources().getString(R.string.help_own_heart_test_5));
        List<String> quality1 = new ArrayList();
        quality1.add(getResources().getString(R.string.help_quality_1_1));
        quality1.add(getResources().getString(R.string.help_quality_1_2));
        List<String> quality2 = new ArrayList();
        quality2.add(getResources().getString(R.string.help_quality_2_1));
        quality2.add(getResources().getString(R.string.help_quality_2_2));
        this.listDataChild.put((String) this.listDataHeader.get(0), disclamerList);
        this.listDataChild.put((String) this.listDataHeader.get(1), usageList);
        this.listDataChild.put((String) this.listDataHeader.get(2), checkList);
        this.listDataChild.put((String) this.listDataHeader.get(3), ownHeart);
        this.listDataChild.put((String) this.listDataHeader.get(4), quality1);
        this.listDataChild.put((String) this.listDataHeader.get(5), quality2);
    }
}
