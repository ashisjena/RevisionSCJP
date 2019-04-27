package scjp.com.java.chapter6;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class PrintStreamExample
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        PrintStream ps = new PrintStream(System.out);// new FileOutputStream(new File("test1.txt")));// new PrintStream(new File("abc.txt"));
        ps.printf( Locale.UK, "Text + data: %1f$", 6F );
        ps.println();
        
        Calendar c = new GregorianCalendar(1995, 5, 23);
        /*String s = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
        ps.println( s );*/
        
        ps.printf( "Duke's Birthday: %1$tm %1$te,%1$tY", c );  //More about formatter look Class "java.util.Formatter"
        ps.println();
        ps.printf( "Duke's Birthday: %1$td %1$tm,%1$tY", c );
        
        ps.close();
    }
}
