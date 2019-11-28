package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitor;

public interface Modem {
  void send();

  void recv();

  void dial();

  void hangup();

  void accept(ModemVisitor visitor);
}
