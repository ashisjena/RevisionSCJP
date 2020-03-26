package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.scheduler;

import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.Paycheck;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;

import static scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.Employee.PaySchedule.MONTHLY;

public class MonthlyScheduler extends PaymentScheduler {
  public MonthlyScheduler(PaycheckStation paycheckStation) {
    super(paycheckStation);
  }

  @Override
  protected boolean doPaycheck(Paycheck paycheck) {
    if (paycheck.employee.paySchedule == MONTHLY) {
      return shouldPayToday();
    } else {
      return true;
    }
  }

  private boolean shouldPayToday() {
    return false; // determine if Monthly and today is the last day of the month
  }
}
