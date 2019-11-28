package scjp.com.java.languageFundamentals.chapter6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Date;

public class ITCUsingPipesObjectTransfer
{
    public static void main( String[] args ) throws IOException, InterruptedException, ClassNotFoundException
    {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect( pos );

        ReadObjectThread rth = new ReadObjectThread( pis );
        WriteObjectThread wth = new WriteObjectThread( pos );

        Thread readThread = new Thread( rth );
        Thread writeThread = new Thread( wth );

        readThread.start();

        //Thread.sleep( 100 );

        writeThread.start();
        
        /*ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( bos );
        
        oos.writeObject( new Employee( 100, "Rama" ) );
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream( new ByteArrayInputStream( bos.toByteArray() ) );
        Employee emp = (Employee)ois.readObject();
        System.out.println(emp.getEmpName() + "\n");
        ois.readObject();  // EOFException as nothing is there to read.*/
    }
}

class ReadObjectThread implements Runnable
{
    private PipedInputStream pis;

    public ReadObjectThread( PipedInputStream pis )
    {
        this.pis = pis;
    }

    @Override public void run()
    {
        Employee emp;
        ObjectInputStream ois;
        try
        {
            System.out.println( "ReadObjectThread : " + new Date().getTime() );
            ois = new ObjectInputStream( this.pis );
            
            /*
             * As a InputStream always needs one source as a input, eg. Sytem.in console or byteArray or File etc.
             * In this case it's the pipe....
             * So unless an until the ObjectOutputStream gets initialized, the thread will wait @ ObjectInputSteram creation. 
             */
            
            
            System.out.println( "ReadObjectThread : " + new Date().getTime() );
            emp = (Employee)ois.readObject();
            
            /*
             * Until n unless the object is written n flushed on the ObjectOutputSteam, the read thread will wait for the resource.
             */
            
            System.out.println( "ReadObjectThread : " + new Date().getTime() );
            System.out.println( "Employee : " + emp.getEmpName() );
            System.out.println( "HI" + ois.readObject() );  
            /*
             * The thread will wait for the resource write on ObjectOutputStream holding the PipeOutputStream upon invocation of readObject() method.
             * Here "java.io.EOFException" will be generated as the ObjectOutputStream will get closed without writing the object.
             */
            
            ois.close();
            this.pis.close();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        catch ( ClassNotFoundException e )
        {
            e.printStackTrace();
        }
    }
}

class WriteObjectThread implements Runnable
{
    private PipedOutputStream pos;

    public WriteObjectThread( PipedOutputStream pos )
    {
        this.pos = pos;
    }

    @Override public void run()
    {
        try
        {
            Employee emp = new Employee( 100, "Rango" );
            System.out.println( "WriteObjectThread : " + new Date().getTime() );
            try
            {
                Thread.sleep( 500 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
            ObjectOutputStream oos = new ObjectOutputStream( this.pos );
            try
            {
                Thread.sleep( 500 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
            System.out.println( "WriteObjectThread : " + new Date().getTime() );

            oos.writeObject( emp );
            oos.flush();
            System.out.println( "WriteObjectThread : " + new Date().getTime() );
            
            try
            {
                Thread.sleep( 10000 );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
            
            oos.close();

            this.pos.close();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
