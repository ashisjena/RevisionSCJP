package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited;

import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visitor.Visitor;

public interface Product {
  double getPrice();

  double accept(Visitor priceCalculator);
}
