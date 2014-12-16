package scjp.com.java.chapter6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileExample1
{
    public static void main( String[] args ) throws IOException
    {
        File file = new File( "abc.txt" );
        if ( file.exists() )
            file.createNewFile();
        else
            System.out.println( file.getAbsolutePath() + ": File exists..." );
        
        RandomAccessFile randomAccessFile = new RandomAccessFile( file, "rw" );
        RandomAccessFile rtemp = new RandomAccessFile(new File(file.getName() + "~"), "rw");
        long fileSize = randomAccessFile.length();
        
        FileChannel sourceChannel = randomAccessFile.getChannel();
        FileChannel targetChannel = rtemp.getChannel();
        
        Long offSet = null;  // or filePointer
        Integer lineNo = 0;
        for ( String line = randomAccessFile.readLine(); line != null; line = randomAccessFile.readLine(), lineNo++ )
            if ( line.startsWith( "import" ) )
                break;
            else
                offSet = randomAccessFile.getFilePointer();
        
        System.out.println( offSet );
        
        sourceChannel.transferTo(offSet, (fileSize - offSet), targetChannel);
        sourceChannel.truncate(offSet);
        randomAccessFile.seek(offSet);
        randomAccessFile.writeBytes("ashis\n");
        long newOffset = randomAccessFile.getFilePointer();
        targetChannel.position(0L);
        sourceChannel.transferFrom(targetChannel, newOffset, (fileSize - offSet));
         
        sourceChannel.close();
        targetChannel.close();
        randomAccessFile.close();
        rtemp.close();
        
        /*BufferedWriter bfw = new BufferedWriter( new FileWriter( file, true ) );
         bfw.append( "ashis jena" );
         bfw.close();*/
    }
}