package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.finalApproach;

public abstract class TurnstileFSM {
  private TurnstileState state;

  protected void setState(TurnstileState state) {
    this.state = state;
  }

  protected abstract void alarm();

  protected abstract void lock();

  protected abstract void unlock();

  protected abstract void thankyou();

  public void coinEvent() {
    state.coinEvent(this);
  }

  public void passEvent() {
    state.passEvent(this);
  }
}
