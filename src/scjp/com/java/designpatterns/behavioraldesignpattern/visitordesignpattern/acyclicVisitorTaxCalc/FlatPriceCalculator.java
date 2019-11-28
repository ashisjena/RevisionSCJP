package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitorTaxCalc;

public class FlatPriceCalculator implements DovePriceVisitor {
  @Override
  public double visit(Dove product) {
    return product.getPrice();
  }
}
