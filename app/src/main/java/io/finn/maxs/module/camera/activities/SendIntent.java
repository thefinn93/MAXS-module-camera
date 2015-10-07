package io.finn.maxs.module.camera.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.projectmaxs.shared.global.Message;
import org.projectmaxs.shared.module.MainUtil;

/**
 * Created by finn on 10/6/15.
 */
public class SendIntent extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        MainUtil.send(new Message(sharedText), this);
        finish();
    }
}
