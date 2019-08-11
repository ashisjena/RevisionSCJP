package scjp.com.java.javaLanguageFeatures.chapterNIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

public class CopyFile {
  public static void main(String[] args) throws IOException {
    Path source = Paths.get("test.txt");
    Path target = Paths.get("test1.txt");
    Path p = Files.copy(source, target, REPLACE_EXISTING, COPY_ATTRIBUTES);
//    Path p1 = Files.move(source, target, ATOMIC_MOVE);
    System.out.println(source + " has been copied to " + p);
    String contentType = Files.probeContentType(source);
    System.out.format("Content type of %s is %s%n", p, contentType);
  }
}
