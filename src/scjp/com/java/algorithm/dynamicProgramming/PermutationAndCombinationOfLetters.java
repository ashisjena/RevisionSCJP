package scjp.com.java.algorithm.dynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;

public class PermutationAndCombinationOfLetters
{
    public static void main( String[] args )
    {
        String arr[] = { "a", "b", "c", "d" };

        LinkedList< String > linkedList = new LinkedList< String >( Arrays.asList( arr ) );
        for ( int x = 0; x < linkedList.size(); x++ )
        {
            System.out.println( linkedList );
//            String str = linkedList.pollFirst();
            linkedList.addLast( linkedList.pollFirst() );
        }
    }
}