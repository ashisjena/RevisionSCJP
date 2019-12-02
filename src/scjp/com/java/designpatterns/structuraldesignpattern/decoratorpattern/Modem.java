package scjp.com.java.designpatterns.structuraldesignpattern.decoratorpattern;

public interface Modem {
  void dial(PhoneNumber number);

  void hangUp();

  void send(char c);

  char recv();

  void setSpeakerVolume(int vol);
}
