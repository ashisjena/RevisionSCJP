package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor;

import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited.Product;
import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visitor.Visitor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {
  private final Map<Product, Integer> productMap;

  public Cart() {
    this.productMap = new HashMap<>();
  }

  private void updateQuantity(Product product, int quantity) {
    this.productMap.put(product, quantity);
  }

  public void add(Product product, int quantity) {
    if (product == null) {
      return;
    }

    Integer existingQuantity = this.productMap.get(product);
    if (existingQuantity == null) {
      existingQuantity = 0;
    }
    updateQuantity(product, quantity + existingQuantity);
  }


  public void add(Product product) {
    add(product, 1);
  }

  public List<CartItem> getCartItems() {
    return productMap.
            entrySet().
            stream().
            map(entry -> new CartItem(entry.getKey(), entry.getValue())).
            collect(Collectors.toList());
  }

  public double getTotalCartPrice(Visitor priceCalculator) {
    final double totalPrice = productMap.
            entrySet().
            stream().
            reduce(0.0d, (acc, entry) -> acc + entry.getKey().accept(priceCalculator) * entry.getValue(), Double::sum);

    return new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }
}
