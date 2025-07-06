package com.godash.promotion_engine;

import com.godash.promotion_engine.Promotion.PairedItemsPromotion;
import com.godash.promotion_engine.Promotion.VolumeBasedPromotion;
import com.godash.promotion_engine.Service.ProductService;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionEngineTests {
    private final ProductService productService = new ProductService();

    @Test
    void testVolumeBasedPromotion() {
        VolumeBasedPromotion promotion = new VolumeBasedPromotion("A", 3, 130, productService);
        Map<String, Integer> cartItems = new HashMap<>();
        cartItems.put("A", 4);

        int total = promotion.apply(cartItems);
        assertEquals(130 + 50, total);
        assertEquals(0, cartItems.get("A"));  // consumed
    }

    @Test
    void testPairedItemsPromotion() {
        PairedItemsPromotion promotion = new PairedItemsPromotion("C", "D", 30, productService);
        Map<String, Integer> cartItems = new HashMap<>();
        cartItems.put("C", 1);
        cartItems.put("D", 1);

        int total = promotion.apply(cartItems);
        assertEquals(30, total);
        assertEquals(0, cartItems.get("C"));
        assertEquals(0, cartItems.get("D"));
    }
}
