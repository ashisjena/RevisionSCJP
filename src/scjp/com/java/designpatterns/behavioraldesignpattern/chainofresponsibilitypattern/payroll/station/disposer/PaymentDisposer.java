package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.disposer;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;

public abstract class PaymentDisposer extends PaycheckStation {
  public PaymentDisposer(PaycheckStation paycheckStation) {
    super(paycheckStation);
  }
}
