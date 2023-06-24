package com.example.a5lab;

public class Firm {

    private String address;

    private String name;

    Firm(String newName, String newAddress) {
        address = newAddress;
        name = newName;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }
}
