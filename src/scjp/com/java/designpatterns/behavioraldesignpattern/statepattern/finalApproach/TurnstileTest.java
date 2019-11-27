package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.finalApproach;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnstileTest extends TurnstileFSM {
  @Override
  protected void alarm() {
    this.actions += "A";
  }

  @Override
  protected void lock() {
    this.actions += "L";
  }

  @Override
  protected void unlock() {
    this.actions += "U";
  }

  @Override
  protected void thankyou() {
    this.actions += "T";
  }

  private TurnstileFSM fsm;
  private String actions;

  @Before
  public void setup() {
    fsm = this;
    fsm.setState(OneCoinTurnstileState.LOCKED); // establish the logic.
    actions = "";
  }

  private void assertActions(String expected) {
    assertEquals(expected, actions);
  }

  @Test
  public void normalOperation() {
    coinEvent();
    assertActions("U");
    passEvent();
    assertActions("UL");
  }

  @Test
  public void tressPass() {
    passEvent();
    assertActions("A");
    coinEvent();
    assertActions("AU");
  }

  @Test
  public void manyCoinsThenPass() {
    for (int i = 0; i < 5; i++) {
      coinEvent();
    }
    passEvent();
    assertActions("UTTTTL");
  }
}
