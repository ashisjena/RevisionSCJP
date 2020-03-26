package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.Paycheck;

public abstract class PaycheckStation {
  private PaycheckStation nextStation;

  public void handlePaycheck(Paycheck paycheck) {
    if (doPaycheck(paycheck) && nextStation != null) {
      nextStation.handlePaycheck(paycheck);
    }
  }

  protected abstract boolean doPaycheck(Paycheck paycheck);

  public PaycheckStation setNext(PaycheckStation next) {
    this.nextStation = next;
    return this;
  }
}
