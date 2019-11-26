package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.tableApproach;

public class Main {
  public static void main(String[] args) {
    Turnstile turnstile = new Turnstile();
    turnstile.handleEvent(Event.PASS);
    turnstile.handleEvent(Event.COIN);
    turnstile.handleEvent(Event.COIN);
  }
}
