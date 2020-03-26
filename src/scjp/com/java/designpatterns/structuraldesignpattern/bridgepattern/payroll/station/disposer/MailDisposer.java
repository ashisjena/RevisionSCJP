package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.disposer;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public class MailDisposer extends PaymentDisposer {
  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // dispose through mail.
    return true;
  }
}
