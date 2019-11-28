package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitorTaxCalc;

import java.util.*;
import java.util.stream.Collectors;

public class Cart {
  private Map<Product, Integer> items;

  public Cart() {
    this.items = new HashMap<>();
  }

  public void addItem(Product item) {
    Integer quantity = items.get(item);
    if (quantity == null) {
      quantity = 0;
    }

    updateQuantity(item, quantity + 1);
  }

  public Optional<Product> removeItem(Product item) {
    Integer quantity = items.get(item);
    if (quantity == null) {
      return Optional.empty();
    }

    updateQuantity(item, quantity - 1);
    return Optional.of(item);
  }

  private void updateQuantity(Product item, int quantity) {
    if (quantity == 0) {
      items.remove(item);
    } else {
      items.put(item, quantity);
    }
  }

  public List<CartItem> getAllItems() {
    return items.entrySet().
            stream().
            map(entry -> new CartItem(entry.getKey(), entry.getValue())).
            collect(Collectors.toList());
  }
}
