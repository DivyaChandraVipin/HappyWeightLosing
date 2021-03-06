package com.acadgild.weightlossmagic.question;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import com.acadgild.weightlossmagic.R;
/**
 * Created by DivyaVipin on 3/22/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter{
    private Context _context;
    private List<String> _listDataHeader; // header titles
    private HashMap<String, List<String>> _listDataChild;
    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                             HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
        }
    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this._listDataChild.get(this._listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this._listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {//i is group position
        return this._listDataChild.get(this._listDataHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(i);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.list_group, null);
        }
        TextView lblListHeader = (TextView) view.findViewById(R.id.lblListHeader);
        Typeface font_content = Typeface.createFromAsset(_context.getAssets(), "DroidSerif-Bold.ttf");
       // Typeface font = Typeface.createFromAsset(getAssets(),"BLOODY.ttf");
        lblListHeader.setTypeface(font_content);
       // lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String childText = (String) getChild(i, i1);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.exlist_item, null);
            }
        TextView txtListChild = (TextView) view.findViewById(R.id.lblListItem);
        Typeface font_content = Typeface.createFromAsset(_context.getAssets(), "DroidSerif-Italic.ttf");
        txtListChild.setTypeface(font_content);
        txtListChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
