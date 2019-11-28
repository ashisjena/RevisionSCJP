package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitorTaxCalc;

import java.util.Objects;

public abstract class AbstractProduct implements Product {
  private String name;
  private double price;

  public AbstractProduct(String name, double price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AbstractProduct)) return false;
    AbstractProduct that = (AbstractProduct) o;
    return Objects.equals(getName(), that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
