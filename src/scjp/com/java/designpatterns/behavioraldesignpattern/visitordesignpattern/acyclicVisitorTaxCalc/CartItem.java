package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitorTaxCalc;

public class CartItem {
  private Product item;
  private int quantity;

  public CartItem(Product item, int quantity) {
    this.item = item;
    this.quantity = quantity;
  }

  public Product getItem() {
    return item;
  }

  public int getQuantity() {
    return quantity;
  }
}
