package org.store.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.store.model.Cart;
import org.store.model.Product;

public class ProductControllerTest {

  @Test
  public void Should_ReturnProducts_When_discountPriceHigherThanZero() {
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
        "Expected offer products do not match actual offer products returned from controller");
  }

  @Test
  public void Should_ReturnCartWithProducts_When_addProductsToCart(){
    // arrange
    ProductController productController = new ProductController();
    List<Product> products =
            List.of(
                    new Product("p1", 1000.0, 100.0),
                    new Product("p2", 500.0, 0.0),
                    new Product("p3", 2000.0, 300.0));
    // act
    Cart actualCart = productController.addProductsToCart(products);
    // assert
    assertNotNull(actualCart);
    assertNotNull(actualCart.getProducts());

  }

  @Test
  public void Should_Return_3500_BasePrice_When_addProductsToCart(){
    // arrange
    ProductController productController = new ProductController();
    List<Product> products =
            List.of(
                    new Product("p1", 1000.0, 100.0),
                    new Product("p2", 500.0, 0.0),
                    new Product("p3", 2000.0, 300.0));
    // act
    Cart actualCart = productController.addProductsToCart(products);
    // assert
    assertEquals(3500.0,actualCart.getBasePrice());
  }

  @Test
  public void Should_Discount_400_FromBasePrice_When_addProductsToCart(){
    // arrange
    ProductController productController = new ProductController();
    List<Product> products =
            List.of(
                    new Product("p1", 1000.0, 100.0),
                    new Product("p2", 500.0, 0.0),
                    new Product("p3", 2000.0, 300.0));
    // act
    Cart actualCart = productController.addProductsToCart(products);
    // assert
    assertEquals(400.0,actualCart.getDiscount());
    assertEquals(3100.0,actualCart.getTotalPrice());
  }
  @Test
  public void Should_Add_10_Percent_Taxes_ToTotalPrice_When_addProductsToCart_With_TotalPrice_Large_Than_2000(){
    // arrange
    ProductController productController = new ProductController();
    List<Product> products =
            List.of(
                    new Product("p1", 1000.0, 100.0),
                    new Product("p2", 500.0, 0.0),
                    new Product("p3", 2000.0, 300.0));
    // act
    Cart actualCart = productController.addProductsToCart(products);
    // assert
    assertEquals(0.1,actualCart.getTaxRate());
    assertEquals(3410.0,actualCart.getTotalPriceAfterTax());
  }
}
