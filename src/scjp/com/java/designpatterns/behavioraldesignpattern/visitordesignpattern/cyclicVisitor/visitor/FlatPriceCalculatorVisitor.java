package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visitor;

import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited.Axe;
import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited.Dove;

public class FlatPriceCalculatorVisitor implements Visitor {
  @Override
  public double visit(Dove dove) {
    return dove.getPrice();
  }

  @Override
  public double visit(Axe axe) {
    return axe.getPrice();
  }
}
