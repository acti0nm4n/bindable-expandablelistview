package com.clarks.expandablelistviewtest;

/**
 * Created by amaloney on 09/07/2018.
 */

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.clarks.expandablelistviewtest.databinding.BitsBinding;
import com.clarks.expandablelistviewtest.databinding.EntityBinding;


public class MyAdapter extends BaseExpandableListAdapter {

    private final ObservableArrayList<Entity> entityList;
    private EntityBinding parentBinding;
    private BitsBinding childBinding;

    public MyAdapter(ObservableArrayList<Entity> entityList) {

        this.entityList = entityList;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return entityList.get(groupPosition).bits.size();
    }

    @Override
    public Entity getGroup(int groupPosition) {
        return entityList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return entityList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public Bits getChild(int groupPosition, int childPosition) {
        return entityList.get(groupPosition).bits.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            parentBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.entity, viewGroup, false);
            view = parentBinding.getRoot();
        } else {
            parentBinding = (EntityBinding) view.getTag();
        }
        parentBinding.setEntity(entityList.get(i));
        view.setTag(parentBinding);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final int index = i;
        if (view == null) {
            childBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.bits, viewGroup, false);
            view = childBinding.getRoot();
        } else {
            childBinding = (BitsBinding) view.getTag();
        }
        childBinding.setBits(entityList.get(i).bits.get(i1));
        view.setTag(childBinding);
        return view;
    }
}
