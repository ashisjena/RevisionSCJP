package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.disposer;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public class DepositDisposer extends PaymentDisposer{
  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // implement deposit disposer
    return true;
  }
}
