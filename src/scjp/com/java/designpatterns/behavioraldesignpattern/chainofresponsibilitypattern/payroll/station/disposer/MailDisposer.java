package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.disposer;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.Paycheck;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;

public class MailDisposer extends PaymentDisposer {
  public MailDisposer(PaycheckStation paycheckStation) {
    super(paycheckStation);
  }

  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // dispose through mail.
    return true;
  }
}
