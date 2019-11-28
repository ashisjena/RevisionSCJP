package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitor;

public class Hayos implements Modem {
  @Override
  public void send() {

  }

  @Override
  public void recv() {

  }

  @Override
  public void dial() {

  }

  @Override
  public void hangup() {

  }

  @Override
  public void accept(ModemVisitor visitor) {
    if (visitor instanceof HayosVisitor) {
      ((HayosVisitor) visitor).visit(this);
    }
  }
}
