package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.deductor;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public class NullDeductor extends PaymentDeductor {
  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // Doesn't deduct anything
    return true;
  }
}
