package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern;

public class TVStopState implements State
{
    @Override
    public void doAction()
    {
        System.out.println( "TV is turned OFF" );
    }
}