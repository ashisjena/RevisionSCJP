package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.disposer;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.Paycheck;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;

public class DepositDisposer extends PaymentDisposer {
  public DepositDisposer(PaycheckStation paycheckStation) {
    super(paycheckStation);
  }

  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // implement deposit disposer
    return true;
  }
}
