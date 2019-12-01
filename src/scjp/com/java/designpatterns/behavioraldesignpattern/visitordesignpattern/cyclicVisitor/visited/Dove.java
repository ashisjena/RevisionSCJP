package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited;

import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visitor.Visitor;

import java.util.Objects;

public class Dove extends AbstractProduct {

  public Dove() {
    this(39.99d);
  }

  public Dove(double price) {
    super(Dove.class.getName(), price);
  }

  @Override
  public double accept(Visitor priceCalculator) {
    return priceCalculator.visit(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Dove)) return false;
    Dove dove = (Dove) o;
    return Objects.equals(getName(), dove.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
