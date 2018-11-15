package com.project.heart.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;



import com.lema.android.heartbeatlistener.activities.HelpActivity;
import com.lema.android.heartbeatlistener.activities.SettingsActivity;

import com.lema.android.heartbeatlistener.fragments.RecordingFragment;
import com.lema.android.heartbeatlistener.sound.AudioStateManager;

public class MainActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



 public void showRecordingFragment() {
        RecordingFragment recordingFragment = new RecordingFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(com.lema.android.heartbeatlistener.R.id.container, recordingFragment);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }
  /*
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.lema.android.heartbeatlistener.R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == com.lema.android.heartbeatlistener.R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            if (MainFragment.instance != null) {
                AudioStateManager.getInstance().stopListenning(this);
            }
            startActivity(intent);
            return true;
        } else if (id != com.lema.android.heartbeatlistener.R.id.action_help) {
            return super.onOptionsItemSelected(item);
        } else {
            startActivity(new Intent(this, HelpActivity.class));
            return true;
        }
    }*/

}


