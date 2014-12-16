package scjp.com.java.chapter6;

import java.util.Arrays;

public class StringSplitTest
{
    public static void main( String[] args )
    {
        String str = "asdf asdf ds   asd sd ";

        String[] strs = str.split( " " );
//        String[] strs = str.split( "\\s+" );
        System.out.println(strs);
        System.out.println( Arrays.toString( strs ) );
    }
}
