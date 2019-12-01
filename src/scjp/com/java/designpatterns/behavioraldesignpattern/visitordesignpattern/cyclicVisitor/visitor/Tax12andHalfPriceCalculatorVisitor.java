package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visitor;

import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited.Axe;
import scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.cyclicVisitor.visited.Dove;

public class Tax12andHalfPriceCalculatorVisitor implements Visitor {

  public static final double TAX_RATE = .125d;

  private double computeTotalPrice(double price) {
    return price + price * TAX_RATE;
  }

  @Override
  public double visit(Dove dove) {
    return computeTotalPrice(dove.getPrice());
  }

  @Override
  public double visit(Axe axe) {
    return computeTotalPrice(axe.getPrice());
  }
}
