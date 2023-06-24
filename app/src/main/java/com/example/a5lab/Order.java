package com.example.a5lab;

public class Order {

    private Firm firm;

    private Sending sending;

    private String addressFrom;

    private String addressTo;

    private int cost;

    private boolean isChecked = false;

    public Order(Firm firm, Sending sending, String addressFrom, String addressTo, int cost) {
        this.firm = firm;
        this.sending = sending;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.cost = cost;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public Sending getSending() {
        return sending;
    }

    public void setSending(Sending sending) {
        this.sending = sending;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isBox() {
        return isChecked;
    }

    public void setBox(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
