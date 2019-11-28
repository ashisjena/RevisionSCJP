package scjp.com.java.languageFundamentals.chapter6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RegularExpressionEx2
{
    public static void main( String[] args ) throws IOException
    {
        File source = new File("Movies.txt");
        File dest = new File("MoviesFormatted.txt");
        dest.createNewFile();
        BufferedReader br = new BufferedReader( new FileReader( source ) );
        BufferedWriter bw = new BufferedWriter( new FileWriter( dest ) );
        for(String str = br.readLine(); str != null ; str = br.readLine())
        {
            String formatted = str.replaceAll( "[.]", " " );
            bw.write( formatted + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
