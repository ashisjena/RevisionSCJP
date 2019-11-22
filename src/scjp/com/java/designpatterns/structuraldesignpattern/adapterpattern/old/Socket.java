package scjp.com.java.designpatterns.structuraldesignpattern.adapterpattern.old;

public class Socket
{
    protected Volt getVolt()
    {
        return new Volt( 240 );
    }
}