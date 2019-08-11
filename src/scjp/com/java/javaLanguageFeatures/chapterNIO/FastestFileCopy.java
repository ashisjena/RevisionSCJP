package scjp.com.java.javaLanguageFeatures.chapterNIO;

import java.io.*;
import java.nio.channels.FileChannel;

public class FastestFileCopy {
  public static void main(String[] args) {
    File sourceFile = new File("ram.txt");
    File sinkFile = new File("ram2.txt");
    try {
      copy(sourceFile, sinkFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void copy(File sourceFile, File sinkFile) throws IOException {
    try (FileChannel srcChannel = new FileInputStream(sourceFile).getChannel();
         FileChannel sinkChannel = new FileOutputStream(sinkFile).getChannel()) {
      srcChannel.transferTo(0, srcChannel.size(), sinkChannel);
    }
  }
}
