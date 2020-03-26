package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll;

import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.PaycheckStation;
import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.calculator.PaymentCalculator;
import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.deductor.PaymentDeductor;
import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.disposer.PaymentDisposer;
import scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern.payroll.station.scheduler.PaymentScheduler;

public class Employee {
  private final PaymentScheduler scheduler;
  private final PaymentCalculator calculator;
  private final PaymentDeductor deductor;
  private final PaymentDisposer disposer;

  public Employee(PaymentScheduler scheduler, PaymentCalculator calculator, PaymentDeductor deductor, PaymentDisposer disposer) {
    this.scheduler = scheduler;
    this.calculator = calculator;
    this.deductor = deductor;
    this.disposer = disposer;
  }

  public PaycheckStation getDisposer() {
    disposer.setNext(null);
    return disposer;
  }

  public PaycheckStation getDeductorAndBridgeTo(PaycheckStation next) {
    deductor.setNext(next);
    return deductor;
  }

  public PaycheckStation getCalculatorAndBridgeTo(PaycheckStation next) {
    calculator.setNext(next);
    return calculator;
  }

  public PaycheckStation getSchedulerAndBridgeTo(PaycheckStation next) {
    scheduler.setNext(next);
    return scheduler;
  }
}
