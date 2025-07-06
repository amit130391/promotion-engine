package com.godash.promotion_engine.Service;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private final Map<String, Integer> productPrices = new HashMap<>();

    public ProductService() {
        productPrices.put("A", 50);
        productPrices.put("B", 30);
        productPrices.put("C", 20);
        productPrices.put("D", 15);
    }

    public int getPrice(String sku) {
        return productPrices.getOrDefault(sku, 0);
    }
}
