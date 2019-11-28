package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitorTaxCalc;

public class Dove extends AbstractProduct {

  public Dove(String name, double price) {
    super(name, price);
  }

  @Override
  public double accept(PriceVisitor visitor) {
    return ((DovePriceVisitor) visitor).visit(this);
  }
}
