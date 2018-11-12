package com.lema.android.heartbeatlistener.utils.files;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import com.lema.android.heartbeatlistener.R;
import java.io.File;

public class FileDeletorOnClickListener implements OnClickListener {
    ArrayAdapter<File> fileAdapter;
    File fileToDelete;

    public FileDeletorOnClickListener(File fileToDelete, ArrayAdapter<File> fileAdapter) {
        this.fileToDelete = fileToDelete;
        this.fileAdapter = fileAdapter;
    }

    public void onClick(View v) {
        if (this.fileToDelete != null && this.fileAdapter != null) {
            Builder builder = new Builder(v.getContext());
            builder.setMessage(v.getResources().getText(R.string.delete_record_warning_message)).setTitle(v.getResources().getText(R.string.delete_record_warning_title));
            builder.setPositiveButton(v.getResources().getText(R.string.yes_message), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    FileDeletorOnClickListener.this.fileAdapter.remove(FileDeletorOnClickListener.this.fileToDelete);
                    FileDeletorOnClickListener.this.fileToDelete.delete();
                }
            });
            builder.setNegativeButton(v.getResources().getText(R.string.cancel_message), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            builder.create().show();
        }
    }
}
