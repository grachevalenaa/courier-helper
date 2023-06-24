package com.example.a5lab;

public class Document implements Sending {

    private double size;

    private boolean fragility;

    private double weight;

    private String address;

    public Document(double size, boolean fragility, double weight, String address) {
        this.size = size;
        this.fragility = fragility;
        this.weight = weight;
        this.address = address;
    }

    @Override
    public boolean isCarNeeded() {
        return false;
    }

    @Override
    public TypeOfSending getTypeOfSending() {
        return TypeOfSending.DOCUMENT;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
