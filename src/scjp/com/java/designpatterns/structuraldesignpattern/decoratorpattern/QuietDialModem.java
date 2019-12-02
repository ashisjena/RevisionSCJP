package scjp.com.java.designpatterns.structuraldesignpattern.decoratorpattern;

public class QuietDialModem extends ModemDecorator {
  public QuietDialModem(Modem realModem) {
    super(realModem);
  }

  public void dial(PhoneNumber number) {
    realModem.setSpeakerVolume(0);
    realModem.dial(number);
  }
}
