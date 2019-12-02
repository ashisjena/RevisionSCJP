package scjp.com.java.designpatterns.structuraldesignpattern.flyweightpattern;

public class Car implements Vehicle {
  private final Engine engine;
  private final Color color;

  public Car(Engine engine, Color color) {
    this.engine = engine;
    this.color = color;
  }

  @Override
  public void start() {
  }

  @Override
  public void stop() {
  }

  @Override
  public Color getColor() {
    return color;
  }
}
