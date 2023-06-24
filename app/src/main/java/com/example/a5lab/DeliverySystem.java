package com.example.a5lab;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DeliverySystem {

    private static List<Firm> firms;

    private static List<Order> orders;

    private static List<Sending> sendings;

    private static Courier courier;

    private static int totalPrice = 0;

    public DeliverySystem() {
        firms = new ArrayList<>();
        orders = new ArrayList<>();
        sendings = new ArrayList<>();
        courier = new Courier("Девятайкин Максим Олегович", "40817810099910004312", new ArrayList<>());
        firms.add(new Firm( "Офис Лефортово", "г.Москва, ул.Солдатская"));
        firms.add(new Firm("Офис Электрозаводская", "г.Москва, ул.Семеновская Набережная" ));
        sendings.add(new LittleSending(50, true));
        sendings.add(new LittleSending(200, false));
        sendings.add(new BigSending(300, false, 20, false));
        sendings.add(new BigSending(150, true, 10, false));
        sendings.add(new Document(20, true, 0.5, "Из Москвы в Санкт-Петербург"));
        sendings.add(new Document(20, true, 0.2, "Из Москвы в Казань"));
        orders.add(new Order(firms.get(1), sendings.get(5), "Пятницкое ш., 39", " ул. Бутлерова, 22", 900));
        orders.add(new Order(firms.get(1), sendings.get(4), "ул. Городецкая, 5", "Каланчевская ул., 33", 700));
        orders.add(new Order(firms.get(0), sendings.get(1), "ул. Большая Полянка, 1/3", "ул. Фридриха Энгельса, 21", 500));
        orders.add(new Order(firms.get(0), sendings.get(2), "Каланчевская ул., 35", "ул. Большая Полянка, 1/3", 1200));
        orders.add(new Order(firms.get(1), sendings.get(3), "ул. Щепкина, 27", "ул. Новый Арбат, 21", 1150));
        orders.add(new Order(firms.get(0), sendings.get(0), "ул. Новый Арбат, 21", "ул. Петровские Линии", 800));
    }

    public static boolean courierAbility(int indexOrder) {
        Log.d(("ON_CLICK"), "Тип посылки: " + orders.get(indexOrder).getSending().getTypeOfSending() + " Есть машина: " + courier.isHaveCar() + " Нужна ли она: " +
                orders.get(indexOrder).getSending().isCarNeeded() + " Может ли  курьер доставлять доки: " + courier.isCanDeliveryDocuments() + " end");

        if (orders.get(indexOrder).getSending().isCarNeeded() == courier.isHaveCar()) {
            Log.d("ON_CLICK", "Прошёл по критерию машины");
            if (orders.get(indexOrder).getSending().getTypeOfSending().equals(TypeOfSending.DOCUMENT) && (!courier.isCanDeliveryDocuments())) {
                Log.d("ON_CLICK", "Не прошёл по критерию документа");
                return false;
            }
            Log.d("ON_CLICK", "Прошёл по критерию документа");
            return true;
        }

        Log.d("ON_CLICK", "Не прошёл по критерию машины");
        return false;
    }

    public List<Firm> getFirms() {
        return firms;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Sending> getSendings() {
        return sendings;
    }

    public Courier getCourier() {
        return courier;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }

    public static void increaseTotalPrice(int addition) {
        DeliverySystem.totalPrice += addition;
    }
}
