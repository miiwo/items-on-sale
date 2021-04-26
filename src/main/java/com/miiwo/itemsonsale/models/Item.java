package com.miiwo.itemsonsale.models;

public class Item {
    private String name;
    private double price;
    private String category;

    public Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return this.price; }
    public void setPrice(double price) { this.price = price; }
    public String getCategory() { return this.category; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Price: " + this.price + ", Category: " + this.category;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        
        if (!(o instanceof Item)) {
            return false;
        }

        Item otherItem = (Item)o;
        return otherItem.getName().equals(this.name) && otherItem.getPrice() == this.price && otherItem.getCategory().equals(this.category);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + (int) Math.floor(this.price);
        result = 31 * result + this.category.hashCode();
        return result;
    }
}
