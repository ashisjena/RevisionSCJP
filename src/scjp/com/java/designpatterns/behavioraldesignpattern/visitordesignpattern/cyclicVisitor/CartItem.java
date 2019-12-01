package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor;

import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited.Product;

public final class CartItem {
  private final Product product;
  private final Integer quantity;

  public CartItem(Product product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public Integer getQuantity() {
    return quantity;
  }
}
