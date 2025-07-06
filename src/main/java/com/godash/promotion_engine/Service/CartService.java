package com.godash.promotion_engine.Service;

import com.godash.promotion_engine.Engine.PromotionEngine;
import com.godash.promotion_engine.Model.Cart;

public class CartService {
    private final Cart cart = new Cart();
    private final PromotionEngine promotionEngine;

    public CartService(PromotionEngine promotionEngine) {
        this.promotionEngine = promotionEngine;
    }

    public void addItem(String sku, int quantity) {
        cart.addItem(sku, quantity);
    }

    public int getTotal() {
        int total = promotionEngine.calculateTotal(cart);
        cart.clear();
        return total;
    }
}
