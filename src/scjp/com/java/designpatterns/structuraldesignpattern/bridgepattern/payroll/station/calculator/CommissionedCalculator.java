package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.calculator;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public class CommissionedCalculator extends PaymentCalculator {
  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // calculate the commission
    return true;
  }
}
