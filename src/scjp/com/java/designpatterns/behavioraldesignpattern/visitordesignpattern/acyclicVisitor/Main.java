package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitor;

public class Main {
  public static void main(String[] args) {
    Hayos modem = new Hayos();

    UnixModemConfigurator visitor = new UnixModemConfigurator();
    modem.accept(visitor);
    modem.dial();
    modem.send();
    modem.hangup();
  }
}
