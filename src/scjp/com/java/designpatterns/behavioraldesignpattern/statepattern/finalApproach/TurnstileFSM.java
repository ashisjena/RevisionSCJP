package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.finalApproach;

public abstract class TurnstileFSM implements Turnstile {
  private TurnstileState state;

  protected void setState(TurnstileState state) {
    this.state = state;
  }

  public abstract void alarmAction();

  public abstract void lockAction();

  public abstract void unlockAction();

  public abstract void thankyouAction();

  public void coinEvent() {
    state.coinEvent(this);
  }

  public void passEvent() {
    state.passEvent(this);
  }
}
