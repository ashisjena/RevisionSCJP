package scjp.com.java.designpatterns.structuraldesignpattern.decoratorpattern;

public class ModemDecorator implements Modem {
  protected final Modem realModem;

  public ModemDecorator(Modem realModem) {
    this.realModem = realModem;
  }

  @Override
  public void dial(PhoneNumber number) {
    realModem.dial(number);
  }

  @Override
  public void hangUp() {
    realModem.hangUp();
  }

  @Override
  public void send(char c) {
    realModem.send(c);
  }

  @Override
  public char recv() {
    return realModem.recv();
  }

  @Override
  public void setSpeakerVolume(int vol) {
    realModem.setSpeakerVolume(vol);
  }
}
