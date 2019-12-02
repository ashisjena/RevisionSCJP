package scjp.com.java.designpatterns.structuraldesignpattern.flyweightpattern;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {
  private static Map<Color, Vehicle> vehicleCache = new HashMap<>();
  private static Engine engine = new Engine();

  // Here the intrinsic state is engine. and extrinsic state is class.
  // We check from the class for each extrinsic state. And use the same immutable intrinsic object for each new extrinsic state during the Vehicle creation.
  public static Vehicle createVehicle(Color color) {
    return vehicleCache.computeIfAbsent(color, newColor -> new Car(engine, color));
  }
}
