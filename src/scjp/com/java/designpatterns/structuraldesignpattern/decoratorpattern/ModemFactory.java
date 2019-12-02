package scjp.com.java.designpatterns.structuraldesignpattern.decoratorpattern;

import com.sun.deploy.config.OSType;

public class ModemFactory {
  static ModemFactory instance = new ModemFactory();

  public Modem makeModem() {
    if (OSType.isWin()) {
      return new HayesModem();
    } else {
      return new USRoboticsModem();
    }
  }
}
