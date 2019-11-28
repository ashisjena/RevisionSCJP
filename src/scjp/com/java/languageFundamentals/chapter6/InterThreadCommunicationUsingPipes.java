package scjp.com.java.languageFundamentals.chapter6;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Date;

public class InterThreadCommunicationUsingPipes
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {
        PipedReader pr = new PipedReader();
        PipedWriter pw = new PipedWriter();
        //PipedWriter pw = new PipedWriter( pr );
        // OR
        pr.connect( pw );
        
        ReadThread rth = new ReadThread( pr );
        WriteThread wth = new WriteThread( pw );
        
        Thread readThread = new Thread(rth);
        Thread writeThread = new Thread(wth);
        
        readThread.start();
        
        Thread.sleep( 100 );
        
        writeThread.start();
    }
}

class ReadThread implements Runnable
{
    private PipedReader pr;

    public ReadThread( PipedReader pr )
    {
        this.pr = pr;
    }

    @Override public void run()
    {
        int item;
        try
        {
            while((item = this.pr.read()) != -1)
                System.out.println( "ReadThread : " + (char)item );
            
            System.out.println("ReadThread : " + new Date().getTime());
            this.pr.close();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}

class WriteThread implements Runnable
{
    private PipedWriter pw;

    public WriteThread( PipedWriter pw )
    {
        this.pw = pw;
    }

    @Override public void run()
    {
        try
        {
            this.pw.write( "Hi" );
            this.pw.append( " & Hello" );
            System.out.println("WriteThread : " + new Date().getTime());
            this.pw.flush();
            Thread.sleep( 500 );
            System.out.println("WriteThread : " + new Date().getTime());
            this.pw.write( "Bye" );
            this.pw.close();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}
