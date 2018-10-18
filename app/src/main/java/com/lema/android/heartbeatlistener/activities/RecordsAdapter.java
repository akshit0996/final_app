package com.lema.android.heartbeatlistener.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.lema.android.heartbeatlistener.C0722R;
import com.lema.android.heartbeatlistener.utils.files.FileDeletorOnClickListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RecordsAdapter extends ArrayAdapter<File> {
    private final Context context;

    public RecordsAdapter(Context context, ArrayList<File> files) {
        super(context, C0722R.layout.record_list_item, files);
        this.context = context;
    }

    private static String getNameWithoutExtension(File file) {
        int dotIndex = file.getName().lastIndexOf(".");
        if (dotIndex == -1) {
            dotIndex = file.getName().length();
        }
        return file.getName().substring(0, dotIndex);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0722R.layout.record_list_item, parent, false);
        TextView NameView = (TextView) rowView.findViewById(C0722R.id.record_item_title);
        TextView durationView = (TextView) rowView.findViewById(C0722R.id.record_item_duration);
        Date currentFileDate = new Date(((File) getItem(position)).lastModified());
        NameView.setText(getNameWithoutExtension((File) getItem(position)));
        durationView.setText(new StringBuilder(String.valueOf(SimpleDateFormat.getDateInstance().format(currentFileDate))).append(" - ").append(SimpleDateFormat.getTimeInstance().format(currentFileDate)).toString());
        ((Button) rowView.findViewById(C0722R.id.record_item_trash_button)).setOnClickListener(new FileDeletorOnClickListener((File) getItem(position), this));
        return rowView;
    }
}
