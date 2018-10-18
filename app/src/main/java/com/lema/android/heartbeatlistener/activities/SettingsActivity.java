package com.lema.android.heartbeatlistener.activities;

import android.app.Activity;
import android.os.Bundle;
import com.lema.android.heartbeatlistener.fragments.AppPreferenceFragment;

public class SettingsActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(16908290, new AppPreferenceFragment()).commit();
    }
}
