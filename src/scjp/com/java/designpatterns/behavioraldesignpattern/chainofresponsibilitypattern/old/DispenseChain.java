package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern.old;

public interface DispenseChain
{
    void setNextChain( DispenseChain nextChain );

    void dispense( Currency cur );
}