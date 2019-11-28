package scjp.com.java.languageFundamentals.chapter6;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.PushbackReader;

public class PushbackInputStreamExample
{
    public static void main( String[] args ) throws IOException
    {
        String str = "a = a++ + b";
        PushbackInputStream pbis = new PushbackInputStream( new ByteArrayInputStream( str.getBytes() ) );
        int ch;
        while ( ( ch = pbis.read() ) != -1 )
        {
            if ( ch == '+' )
            {
                if ( ( ch = pbis.read() ) == '+' )
                    System.out.print( " plus plus" );
                else
                {
                    pbis.unread( ch ); // Pushing back the character as the next char is not '+', so it can be read on the next iteration.
                    System.out.print( "+" );
                }
            }
            else
                System.out.print( (char)ch );
        }

        String txt = "abcdefghijklmnopqrst";
        PushbackReader reader = new PushbackReader( new InputStreamReader( new ByteArrayInputStream( txt.getBytes() ) ), 4);
        System.out.println();
        boolean flag = false;
        while((ch = reader.read()) != -1)
        {
            if(ch == 'k' && !flag)
            {
                flag = true;
                reader.unread( ch ); 
            }
            else
                System.out.print( (char)ch );
        }
        reader.close();
        
        flag = false;
        reader = new PushbackReader( new InputStreamReader( new ByteArrayInputStream( txt.getBytes() ) ), 4);  // Initializing again as stream can't be revisited
        while((ch = reader.read()) != -1)
        {
            if(ch == 'k' && !flag)
            {
                flag = true;
                //reader.unread( "hijk".toCharArray() );
                reader.unread( "ghijk".toCharArray() );  // Will get java.io.IOException: Pushback buffer overflow
            }
            else
                System.out.print( (char)ch );
        }
        reader.close();
    }
}