package scjp.com.java.designpatterns.structuraldesignpattern.adapterpattern;

public class AdapterPatternTestMain
{

    public static void main( String[] args )
    {
        testClassAdapter();
        testObjectAdapter();
    }

    private static void testObjectAdapter()
    {
        SocketAdapterInterface sockAdapter = new SocketAdapterUsingObjectAdapterImpl();
        Volt v3 = getVolt( sockAdapter, 3 );
        Volt v12 = getVolt( sockAdapter, 12 );
        Volt v240 = getVolt( sockAdapter, 120 );
        System.out.println( "v3 volts using Object Adapter = " + v3.getVolts() );
        System.out.println( "v12 volts using Object Adapter = " + v12.getVolts() );
        System.out.println( "v120 volts using Object Adapter = " + v240.getVolts() );
    }

    private static void testClassAdapter()
    {
        SocketAdapterInterface sockAdapter = new SocketAdapterUsingClassAdapterImpl();
        Volt v3 = getVolt( sockAdapter, 3 );
        Volt v12 = getVolt( sockAdapter, 12 );
        Volt v240 = getVolt( sockAdapter, 120 );
        System.out.println( "v3 volts using Class Adapter = " + v3.getVolts() );
        System.out.println( "v12 volts using Class Adapter = " + v12.getVolts() );
        System.out.println( "v120 volts using Class Adapter = " + v240.getVolts() );
    }

    private static Volt getVolt( SocketAdapterInterface sockAdapter, int i )
    {
        switch (i)
        {
        case 3:
            return sockAdapter.get3Volt();
        case 12:
            return sockAdapter.get12Volt();
        case 240:
            return sockAdapter.get240Volt();
        default:
            return sockAdapter.get240Volt();
        }
    }
}