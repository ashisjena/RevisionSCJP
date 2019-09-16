package scjp.com.java.javaLanguageFeatures.chapterIO;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReadAndWrite {
  public static void main(String[] args) {
    try (FileInputStream fis = new FileInputStream("./test.txt")) {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      byte[] buffer = new byte[10];
      int data = fis.read(buffer);
      while (data != -1) {
        baos.write(buffer);
        System.out.println(new String(buffer));
        data = fis.read(buffer);
      }
      // Read all bytes from the input stream and write to the output stream.
      // The below method is introduced in JDK9.
      // fis.transferTo(baos); // returns a long that is the number of bytes transferred.
      System.out.println(System.lineSeparator() + baos.toString());
      baos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

