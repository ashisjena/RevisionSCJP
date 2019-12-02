package scjp.com.java.designpatterns.structuraldesignpattern.decoratorpattern;

public class LoudDialModem extends ModemDecorator {
  public LoudDialModem(Modem realModem) {
    super(realModem);
  }

  public void dial(PhoneNumber number) {
    realModem.setSpeakerVolume(10);
    realModem.dial(number);
  }
}
