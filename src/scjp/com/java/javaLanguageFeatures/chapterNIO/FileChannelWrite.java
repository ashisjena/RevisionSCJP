package scjp.com.java.javaLanguageFeatures.chapterNIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWrite {
  public static void main(String[] args) {
    File outputFile = new File("ram.txt");
    try (FileChannel fileChannel = new FileOutputStream(outputFile).getChannel()) {
      String text = "This is a good place" + System.lineSeparator() + "This is the place of lord ram" + System.lineSeparator() + "Ha ha ha";
      byte[] byteData = text.getBytes("UTF-8");
      ByteBuffer buffer = ByteBuffer.wrap(byteData);
      fileChannel.write(buffer);
      buffer.flip();
      System.out.println("Data has been written to " + outputFile.getAbsolutePath());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
