package scjp.com.java.designpatterns.behavioraldesignpattern.chainofresponsibilitypattern;

public interface DispenseChain
{
    void setNextChain( DispenseChain nextChain );

    void dispense( Currency cur );
}