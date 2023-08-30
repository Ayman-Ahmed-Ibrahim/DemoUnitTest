package org.store.controller;

import org.store.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductController {

  public List<Product> getOfferProducts(List<Product> products) {
    return products.stream()
        .filter(product -> product.getDiscountPrice() > 0)
        .collect(Collectors.toList());
  }
}
