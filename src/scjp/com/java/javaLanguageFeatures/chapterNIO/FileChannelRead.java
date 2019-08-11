package scjp.com.java.javaLanguageFeatures.chapterNIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelRead {
  public static void main(String[] args) {
    File inputFile = new File("abc.txt");
    try (FileChannel fileChannel = new FileInputStream(inputFile).getChannel()) {
      ByteBuffer buffer = ByteBuffer.allocate(1024);
      while (fileChannel.read(buffer) > 0) {
        buffer.flip();
        while (buffer.hasRemaining()) {
          byte b = buffer.get();
          System.out.print((char) b);
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
