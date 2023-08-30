package org.store.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.store.model.Product;

public class ProductControllerTest {

  @Test
  public void Should_ReturnProducts_When_DiscountPriceHigherThanZero() {
    // arrange
    ProductController productController = new ProductController();
    List<Product> products =
        List.of(
            new Product("p1", 1000.0, 100.0),
            new Product("p2", 500.0, 0.0),
            new Product("p3", 2000.0, 300.0));
    // act
    List<Product> actualProducts = productController.getOfferProducts(products);
    // assert
    assertNotEquals(actualProducts.size(), 0);
    List<Product> expectedProduct =
        List.of(new Product("p1", 1000.0, 100.0), new Product("p3", 2000.0, 300.0));
    assertArrayEquals(
        expectedProduct.toArray(),
        actualProducts.toArray(),
        "Expected offer products don not match actual offer products returned from controller");
  }
}
