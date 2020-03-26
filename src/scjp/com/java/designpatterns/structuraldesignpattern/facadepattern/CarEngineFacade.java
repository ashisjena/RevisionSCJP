package scjp.com.java.designpatterns.structuraldesignpattern.facadepattern;

public class CarEngineFacade {
  private static int DEFAULT_COOLING_TEMP = 90;
  private static int MAX_ALLOWED_TEMP = 50;
  private FuelInjector fuelInjector = new FuelInjector();
  private AirFlowController airFlowController = new AirFlowController();
  private Starter starter = new Starter();
  private CoolingController coolingController = new CoolingController();
  private CatalyticConverter catalyticConverter = new CatalyticConverter();

  /*
      Facade encapsulates a complex subsystem behind a simple interface.
      It hides much of the complexity and makes the subsystems easy to use.
      So it's a simple interface. Just facade.startEngine() and facade.stopEngine()
      It decouples a client implementation from the complex subsystem.
   */
  public void startEngine() {
    fuelInjector.on();
    airFlowController.takeAir();
    fuelInjector.on();
    fuelInjector.inject();
    starter.start();
    coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
    coolingController.run();
    catalyticConverter.on();
  }

  public void stopEngine() {
    fuelInjector.off();
    catalyticConverter.off();
    coolingController.cool(MAX_ALLOWED_TEMP);
    coolingController.stop();
    airFlowController.off();
  }

  class CatalyticConverter {
    public void on() {
    }

    public void off() {
    }
  }

  class Starter {
    public void start() {
    }
  }

  class CoolingController {
    public void setTemperatureUpperLimit(int deffaultCoolingTemp) {
    }

    public void run() {
    }

    public void cool(int maxAllowedTemp) {
    }

    public void stop() {
    }
  }

  class AirFlowController {
    public void takeAir() {
    }

    public void off() {
    }
  }

  class FuelInjector {
    public void on() {
    }

    public void inject() {
    }

    public void off() {
    }
  }

}
