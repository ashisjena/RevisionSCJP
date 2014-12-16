package scjp.com.java.chapter6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class InsertLineBetweenFile
{
    public static void main( String[] args ) throws IOException
    {
        RandomAccessFile rFile = new RandomAccessFile( "abc.txt", "rw" );
        File tempFile = new File( "temp~file" ); // Need temp file ref as to delete at the end. as the RandomAcessFile will create a physical file if not present
        RandomAccessFile rTempFile = new RandomAccessFile( tempFile, "rw" );
        FileChannel channelSource = rFile.getChannel();
        FileChannel tempChannelSource = rTempFile.getChannel();

        long fileSize = rFile.length();
        Long offSet = null;
        String str;
        while ( ( str = rFile.readLine() ) != null )
            if ( str.startsWith( "import" ) )
                break;
            else
                offSet = rFile.getFilePointer(); // As we are reading a line so offSet points to the end of the Line. Thats why taking the offSet of the previous line, which is offSet of the staring point of next line.

        channelSource.transferTo( offSet, fileSize - offSet, tempChannelSource );
        channelSource.truncate( offSet ); // Delete the remaining, starting from the offSet from the file, it's instant. i.e if the programs stops abruptly then data is lost.
        //rFile.seek( offSet );
        rFile.writeBytes( "/*\n * This a proprietary Class\n */\n\n" );

        long newOffSet = rFile.getFilePointer();

        //tempChannelSource.position( 0L ); //  Setting the channel source position as 0, else while transfer it will not get anything as currently the position is End Of the File.
        // or
        rTempFile.seek( 0L );

        //channelSource.transferFrom( tempChannelSource, newOffSet, tempChannelSource.size() );
        // or
        while ( ( str = rTempFile.readLine() ) != null )
            rFile.writeBytes( str + "\n" );

        channelSource.close();
        tempChannelSource.close();
        rFile.close();
        rTempFile.close();
        tempFile.delete(); // delete the temp file created by RandomAcessFile.
    }
}