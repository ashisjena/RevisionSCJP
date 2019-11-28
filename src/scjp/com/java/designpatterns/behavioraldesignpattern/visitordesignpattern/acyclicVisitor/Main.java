package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitor;

public class Main {
  public static void main(String[] args) {
    Hayos modem = new Hayos();

    UnixModemConfigurator visitor = new UnixModemConfigurator();
    visitor.visit(modem);
    modem.dial();
    modem.send();
    modem.hangup();
  }
}
