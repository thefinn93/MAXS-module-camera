package io.finn.maxs.module.camera;

import android.content.Context;

import org.projectmaxs.shared.global.util.Log;
import org.projectmaxs.shared.mainmodule.ModuleInformation;
import org.projectmaxs.shared.module.MAXSModuleIntentService;
import org.projectmaxs.shared.module.SupraCommand;

import java.util.HashSet;
import java.util.Set;

import io.finn.maxs.module.camera.commands.TakePhoto;

/**
 * Created by finn on 10/6/15.
 */
public class ModuleService extends MAXSModuleIntentService {
    private final static Log LOG = Log.getLog();

    public ModuleService() {
        super(LOG, "maxs-module-camera", sCOMMANDS);
    }

    public static final ModuleInformation sMODULE_INFORMATION = new ModuleInformation(
            "io.finn.maxs.module.camera",      // Package of the Module
            "MAXS Module Camera"                  // Name of the Module (if omitted, last substring after '.' is used)
    );

    public static final SupraCommand CAMERA = new SupraCommand("camera");

    public static final SupraCommand[] sCOMMANDS;

    static {
        Set<SupraCommand> commands = new HashSet<SupraCommand>();

        SupraCommand.register(TakePhoto.class, commands);

        sCOMMANDS = commands.toArray(new SupraCommand[commands.size()]);
    }

    @Override
    public void initLog(Context context) {
        LOG.initialize(Settings.getInstance(context));
    }
}
