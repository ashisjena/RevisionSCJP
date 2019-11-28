package scjp.com.java.languageFundamentals.chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorEx
{
    public static void main( String[] args )
    {
        LinkedList< Integer > list = new LinkedList< Integer >();

        for ( int i = 0; i < 10; i++ )
        {
            list.add( i );
        }

        ListIterator< Integer > listIterator = list.listIterator();

        int count = 0;
        while ( listIterator.hasNext() )
        {
            if ( count++ == 5 )
                listIterator.add( 15 );
            
            System.out.println(listIterator.next());
        }
        
        System.out.println(new ArrayList(list));
    }
}
