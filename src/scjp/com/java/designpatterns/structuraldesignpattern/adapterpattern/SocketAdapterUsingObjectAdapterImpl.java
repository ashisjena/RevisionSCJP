package scjp.com.java.designpatterns.structuraldesignpattern.adapterpattern;

public class SocketAdapterUsingObjectAdapterImpl implements SocketAdapterInterface
{

    //Using Composition for adapter pattern
    private Socket sock = new Socket();

    private Volt convertVolt( Volt v, int i )
    {
        return new Volt( v.getVolts() / i );
    }
    
    @Override
    public Volt get240Volt()
    {
        return sock.getVolt();
    }

    @Override
    public Volt get12Volt()
    {
        Volt v = sock.getVolt();
        return convertVolt( v, 20 );
    }

    @Override
    public Volt get3Volt()
    {
        Volt v = sock.getVolt();
        return convertVolt( v, 80 );
    }

}