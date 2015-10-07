package io.finn.maxs.module.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.projectmaxs.shared.global.util.Log;


public class Settings implements SharedPreferences.OnSharedPreferenceChangeListener, Log.DebugLogSettings {
    // App settings
    private final String DEBUG_LOG;

    private static Settings sSettings;

    public static synchronized Settings getInstance(Context context) {
        if (sSettings == null) {
            sSettings = new Settings(context);
        }
        return sSettings;
    }

    private SharedPreferences mSharedPreferences;

    private Settings(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        DEBUG_LOG = context.getString(R.string.pref_app_debug_log_key);

        mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public boolean isDebugLogEnabled() {
        return mSharedPreferences.getBoolean(DEBUG_LOG, false);
    }

    public SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}
