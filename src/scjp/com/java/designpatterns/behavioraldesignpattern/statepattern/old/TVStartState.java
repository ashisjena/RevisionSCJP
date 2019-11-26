package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.old;

public class TVStartState implements State
{
    @Override
    public void doAction()
    {
        System.out.println( "TV is turned ON" );
    }

}