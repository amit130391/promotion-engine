package com.godash.promotion_engine.Model;

public class CartItem {
    private String sku;
    private int quantity;

    public CartItem(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }
}
