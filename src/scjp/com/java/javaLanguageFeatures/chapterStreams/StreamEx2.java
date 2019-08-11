package scjp.com.java.javaLanguageFeatures.chapterStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamEx2 {
  public static void main(String[] args) {
    readFileContents("abc.txt"); // Read file content
    listFileTree(); // print file tree of current working directory
  }

  private static void listFileTree() {
    Path dir = Paths.get("");
    System.out.printf("%nThe file tree for %s%n", dir.toAbsolutePath());
    try (Stream<Path> fileTree = Files.walk(dir)) {
      fileTree.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void readFileContents(String filePath) {
    Path path = Paths.get(filePath);
    if (!Files.exists(path)) {
      System.out.println("The file " + path.toAbsolutePath() + " doesn't exist");
      return;
    }

    try (Stream<String> lineStream = Files.lines(path)) {
      lineStream.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
