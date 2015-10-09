package io.finn.maxs.module.camera.commands;


import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.AsyncTask;
import android.util.Log;
import android.view.SurfaceView;

import junit.runner.Version;

import org.projectmaxs.shared.global.Message;
import org.projectmaxs.shared.global.messagecontent.CommandHelp;
import org.projectmaxs.shared.global.messagecontent.Element;
import org.projectmaxs.shared.global.messagecontent.Text;
import org.projectmaxs.shared.mainmodule.Command;
import org.projectmaxs.shared.module.MAXSModuleIntentService;
import org.projectmaxs.shared.module.MainUtil;
import org.projectmaxs.shared.module.SubCommand;

import java.io.IOException;

import io.finn.maxs.module.camera.ModuleService;

/**
 * Created by finn on 10/6/15.
 */
public class TakePhoto extends SubCommand {

    private static String TAG = "TakePhoto";

    static final int REQUEST_IMAGE_CAPTURE = 1;

    public TakePhoto() {
        super(ModuleService.CAMERA, "photo");
        setHelp(CommandHelp.ArgType.NONE, "Take a photograph");
    }

    @Override
    public Message execute(String arguments, final Command command, final MAXSModuleIntentService service) throws Throwable {


        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void...args) {
                SurfaceView sv;
                Camera mCamera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);

                Camera.Parameters params = mCamera.getParameters();
                params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                params.setPictureFormat(ImageFormat.JPEG);
                mCamera.setParameters(params);

                mCamera.takePicture(null, null, null, new Camera.PictureCallback() {

                    @Override
                    public void onPictureTaken(byte[] data, Camera camera) {
                        Log.i(TAG, "Took photo");
                        service.send(new Message(data.toString()), command.getId());

                    }
                });
                return "I am required to return a string";
            }



        }.execute();

        Message message = new Message("Taking a photo....");
        return message;
    }

}