package com.lema.android.heartbeatlistener;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.lema.android.heartbeatlistener.video.VideoCreator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Publisher {

    /* renamed from: com.lema.android.heartbeatlistener.Publisher$1 */
    static class C07181 implements OnClickListener {
        private final /* synthetic */ Context val$ctxt;
        private final /* synthetic */ String val$inputAudioFilePath;
        private final /* synthetic */ SharedPreferences val$preferences;

        C07181(SharedPreferences sharedPreferences, Context context, String str) {
            this.val$preferences = sharedPreferences;
            this.val$ctxt = context;
            this.val$inputAudioFilePath = str;
        }

        public void onClick(DialogInterface dialog, int id) {
            Editor prefEditor = this.val$preferences.edit();
            prefEditor.putBoolean(this.val$ctxt.getResources().getString(C0722R.string.preference_publish_as_video), false);
            prefEditor.commit();
            Publisher.publishAudioFileAsWav(this.val$ctxt, this.val$inputAudioFilePath);
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.Publisher$2 */
    static class C07192 implements OnClickListener {
        C07192() {
        }

        public void onClick(DialogInterface dialog, int id) {
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.Publisher$3 */
    static class C07203 implements OnClickListener {
        private final /* synthetic */ Context val$ctxt;
        private final /* synthetic */ String val$inputAudioFilePath;

        C07203(Context context, String str) {
            this.val$ctxt = context;
            this.val$inputAudioFilePath = str;
        }

        public void onClick(DialogInterface dialog, int id) {
            Publisher.publishAudioFileAsWav(this.val$ctxt, this.val$inputAudioFilePath);
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.Publisher$4 */
    static class C07214 implements OnClickListener {
        C07214() {
        }

        public void onClick(DialogInterface dialog, int id) {
        }
    }

    public static void publishAudioFile(Context ctxt, String inputAudioFilePath) {
        Builder builder;
        if (inputAudioFilePath != null) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctxt);
            if (!preferences.getBoolean(ctxt.getResources().getString(C0722R.string.preference_publish_as_video), true)) {
                publishAudioFileAsWav(ctxt, inputAudioFilePath);
            } else if (Integer.valueOf(VERSION.SDK).intValue() < 18) {
                builder = new Builder(ctxt);
                builder.setMessage(ctxt.getResources().getText(C0722R.string.share_video_android_version_warnig_message)).setTitle(ctxt.getResources().getText(C0722R.string.share_video_android_version_warnig_title));
                builder.setPositiveButton(ctxt.getResources().getText(C0722R.string.yes_message), new C07181(preferences, ctxt, inputAudioFilePath));
                builder.setNegativeButton(ctxt.getResources().getText(C0722R.string.no_message), new C07192());
                builder.create().show();
            } else {
                try {
                    new VideoCreator(ctxt, inputAudioFilePath, "My Heartbeat Recording.mp4").execute(new Void[0]);
                } catch (Exception e) {
                    builder = new Builder(ctxt);
                    builder.setMessage(ctxt.getResources().getText(C0722R.string.share_video_error_message)).setTitle(ctxt.getResources().getText(C0722R.string.share_video_error_title));
                    builder.setPositiveButton(ctxt.getResources().getText(C0722R.string.yes_message), new C07203(ctxt, inputAudioFilePath));
                    builder.setNegativeButton(ctxt.getResources().getText(C0722R.string.no_message), new C07214());
                    builder.create().show();
                }
            }
        }
    }

    private static void publishAudioFileAsWav(Context ctxt, String inputAudioFilePath) {
        File workDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), VideoCreator.AppDirectory);
        if (!workDir.exists()) {
            workDir.mkdirs();
        }
        File outputFile = copyfile(inputAudioFilePath, workDir, "My Heartbeat Recording.wav");
        if (outputFile != null) {
            Intent sharingIntent = new Intent("android.intent.action.SEND");
            Uri audioUri = Uri.parse("file://" + outputFile.getAbsolutePath());
            sharingIntent.setType("audio/*");
            sharingIntent.putExtra("android.intent.extra.STREAM", audioUri);
            ctxt.startActivity(Intent.createChooser(sharingIntent, ctxt.getResources().getString(C0722R.string.share_audio_message)));
            return;
        }
        Toast.makeText(ctxt, "Error : can not write in external memory", 1).show();
    }

    private static File copyfile(String srFile, File parentDir, String dtFile) {
        try {
            File f1 = new File(srFile);
            File f2 = new File(parentDir, dtFile);
            if (!f2.exists()) {
                f2.createNewFile();
            }
            InputStream in = new FileInputStream(f1);
            OutputStream out = new FileOutputStream(f2);
            byte[] buf = new byte[4096];
            while (true) {
                int len = in.read(buf);
                if (len <= 0) {
                    in.close();
                    out.close();
                    return f2;
                }
                out.write(buf, 0, len);
            }
        } catch (Exception e) {
            return null;
        }
    }
}
