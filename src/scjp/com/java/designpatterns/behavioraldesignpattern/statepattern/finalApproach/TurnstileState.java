package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.finalApproach;

public interface TurnstileState {
  void coinEvent(TurnstileFSM turnstile);

  void passEvent(TurnstileFSM turnstile);
}
