package scjp.com.java.designpatterns.behavioraldesignpattern.observerpattern.usingutilpackage;

import java.util.Observable;

public class MyTopic extends Observable
{
    String message;

    public void postMessage( String message )
    {
        this.message = message;
    }
    
    public void setChanged()
    {
        super.setChanged();
    }
}