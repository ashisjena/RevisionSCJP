package scjp.com.java.designpatterns.structuraldesignpattern.adapterpattern;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Main {
  /*
    An adapter pattern acts as a connector between two incompatible interfaces that otherwise can't be connected directly.
    An adapter wraps existing class with a new interface so that it becomes compatible with the client's interface.
   */
  @Test
  public void success() {
    Movable ferrari = new Ferrari();
    MovableAdapter adapter = new MovableAdapterImpl(ferrari);

    assertEquals(adapter.getSpeed(), 482.802, 0.00001);
  }
}
