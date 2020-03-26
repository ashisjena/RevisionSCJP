package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.scheduler;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;

public abstract class PaymentScheduler extends PaycheckStation {
  public PaymentScheduler(PaycheckStation paycheckStation) {
    super(paycheckStation);
  }
}
