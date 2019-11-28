package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitorTaxCalc;

public interface DovePriceVisitor extends PriceVisitor {
  double visit(Dove product);
}
