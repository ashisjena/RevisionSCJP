package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitorTaxCalc;

public interface Product {
  String getName();

  double getPrice();

  double accept(PriceVisitor visitor);
}
