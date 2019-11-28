package scjp.com.java.languageFundamentals.chapter6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class SplitAFileIntoTwo {

  public static void main(String[] args) throws IOException {
    FileChannel c1 = new FileInputStream("big.txt").getChannel();
    FileChannel c2 = new FileOutputStream("split.txt", true).getChannel();
    
    System.out.println(c2.size());
    c2.transferFrom(c1, 0, c1.size()-5);
    
    c1.close();
    c2.close();
  }
}
