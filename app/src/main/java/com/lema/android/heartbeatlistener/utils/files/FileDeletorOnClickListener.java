package com.lema.android.heartbeatlistener.utils.files;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import com.lema.android.heartbeatlistener.C0722R;
import java.io.File;

public class FileDeletorOnClickListener implements OnClickListener {
    ArrayAdapter<File> fileAdapter;
    File fileToDelete;

    /* renamed from: com.lema.android.heartbeatlistener.utils.files.FileDeletorOnClickListener$1 */
    class C07431 implements DialogInterface.OnClickListener {
        C07431() {
        }

        public void onClick(DialogInterface dialog, int id) {
            FileDeletorOnClickListener.this.fileAdapter.remove(FileDeletorOnClickListener.this.fileToDelete);
            FileDeletorOnClickListener.this.fileToDelete.delete();
        }
    }

    /* renamed from: com.lema.android.heartbeatlistener.utils.files.FileDeletorOnClickListener$2 */
    class C07442 implements DialogInterface.OnClickListener {
        C07442() {
        }

        public void onClick(DialogInterface dialog, int id) {
        }
    }

    public FileDeletorOnClickListener(File fileToDelete, ArrayAdapter<File> fileAdapter) {
        this.fileToDelete = fileToDelete;
        this.fileAdapter = fileAdapter;
    }

    public void onClick(View v) {
        if (this.fileToDelete != null && this.fileAdapter != null) {
            Builder builder = new Builder(v.getContext());
            builder.setMessage(v.getResources().getText(C0722R.string.delete_record_warning_message)).setTitle(v.getResources().getText(C0722R.string.delete_record_warning_title));
            builder.setPositiveButton(v.getResources().getText(C0722R.string.yes_message), new C07431());
            builder.setNegativeButton(v.getResources().getText(C0722R.string.cancel_message), new C07442());
            builder.create().show();
        }
    }
}
