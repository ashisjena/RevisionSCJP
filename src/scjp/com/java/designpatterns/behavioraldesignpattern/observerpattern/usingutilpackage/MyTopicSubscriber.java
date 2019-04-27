package scjp.com.java.designpatterns.behavioraldesignpattern.observerpattern.usingutilpackage;

import java.util.Observable;
import java.util.Observer;

public class MyTopicSubscriber implements Observer
{
    private Object name;
    private Observable observable;

    public MyTopicSubscriber( Observable observable, String name )
    {
        this.name = name;
        this.observable = observable;
    }

    @Override
    public void update( Observable o, Object arg )
    {
        if ( this.observable == o )
            System.out.println( name + ", " + arg + ", " );
    }
}