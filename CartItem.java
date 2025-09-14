package com.ecommerce.model;

public class CartItem {
    private int id;
    private String name;
    private double price;
    private int quantity;

    // Constructor using fields directly
    public CartItem(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // ✅ Constructor that accepts a Product object
    public CartItem(Product product, int quantity) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = quantity;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // ✅ Utility: calculate total price for this item
    public double getTotalPrice() {
        return price * quantity;
    }
}
