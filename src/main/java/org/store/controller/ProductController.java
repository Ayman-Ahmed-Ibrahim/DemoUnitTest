package org.store.controller;

import org.store.model.Cart;
import org.store.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductController {

  public List<Product> getOfferProducts(List<Product> products) {
    return products.stream()
        .filter(product -> product.getDiscountPrice() > 0)
        .collect(Collectors.toList());
  }

  public Cart addProductsToCart(List<Product> products) {
    Cart cart = new Cart();
    cart.setProducts(products);
    Double basePrice = 0.0;
    Double totalPrice = 0.0;
    Double totalDiscount = 0.0;
    Double taxRate = 0.0;
    for (Product product : products) {
      basePrice += product.getPrice();
      totalDiscount += product.getDiscountPrice();
    }
    cart.setBasePrice(basePrice);
    cart.setDiscount(totalDiscount);
    totalPrice = basePrice - totalDiscount;
    cart.setTotalPrice(totalPrice);
    taxRate = totalPrice >= 2000.0 ? 0.1 : 0.14;
    cart.setTaxRate(taxRate);
    cart.setTotalPriceAfterTax(totalPrice + (totalPrice * taxRate));
    return cart;
  }
}
