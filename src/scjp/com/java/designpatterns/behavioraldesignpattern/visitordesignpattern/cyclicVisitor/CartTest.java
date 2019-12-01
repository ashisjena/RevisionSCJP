package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor;

import org.junit.Before;
import org.junit.Test;
import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited.Axe;
import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited.Dove;
import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited.Product;
import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visitor.FlatPriceCalculatorVisitor;
import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visitor.Tax12andHalfPriceCalculatorVisitor;
import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visitor.Visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest {

  private Cart cart;
  private Visitor flatPriceCalculator;
  private Visitor tax12andHalfPriceCalculator;

  @Before
  public void setup() {
    cart = new Cart();
    flatPriceCalculator = new FlatPriceCalculatorVisitor();
    tax12andHalfPriceCalculator = new Tax12andHalfPriceCalculatorVisitor();
  }

  private void assertProductAndQuantity(Product product, int quantity) {
    assertTrue(cart.getCartItems().
            stream().
            anyMatch(cartItem -> cartItem.getProduct().equals(product) &&
                    cartItem.getQuantity() == quantity));
  }

  private void addProducts(Product product, int quantity) {
    cart.add(product, quantity);
  }

  @Test
  public void emptyCart() {
    assertEquals(0, cart.getCartItems().size());
  }

  @Test
  public void addNull() {
    cart.add(null);
    assertEquals(0, cart.getCartItems().size());

    addProducts(null, 2);
    assertEquals(0, cart.getCartItems().size());
  }

  @Test
  public void add() {
    Product product = new Dove();
    cart.add(product);

    assertEquals(1, cart.getCartItems().size());
    assertProductAndQuantity(product, 1);
  }

  @Test
  public void addNSimilarProducts() {
    addProducts(new Dove(), 5);

    assertEquals(1, cart.getCartItems().size());
    assertProductAndQuantity(new Dove(), 5);
  }

  @Test
  public void addNSimilarProductsInPhases() {
    addProducts(new Dove(), 5);
    addProducts(new Dove(), 3);

    assertEquals(1, cart.getCartItems().size());
    assertProductAndQuantity(new Dove(), 8);
  }

  @Test
  public void addDifferentProducts() {
    cart.add(new Dove());
    cart.add(new Axe());

    assertEquals(2, cart.getCartItems().size());
    assertProductAndQuantity(new Dove(), 1);
    assertProductAndQuantity(new Axe(), 1);
  }

  @Test
  public void addNDifferentProducts() {
    cart.add(new Dove(), 2);
    cart.add(new Axe(), 3);

    assertEquals(2, cart.getCartItems().size());
    assertProductAndQuantity(new Dove(), 2);
    assertProductAndQuantity(new Axe(), 3);
  }

  @Test
  public void totalCartPrice() {
    addProducts(new Dove(), 5);
    assertEquals(199.95d, cart.getTotalCartPrice(flatPriceCalculator), 0.0d);
  }

  @Test
  public void totalCartPriceAddedProductInPhases() {
    addProducts(new Dove(), 5);
    addProducts(new Dove(), 3);
    assertEquals(319.92d, cart.getTotalCartPrice(flatPriceCalculator), 0.0d);
  }

  @Test
  public void totalCartPriceForMultipleDiffProducts() {
    addProducts(new Axe(), 2);
    addProducts(new Dove(), 3);
    assertEquals(319.95d, cart.getTotalCartPrice(flatPriceCalculator), 0.0d);
  }

  @Test
  public void totalCartPriceForMultipleDiffProductsWith12andHalfPercentTax() {
    addProducts(new Axe(), 2);
    addProducts(new Dove(), 2);
    assertEquals(314.96d, cart.getTotalCartPrice(tax12andHalfPriceCalculator), 0.01d);
  }
}
