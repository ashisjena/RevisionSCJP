package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.calculator;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.Paycheck;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;

public class HourlyCalculator extends PaymentCalculator {
  public HourlyCalculator(PaycheckStation paycheckStation) {
    super(paycheckStation);
  }

  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    // Calculate hourly pay
    return true;
  }
}
