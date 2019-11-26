package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.tableApproach;

import java.util.function.Consumer;

public class Transition {
  State currentState;
  Event event;
  State newState;
  Consumer<Turnstile> action;

  public Transition(State currentState, Event event, State newState, Consumer<Turnstile> action) {
    this.currentState = currentState;
    this.event = event;
    this.newState = newState;
    this.action = action;
  }
}
