package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitorTaxCalc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest {
  private Cart cart;

  @Before
  public void setUp() {
    this.cart = new Cart();
  }

  private Dove getDove() {
    return new Dove("Dove", 33.99);
  }

  @Test
  public void addToCart() {
    Product product = getDove();
    cart.addItem(product);
    assertTrue(cart.getAllItems().stream().anyMatch(cartItem -> product.equals(cartItem.getItem())));
  }

  @Test
  public void removeFromCart() {
    Product product = getDove();
    cart.addItem(product);
    cart.removeItem(product);
    assertTrue(cart.getAllItems().stream().noneMatch(cartItem -> product.equals(cartItem.getItem())));
  }

  @Test
  public void calculateCartPrice() {
    Product product = getDove();
    cart.addItem(product);
    cart.addItem(product);
    FlatPriceCalculator priceCalculator = new FlatPriceCalculator();

    assertEquals(67.98d, cart.getAllItems().
            stream().
            reduce(0.0d, (acc, cartItem) -> acc + priceCalculator.visit((Dove) cartItem.getItem()) * cartItem.getQuantity(), Double::sum), 0.0d);
  }

}
