package scjp.com.java.designpatterns.structuraldesignpattern.adapterpattern;

public class Socket
{
    protected Volt getVolt()
    {
        return new Volt( 240 );
    }
}