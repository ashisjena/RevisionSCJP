package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitor;

public class OSXModemConfigurator implements HayosVisitor, USRVisitor, ZoomVisitor {
  @Override
  public void visit(USR modem) {
    // get any details from the usr modem and do operation. Also can do any standalone operation.
  }

  @Override
  public void visit(Hayos modem) {
    // get any details from the hayos modem and do operation. Also can do any standalone operation.
  }

  @Override
  public void visit(Zoom modem) {
    // get any details from the zoom modem and do operation. Also can do any standalone operation.
  }
}
