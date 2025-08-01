package com.godash.promotion_engine.Promotion;

import com.godash.promotion_engine.Service.ProductService;

import java.util.Map;

public class VolumeBasedPromotion implements Promotion {
    private final String sku;
    private final int quantity;
    private final int fixedPrice;
    private final ProductService productService;

    public VolumeBasedPromotion(String sku, int quantity, int fixedPrice, ProductService productService) {
        this.sku = sku;
        this.quantity = quantity;
        this.fixedPrice = fixedPrice;
        this.productService = productService;
    }

    @Override
    public int apply(Map<String, Integer> cartItems) {
        int total = 0;
        if (cartItems.containsKey(sku)) {
            int count = cartItems.get(sku);
            int numDeals = count / quantity;
            int remainder = count % quantity;

            total += numDeals * fixedPrice + remainder * productService.getPrice(sku);
            cartItems.put(sku, 0);
        }
        return total;
    }
}