package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.deductor;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public class UnionDeductor extends PaymentDeductor {
  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // deduct money for the union.
    return true;
  }
}
