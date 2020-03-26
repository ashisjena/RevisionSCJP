package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.calculator;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.Paycheck;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;

import static scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.Employee.PayType.SALARIED;

public class SalariedCalculator extends PaymentCalculator {
  public SalariedCalculator(PaycheckStation paycheckStation) {
    super(paycheckStation);
  }

  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.payType == SALARIED) {
      // do calculation
    }
    return true;
  }
}
