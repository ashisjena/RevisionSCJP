package scjp.com.java.designpatterns.structuraldesignpattern.decoratorpattern;

public class User {
  private Modem myModem;
  private UserPreferences myPreferences;

  public User(UserPreferences preferences) {
    this.myPreferences = preferences;
  }

  public void procureModem() {
    Modem m = ModemFactory.instance.makeModem();
    if (myPreferences.loudModem) {
      myModem = new LoudDialModem(m);
    } else {
      myModem = new QuietDialModem(m);
    }
  }
}

class UserPreferences {
  final boolean loudModem;

  UserPreferences(boolean loudModem) {
    this.loudModem = loudModem;
  }
}
