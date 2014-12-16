package scjp.com.java.designpatterns.creationaldesignpattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonReadResolve implements Serializable
{
    private static final long serialVersionUID = 8277196341683975833L;
    public static final SingletonReadResolve INSTANCE = new SingletonReadResolve();
    
    private SingletonReadResolve()
    {
        if(INSTANCE != null)
            throw new RuntimeException( "Singleton object is already intitialized" );
    }
    
    private Object readResolve() throws ObjectStreamException
    {
        return INSTANCE;
    }
}
