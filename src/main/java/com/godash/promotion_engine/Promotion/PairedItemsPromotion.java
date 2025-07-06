package com.Godash.PromotionEngine.Promotion;

import com.Godash.PromotionEngine.Service.ProductService;

import java.util.Map;

public class PairedItemsPromotion implements Promotion {
    private final String sku1;
    private final String sku2;
    private final int fixedPrice;
    private final ProductService productService;

    public PairedItemsPromotion(String sku1, String sku2, int fixedPrice, ProductService productService) {
        this.sku1 = sku1;
        this.sku2 = sku2;
        this.fixedPrice = fixedPrice;
        this.productService = productService;
    }

    @Override
    public int apply(Map<String, Integer> cartItems) {
        int total = 0;
        if (cartItems.containsKey(sku1) && cartItems.containsKey(sku2)) {
            int numCombos = Math.min(cartItems.get(sku1), cartItems.get(sku2));
            total += numCombos * fixedPrice;
            cartItems.put(sku1, cartItems.get(sku1) - numCombos);
            cartItems.put(sku2, cartItems.get(sku2) - numCombos);
        }
        return total;
    }
}
