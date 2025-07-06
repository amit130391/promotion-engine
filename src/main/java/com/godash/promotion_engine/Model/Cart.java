package com.godash.promotion_engine.Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<String, Integer> items = new HashMap<>();

    public void addItem(String sku, int quantity) {
        items.put(sku, items.getOrDefault(sku, 0) + quantity);
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
