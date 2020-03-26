package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.Paycheck;

public abstract class PaycheckStation {
  private PaycheckStation nextStation;

  public PaycheckStation(PaycheckStation nextStation) {
    this.nextStation = nextStation;
  }

  public void handlePaycheck(Paycheck paycheck) {
    if (doPaycheck(paycheck) && nextStation != null) {
      nextStation.handlePaycheck(paycheck);
    }
  }

  protected abstract boolean doPaycheck(Paycheck paycheck);
}
