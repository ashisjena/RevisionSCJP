package scjp.com.java.languageFundamentals.chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FailSafeIterator
{
    public static void main( String[] args )
    {
        List< Integer > list = new ArrayList< Integer >();//new CopyOnWriteArrayList< Integer >();
        list.add( 4 );
        list.add( 5 );
        list.add( 7 );
        list.add( 3 );
        list.add( 9 );

        /*for ( int i : list )
        {
            if ( i == 5 )
                list.add( 8 );
            if ( i == 7 )
                list.remove( 3 );
            System.out.println( i );
        }*/
        
        ListIterator<Integer> iterator = list.listIterator();//iterator();
        while(iterator.hasNext())
        {
            int i = iterator.next();
            if(i == 7)
            {
                iterator.remove();
                iterator.add( 10 );
            }
            System.out.println(i);
        }
        System.out.println( list );
    }
}