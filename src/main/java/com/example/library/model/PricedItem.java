package com.example.library.model;

public interface PricedItem {
  static boolean isValidPrice(double price) {
    return price > 0;
  }
}
