/*
 * ReverseFileReader.java
 *
 * Created on October 12, 2006, 11:18 AM
 */
 
package scjp.com.java.chapter6.oldExamples;
 
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Reads a text file backwards, relative to the left of the file pointer
 * instead of to the right of it.
 *
 * Lines are read from bottom to top. Character buffers are read right to left.
 * The returned text reads correctly from left-to-right (i.e. it is
 * not reversed) but the file pointer keeps on moving up the file instead of
 * down it.
 *
 * @author Gili Tzabari
 */
public class ReverseFileReader extends Reader
{
  /**
   * Maps a line number to the file offset of the beginning of that line.
   */
  private Map<Integer, Long> lineToPosition;
  /**
   * The file to read from.
   */
  private final RandomAccessFile file;
  /**
   * The current line number.
   */
  private int line;
  
  
  /**
   * Creates a new ReverseFileReader.
   */
  public ReverseFileReader(File file) throws IOException
  {
    this.file = new RandomAccessFile(file, "r", 250);
  }
  
  /**
   * Initializes lineToPosition.
   */
  private void init() throws IOException
  {
    lineToPosition = new HashMap<Integer, Long>();
    
    lineToPosition.put(0, 0L);
    line = 0;
    while (true)
    {
      String text = file.readLine();
      if (text==null)
        break;
      ++line;
      lineToPosition.put(line, file.getFilePointer());
    }
    lineToPosition.remove(line);
    --line;
  }
  
  /**
   * Reads a line of text.  A line is considered to be terminated by any one
   * of a line feed ('\n'), a carriage return ('\r'), or a carriage return
   * followed immediately by a linefeed.
   *
   * @return     A String containing the contents of the line, not including
   *             any line-termination characters, or null if the end of the
   *             stream has been reached
   *
   * @exception  IOException  If an I/O error occurs
   */
  public String readLine() throws IOException
  {
    if (lineToPosition==null)
      init();
    Long index = lineToPosition.get(line);
    if (index==null)
      return null;
    else
    {
      file.seek(index);
      --line;
      assert(line>=-1): line;
      return file.readLine();
    }
  }
  
  public int read(char[] cbuf, int off, int len) throws IOException
  {
    final long pos = file.getFilePointer();
    if (len > pos)
      len = (int) pos;
    file.seek(pos - len);
    int result = file.read(cbuf, off, len);
    file.seek(pos - len);
    return result;
  }
  
  public void close() throws IOException
  {
    file.close();
  }
}
 