package scjp.com.java.chapter6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileExample2
{
    public static void main( String[] args ) throws IOException
    {
        File aFile = new File("test.txt");
        FileInputStream inFile = null;

        inFile = new FileInputStream(aFile);

        FileChannel inChannel = inFile.getChannel();
        inChannel.toString();
        ByteBuffer buf = ByteBuffer.allocate(10);

        while (inChannel.read(buf) != -1) {
          System.out.println("String read: " + ((ByteBuffer) (buf.flip())).asCharBuffer().get(0));
          buf.clear();
        }
        inFile.close();
    }
}