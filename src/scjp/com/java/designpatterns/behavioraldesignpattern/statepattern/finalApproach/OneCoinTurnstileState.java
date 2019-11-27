package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.finalApproach;

public enum OneCoinTurnstileState implements TurnstileState {
  LOCKED {
    @Override
    public void coinEvent(TurnstileFSM fsm) {
      fsm.setState(UNLOCKED);
      fsm.unlock();
    }

    @Override
    public void passEvent(TurnstileFSM fsm) {
      fsm.alarm();
    }
  },
  UNLOCKED {
    @Override
    public void passEvent(TurnstileFSM fsm) {
      fsm.setState(LOCKED);
      fsm.lock();
    }

    @Override
    public void coinEvent(TurnstileFSM fsm) {
      fsm.thankyou();
    }
  }
}
