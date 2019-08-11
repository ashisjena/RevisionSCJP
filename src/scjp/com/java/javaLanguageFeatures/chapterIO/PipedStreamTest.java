package scjp.com.java.javaLanguageFeatures.chapterIO;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamTest {
  public static void main(String[] args) throws IOException {
    PipedInputStream pis = new PipedInputStream(1); // Only two bytes can be written by the output stream and will wait for the input stream to consume those.
    PipedOutputStream pos = new PipedOutputStream();
    pos.connect(pis);

    Runnable producer = () -> produceData(pos);
    Runnable consumer = () -> consumeData(pis);

    new Thread(producer).start();
    new Thread(consumer).start();
  }

  static void produceData(PipedOutputStream pos) {
    try {
      for (int i = 1; i <= 50; i++) {
        pos.write((byte) i);
        pos.flush();
        System.out.println("Writing: " + i);
//        Thread.sleep(500);
      }
      pos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void consumeData(PipedInputStream pis) {
    try {
      int num;
      while ((num = pis.read()) != -1) {
        System.out.println("Reading: " + num);
        Thread.sleep(500);
      }
      pis.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
