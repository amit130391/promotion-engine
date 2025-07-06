package com.godash.promotion_engine.Promotion;

import java.util.Map;

public interface Promotion {
    int apply(Map<String, Integer> cartItems);
}
