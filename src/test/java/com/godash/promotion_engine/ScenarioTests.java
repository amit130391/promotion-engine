package com.godash.promotion_engine;

import com.godash.promotion_engine.Engine.PromotionEngine;
import com.godash.promotion_engine.Service.CartService;
import com.godash.promotion_engine.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScenarioTests {
    private CartService cartService;

    @BeforeEach
    void setup() {
        ProductService productService = new ProductService();
        PromotionEngine promotionEngine = new PromotionEngine(productService);
        cartService = new CartService(promotionEngine);
    }

    @Test
    void testScenarioA() {
        cartService.addItem("A", 1);
        cartService.addItem("B", 1);
        cartService.addItem("C", 1);

        int total = cartService.getTotal();
        assertEquals(100, total);
    }

    @Test
    void testScenarioB() {
        cartService.addItem("A", 5);
        cartService.addItem("B", 5);
        cartService.addItem("C", 1);

        int total = cartService.getTotal();
        assertEquals(370, total);
    }

    @Test
    void testScenarioC() {
        cartService.addItem("A", 3);
        cartService.addItem("B", 5);
        cartService.addItem("C", 1);
        cartService.addItem("D", 1);

        int total = cartService.getTotal();
        assertEquals(280, total);
    }
}
