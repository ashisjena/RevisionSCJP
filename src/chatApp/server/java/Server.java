package chatApp.server.java;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;

public class Server
{
    public static final int port = 2222;
    public static void main( String args[] ) throws IOException
    {
        ServerSocket echoServer = null;
        String line;
        DataInputStream is;
        PrintStream os;
        Socket clientSocket = null;
        
        /*ServerSocketChannel ssc = ServerSocketChannel.open();
        //InetAddress localhost =  Inet4Address.getLocalHost();
        ssc.socket().bind( new InetSocketAddress( port ) );
        ssc.configureBlocking( true );*/

        /*
         * Open a server socket on port 2222. Note that we can't choose a port less
         * than 1023 if we are not privileged users (root).
         */
        try
        {
            echoServer = new ServerSocket( 2222 );
        }
        catch ( IOException e )
        {
            System.out.println( e );
        }

        /*
         * Create a socket object from the ServerSocket to listen to and accept
         * connections. Open input and output streams.
         */
        System.out.println( "The server started. To stop it press <CTRL><C>." );
        try
        {
            clientSocket = echoServer.accept();
            is = new DataInputStream( clientSocket.getInputStream() );
            os = new PrintStream( clientSocket.getOutputStream() );                

            /* As long as we receive data, echo that data back to the client. */
            while ( true )
            {
                line = is.readLine();
                os.println( "From server: " + line );
            }
        }
        catch ( IOException e )
        {
            System.out.println( e );
        }
    }
}
