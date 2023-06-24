package com.example.a5lab;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private String name;

    private String balance;

    private final boolean isHaveCar = false;

    private final boolean isCanDeliveryDocuments = true;

    private List<Order> orders;

    public Courier(String name, String balance, List<Order> orders) {
        this.name = name;
        this.balance = balance;
        this.orders = orders;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isHaveCar() {
        return isHaveCar;
    }

    public boolean isCanDeliveryDocuments() {
        return isCanDeliveryDocuments;
    }
}
