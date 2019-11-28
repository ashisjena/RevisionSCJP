package scjp.com.java.languageFundamentals.chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapContractImplementation
{
    public static void main( String[] args )
    {
        Map< ComparableClass, Object > hashMap = new HashMap< ComparableClass, Object >();
        hashMap.put( new ComparableClass( 4 ), "Rama" );
        hashMap.put( new ComparableClass( 5 ), "Rita" );

        if ( hashMap.containsKey( new ComparableClass( 4 ) ) )
            System.out.println( "True" );
        else
            System.out.println( "False" );
        
        Collections.sort( new ArrayList(hashMap.keySet()) );
    }
}

class ComparableClass implements Comparable< ComparableClass >
{
    private Integer id;

    ComparableClass( int id )
    {
        this.id = id;
    }

    /*@Override
    public int hashCode()
    {
        return 1;
    }

    @Override
    public boolean equals( Object o )
    {
        return ( (ComparableClass)o ).id.equals( this.id );
    }*/

    @Override
    public int compareTo( ComparableClass o )
    {
        return this.id.compareTo( o.id );
    }
}