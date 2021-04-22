package com.miiwo.itemsonsale.models;

public class Items {
    private int id;
    private String name;
    private double price;

    public Items(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() { return this.name; }
    public double getPrice() { return this.price; }
}
