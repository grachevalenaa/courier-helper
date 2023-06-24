package com.example.a5lab;

public class LittleSending implements Sending {

    private double size;

    private boolean fragility;

    private final double WEIGHT = 0;

    LittleSending(double newSize, boolean newFragiliry) {
        size = newSize;
        fragility = newFragiliry;
    }

    LittleSending() {
    }

    @Override
    public TypeOfSending getTypeOfSending() {
        return TypeOfSending.LITTLE;
    }

    @Override
    public boolean isCarNeeded() {
        return false;
    }

    public double getSize() {
        return size;
    }

    public boolean isFragility() {
        return fragility;
    }

    public double getWEIGHT() {
        return WEIGHT;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setFragility(boolean fragility) {
        this.fragility = fragility;
    }

}
