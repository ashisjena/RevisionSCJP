package scjp.com.java.designpatterns.structuraldesignpattern.adapterpattern;

public class SocketAdapterUsingClassAdapterImpl extends Socket implements SocketAdapterInterface
{
    private Volt convertVolt( Volt v, int i )
    {
        return new Volt( v.getVolts() / i );
    }
    
    @Override
    public Volt get240Volt()
    {
        return getVolt();
    }

    @Override
    public Volt get12Volt()
    {
        Volt v = getVolt();
        return convertVolt( v, 20 );
    }

    @Override
    public Volt get3Volt()
    {
        Volt v = getVolt();
        return convertVolt( v, 80 );
    }


}