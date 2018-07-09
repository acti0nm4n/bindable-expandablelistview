package com.clarks.expandablelistviewtest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

/**
 * Created by amaloney on 09/07/2018.
 */

public class Entity extends BaseObservable {

    @Bindable
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public ObservableArrayList<Bits> bits;
}
