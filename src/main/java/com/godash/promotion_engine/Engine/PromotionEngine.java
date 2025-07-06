package com.godash.promotion_engine.Engine;

import com.godash.promotion_engine.Model.Cart;
import com.godash.promotion_engine.Promotion.PairedItemsPromotion;
import com.godash.promotion_engine.Promotion.Promotion;
import com.godash.promotion_engine.Promotion.VolumeBasedPromotion;
import com.godash.promotion_engine.Service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class PromotionEngine {
    private final List<Promotion> promotions = new ArrayList<>();
    private final ProductService productService;

    public PromotionEngine(ProductService productService) {
        this.productService = productService;

        promotions.add(new VolumeBasedPromotion("A", 3, 130, productService));
        promotions.add(new VolumeBasedPromotion("B", 2, 45, productService));
        promotions.add(new PairedItemsPromotion("C", "D", 30, productService));
    }

    public int calculateTotal(Cart cart) {
        int total = 0;
        var cartItems = cart.getItems();
        for (Promotion promo : promotions) {
            total += promo.apply(cartItems);
        }
        for (var entry : cartItems.entrySet()) {
            total += entry.getValue() * productService.getPrice(entry.getKey());
        }
        return total;
    }
}
