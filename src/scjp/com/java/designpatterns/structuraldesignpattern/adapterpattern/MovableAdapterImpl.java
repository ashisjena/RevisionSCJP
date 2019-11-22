package scjp.com.java.designpatterns.structuraldesignpattern.adapterpattern;

public class MovableAdapterImpl implements MovableAdapter {
  private Movable luxuryCar;

  public MovableAdapterImpl(Movable luxuryCar) {
    this.luxuryCar = luxuryCar;
  }

  @Override
  public double getSpeed() {
    return convertMPHtoKMPH(luxuryCar.getSpeed());
  }

  private double convertMPHtoKMPH(double mph) {
    return mph * 1.60934;
  }
}
