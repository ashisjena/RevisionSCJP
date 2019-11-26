package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.tableApproach;

public class Turnstile {
  private final Transition[] transitions;
  private State state;

  Turnstile() {
    this.state = State.LOCKED;
    this.transitions = new Transition[]{
            new Transition(State.LOCKED, Event.COIN, State.UNLOCKED, Turnstile::unlock),
            new Transition(State.LOCKED, Event.PASS, State.LOCKED, Turnstile::alarm),
            new Transition(State.UNLOCKED, Event.COIN, State.UNLOCKED, Turnstile::thankyou),
            new Transition(State.UNLOCKED, Event.PASS, State.LOCKED, Turnstile::lock)
    };
  }

  private void unlock() {
    System.out.println("Unlocked the Turnstile");
  }

  private void lock() {
    System.out.println("Locked the Turnstile");
  }

  private void alarm() {
    System.out.println("Tress passing Alarm");
  }

  private void thankyou() {
    System.out.println("Thank you for your generosity");
  }

  public void handleEvent(Event event) {
    // This table iteration can be optimized through a HashTable Approach.
    for (Transition t : transitions) {
      if (t.currentState == state && t.event == event) {
        state = t.newState;
        t.action.accept(this);
        break;
      }
    }
  }
}
