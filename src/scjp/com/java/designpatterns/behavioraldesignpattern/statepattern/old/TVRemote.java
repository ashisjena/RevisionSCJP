package scjp.com.java.designpatterns.behavioraldesignpattern.statepattern.old;

public class TVRemote
{
    public static void main( String[] args )
    {
        TVContext context = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();

        context.setState( tvStartState );
        context.doAction();

        context.setState( tvStopState );
        context.doAction();

    }
}