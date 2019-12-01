package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited;

import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visitor.Visitor;

import java.util.Objects;

public class Axe extends AbstractProduct {

  public Axe() {
    this(99.99d);
  }

  public Axe(double price) {
    super(Axe.class.getName(), price);
  }

  @Override
  public double accept(Visitor priceCalculator) {
    return priceCalculator.visit(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Axe)) return false;
    Axe axe = (Axe) o;
    return Objects.equals(getName(), axe.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
