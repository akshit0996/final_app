package com.lema.android.heartbeatlistener.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.lema.android.heartbeatlistener.C0722R;
import java.util.HashMap;
import java.util.List;

public class HelpExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private HashMap<String, List<String>> _listDataChild;
    private List<String> _listDataHeader;

    public HelpExpandableListViewAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    public Object getChild(int groupPosition, int childPosititon) {
        return ((List) this._listDataChild.get(this._listDataHeader.get(groupPosition))).get(childPosititon);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return (long) childPosition;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            convertView = ((LayoutInflater) this._context.getSystemService("layout_inflater")).inflate(C0722R.layout.help_listview_content, null);
        }
        ((TextView) convertView.findViewById(C0722R.id.helpListViewContentText)).setText(childText);
        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        return ((List) this._listDataChild.get(this._listDataHeader.get(groupPosition))).size();
    }

    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    public long getGroupId(int groupPosition) {
        return (long) groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            convertView = ((LayoutInflater) this._context.getSystemService("layout_inflater")).inflate(C0722R.layout.help_listview_header, null);
        }
        TextView lblListHeader = (TextView) convertView.findViewById(C0722R.id.helpListViewHeaderText);
        lblListHeader.setTypeface(null, 1);
        lblListHeader.setText(headerTitle);
        return convertView;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
