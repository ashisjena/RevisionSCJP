package scjp.com.java.designpatterns.behavioraldesignpattern.visitordesignpattern.acyclicVisitor;

public interface ZoomVisitor extends ModemVisitor {
  void visit(Zoom modem);
}
