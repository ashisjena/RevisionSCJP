package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.deductor;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.Paycheck;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;

public class NullDeductor extends PaymentDeductor {
  public NullDeductor(PaycheckStation paycheckStation) {
    super(paycheckStation);
  }

  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // Doesn't deduct anything
    return true;
  }
}
