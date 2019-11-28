package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.finalApproach;

// Action
public interface Turnstile {
  void alarmAction();

  void lockAction();

  void unlockAction();

  void thankyouAction();
}
