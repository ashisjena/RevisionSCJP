package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.scheduler;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public class WeeklyScheduler extends PaymentScheduler {
  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // determine weekly schedule
    return true;
  }
}
