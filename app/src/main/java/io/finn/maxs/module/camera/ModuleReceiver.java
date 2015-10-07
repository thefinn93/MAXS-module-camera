package io.finn.maxs.module.camera;

/**
 * Created by finn on 10/6/15.
 */


import android.content.Context;
import android.content.SharedPreferences;

import org.projectmaxs.shared.global.util.Log;
import org.projectmaxs.shared.module.MAXSModuleReceiver;

public class ModuleReceiver extends MAXSModuleReceiver {
    private final static Log LOG = Log.getLog();

    public ModuleReceiver() {
        super(LOG, ModuleService.sMODULE_INFORMATION, ModuleService.sCOMMANDS);
    }

    @Override
    public void initLog(Context context) {
        LOG.initialize(Settings.getInstance(context));
    }

    @Override
    public SharedPreferences getSharedPreferences(Context context) {
        return Settings.getInstance(context).getSharedPreferences();
    }
}
