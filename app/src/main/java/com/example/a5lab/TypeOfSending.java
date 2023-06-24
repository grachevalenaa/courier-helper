package com.example.a5lab;

public enum TypeOfSending {

    LITTLE ("Маленькая посылка"),

    BIG ("Большая посылка"),

    DOCUMENT ("Документ");
    private final String text;


    TypeOfSending(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
