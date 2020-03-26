package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll;


import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.PaycheckStation;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.calculator.CommissionedCalculator;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.calculator.HourlyCalculator;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.calculator.SalariedCalculator;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.deductor.NullDeductor;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.deductor.UnionDeductor;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.disposer.DepositDisposer;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.disposer.MailDisposer;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.disposer.PaymasterDisposer;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.scheduler.BiweeklyScheduler;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.scheduler.MonthlyScheduler;
import scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll.station.scheduler.WeeklyScheduler;

import java.util.List;

public class Payroll {
  private List<Employee> employees;
  private PaycheckStation paycheckStations;

  public Payroll(List<Employee> employees) {
    this.employees = employees;
  }

  public void setupPaycheckStations() {
    paycheckStations =
      new WeeklyScheduler(
        new MonthlyScheduler(
          new BiweeklyScheduler(
            new HourlyCalculator(
              new SalariedCalculator(
                new CommissionedCalculator(
                  new NullDeductor(
                    new UnionDeductor(
                      new DepositDisposer(
                        new MailDisposer(
                          new PaymasterDisposer(null)
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      );
  }

  public void payday() {
    for (Employee e : employees) {
      Paycheck pc = new Paycheck(e);
      paycheckStations.handlePaycheck(pc);
    }
  }
}
