package scjp.com.java.chapter7;

public class TestVectorClass
{
    public static void main( String[] args )
    {
        Vector< String > myVector = new Vector< String >();
        myVector.ensureCapacity( 12 );
        for ( int i = 1; i <= 15; i++ )
            myVector.add( "Rama-" + i );

        System.out.println( myVector.get( 12 ) );
        System.out.println( myVector.size() );
        System.out.println( myVector.set( 10, "Bhima" ) );
        System.out.println( myVector );
        myVector.add( 61, "Sita" );
    }
}