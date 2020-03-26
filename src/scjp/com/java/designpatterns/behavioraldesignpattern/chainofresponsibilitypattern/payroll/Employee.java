package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.payroll;

public class Employee {
  public enum PayType {SALARIED, COMMISSIONED, HOURLY}

  public enum PaySchedule {WEEKLY, BIWEEKLY, MONTHLY}

  public enum PayDeduction {NONE, UNION}

  public enum PayDisposition {MAIL, DIRECT, PAYMASTER}

  public PayType payType;
  public PaySchedule paySchedule;
  public PayDeduction payDeduction;
  public PayDisposition payDisposition;

  public Employee(PayType payType, PaySchedule paySchedule, PayDeduction payDeduction, PayDisposition payDisposition) {
    this.payType = payType;
    this.paySchedule = paySchedule;
    this.payDeduction = payDeduction;
    this.payDisposition = payDisposition;
  }
}
