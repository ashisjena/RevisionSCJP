package scjp.com.java.javaLanguageFeatures.chapterNIO2;

import java.io.IOException;
import java.nio.file.*;

public class PathTest2 {
  public static void main(String[] args) {
    Path p1 = Paths.get("test.txt");
    try {
//      Files.delete(p1);
      Files.deleteIfExists(p1);
      Files.createFile(p1);
      System.out.format("File created: %s%n", p1.toRealPath());
    } catch (FileAlreadyExistsException e) {
      System.out.format("File %s already exists.%n", p1.normalize());
    } catch (NoSuchFileException e) {
      System.out.format("Directory %s does not exits.%n", p1.normalize().getParent());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
