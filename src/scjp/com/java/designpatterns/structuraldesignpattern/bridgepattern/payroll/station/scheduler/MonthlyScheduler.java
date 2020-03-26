package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.scheduler;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public class MonthlyScheduler extends PaymentScheduler {
  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // Determine Monthly payment schedule.
    return true;
  }
}
