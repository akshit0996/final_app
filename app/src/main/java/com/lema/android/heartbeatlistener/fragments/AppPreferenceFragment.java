package com.lema.android.heartbeatlistener.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import com.lema.android.heartbeatlistener.C0722R;

public class AppPreferenceFragment extends PreferenceFragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(C0722R.xml.preferences);
    }
}
