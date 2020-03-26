package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.deductor;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;

public abstract class PaymentDeductor extends PaycheckStation {
  public PaymentDeductor(PaycheckStation paycheckStation) {
    super(paycheckStation);
  }
}
