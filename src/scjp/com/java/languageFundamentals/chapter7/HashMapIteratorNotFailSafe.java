package scjp.com.java.languageFundamentals.chapter7;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;

public class HashMapIteratorNotFailSafe
{

    public static void main( String[] args )
    {
        /*HashMap< Integer, String > map = new HashMap< Integer, String >();
        map.put( 1, "rama" );
        map.put( 2, "sita" );
        map.put( 3, "diga" );

        Iterator< Entry< Integer, String > > iterator = map.entrySet().iterator();

        while ( iterator.hasNext() )
        {
            Entry< Integer, String > entry = iterator.next();
            if ( entry.getKey() == 2 )
                map.put( 4, "rabi" );
        }
        
        for(Entry<Integer, String> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }*/
        
        Hashtable<Integer, String> hashtable = new Hashtable< Integer, String >();
        
        hashtable.put( 1, "rama" );
        hashtable.put( 2, "sita" );
        hashtable.put( 3, "diga" );

        /*Iterator< Entry< Integer, String > > iterator2 = hashtable.entrySet().iterator();

        while ( iterator2.hasNext() )
        {
            Entry< Integer, String > entry = iterator2.next();
            if ( entry.getKey() == 2 )
                hashtable.put( 4, "rabi" );
        }*/
        Enumeration< Integer > enumerator = hashtable.keys();
        while ( enumerator.hasMoreElements() )
        {
            Integer key = enumerator.nextElement();
            if ( key == 2 )
                hashtable.put( 4, "rabi" );
        }
        
        for(Entry<Integer, String> entry : hashtable.entrySet())
        {
            if ( entry.getKey() == 2 )
                hashtable.put( 4, "rabi" );
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}
