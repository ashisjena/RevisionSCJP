package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.calculator;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;

public abstract class PaymentCalculator extends PaycheckStation {
  public PaymentCalculator(PaycheckStation paycheckStation) {
    super(paycheckStation);
  }
}
