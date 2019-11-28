package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitor;

public class Zoom implements Modem {
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
    if (visitor instanceof ZoomVisitor) {
      ((ZoomVisitor) visitor).visit(this);
    }
  }
}
