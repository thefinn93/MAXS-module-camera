package io.finn.maxs.module.camera.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import io.finn.maxs.module.camera.R;

/**
 * Created by finn on 10/6/15.
 */
public class Settings extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
