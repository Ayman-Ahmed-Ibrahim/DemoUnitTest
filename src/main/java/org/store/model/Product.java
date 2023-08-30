package org.store.model;

import java.util.Objects;

public class Product {
  String title;
  Double price;
  Double discountPrice;

  public Product(String title, Double price, Double discountPrice) {
    this.title = title;
    this.price = price;
    this.discountPrice = discountPrice;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getDiscountPrice() {
    return discountPrice;
  }

  public void setDiscountPrice(Double discountPrice) {
    this.discountPrice = discountPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(title, product.title)
        && Objects.equals(price, product.price)
        && Objects.equals(discountPrice, product.discountPrice);
  }
}
