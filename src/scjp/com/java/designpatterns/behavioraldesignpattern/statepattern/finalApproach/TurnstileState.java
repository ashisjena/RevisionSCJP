package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.finalApproach;

public interface TurnstileState {
  // Events
  void coinEvent(TurnstileFSM turnstile);

  void passEvent(TurnstileFSM turnstile);
}
