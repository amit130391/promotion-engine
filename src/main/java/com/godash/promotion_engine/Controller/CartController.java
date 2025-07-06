package com.godash.promotion_engine.Controller;

import com.godash.promotion_engine.Service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add/{sku}/{quantity}")
    public String addItem(@PathVariable String sku, @PathVariable int quantity) {
        cartService.addItem(sku, quantity);
        return "Added " + quantity + " of " + sku;
    }

    @GetMapping("/total")
    public String getTotal() {
        return "Total Price: " + cartService.getTotal();
    }
}

