package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.scheduler;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public class BiweeklyScheduler extends PaymentScheduler {
  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // determine biweekly schedule
    return true;
  }
}
