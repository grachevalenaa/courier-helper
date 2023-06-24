package com.example.a5lab;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

public class BigSending implements Sending {

    private double size;

    private boolean fragility;

    private double weight;

    private boolean isCarNeeded;

    public BigSending(double size, boolean fragility, double weight, boolean isCarNeeded) {
        this.size = size;
        this.fragility = fragility;
        this.weight = weight;
        this.isCarNeeded = isCarNeeded;
    }

    @Override
    public boolean isCarNeeded() {
        return isCarNeeded;
    }

    @Override
    public TypeOfSending getTypeOfSending() {
        return TypeOfSending.BIG;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isFragility() {
        return fragility;
    }

    public void setFragility(boolean fragility) {
        this.fragility = fragility;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public void setCarNeeded(boolean carNeeded) {
        isCarNeeded = carNeeded;
    }

}
