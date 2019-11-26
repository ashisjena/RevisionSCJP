package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.finalApproach;

public interface TurnstileState {
  void coin(TurnstileFSM turnstile);

  void pass(TurnstileFSM turnstile);
}
