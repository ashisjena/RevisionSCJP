package scjp.com.java.javaLanguageFeatures.chapterIO;

import java.io.File;
import java.io.IOException;

public class FilePath {
  public static void main(String[] args) throws IOException {
    String workingDir = System.getProperty("user.dir");
    System.out.println("Working Directory: " + workingDir);

    String filePath = "." + File.separator + "aaa.txt";

    File f = new File(filePath);
    System.out.println(f.exists());
    System.out.println(f.getName());
    System.out.println(f.getAbsolutePath());
    System.out.println(f.getCanonicalPath());

    File tempDir = new File("D:\\temp");
    tempDir.mkdirs();
    File tempFile = File.createTempFile("kkk", ".txt", tempDir);
    tempDir.deleteOnExit(); // Order matters here. Last registered delete hook will execute first. So the file will be deleted first and then the directory
    tempFile.deleteOnExit();
  }
}
