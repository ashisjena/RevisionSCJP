package scjp.com.java.javaLanguageFeatures.chapterNIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathTest3 {
  public static void main(String[] args) throws IOException {
    String dirPrefix = "KDir";
    Path tDir = Files.createTempDirectory(dirPrefix);
    System.out.println("Temp directory: " + tDir);
    String fPrefix = "KF__";
    String fSuffix = ".txt";
    Path tFile = Files.createTempFile(fPrefix, fSuffix);
    System.out.println("Temp file1: " + tFile);
//    Temp directory: C:\Users\ashis.j\AppData\Local\Temp\KDir6304657416858777101
//    Temp file1: C:\Users\ashis.j\AppData\Local\Temp\KF__6092739782702463307.txt
    tFile.toFile().deleteOnExit();
    tDir.toFile().deleteOnExit();
  }
}
