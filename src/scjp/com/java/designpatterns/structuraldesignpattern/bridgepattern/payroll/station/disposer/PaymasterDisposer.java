package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.disposer;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public class PaymasterDisposer extends PaymentDisposer {
  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // dispose through paymaster
    return true;
  }
}
