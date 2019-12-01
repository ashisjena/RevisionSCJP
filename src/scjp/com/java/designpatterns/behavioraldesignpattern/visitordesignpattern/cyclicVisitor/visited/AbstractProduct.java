package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited;

public abstract class AbstractProduct implements Product {
  protected final String name;
  protected final double price;

  protected AbstractProduct(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  @Override
  public double getPrice() {
    return price;
  }
}
