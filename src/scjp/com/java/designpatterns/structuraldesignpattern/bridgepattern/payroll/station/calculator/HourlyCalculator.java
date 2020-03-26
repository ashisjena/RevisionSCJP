package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.calculator;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public class HourlyCalculator extends PaymentCalculator {
  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // Calculate hourly pay
    return true;
  }
}
