package scjp.com.java.javaLanguageFeatures.chapterNIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathComponentsTest {
  public static void main(String[] args) throws IOException {
    Path p1 = Paths.get("D:\\django\\test.txt");
    printDetails(p1);
    System.out.println("-------------------");
    Path p2 = Paths.get("test.txt");
    printDetails(p2);

    Path p11 = Paths.get("D:\\DJANGO\\TEST.TXT"); // In Windows true, in Unix false
    Path p12 = Paths.get("D:\\django\\..\\django\\.\\test.txt"); // In Windows false, in Unix true
    System.out.println("-----------------------");
    System.out.println(p1.equals(p11)); // This doesn't check the existence of the files in the file system.
    System.out.println(p1.equals(p12));
    System.out.println(p1.compareTo(p11));
    System.out.println(p1.compareTo(p12));
    System.out.println(p1.endsWith(p2));
//    System.out.println(Files.isSameFile(p1, p12)); // If this doesn't find the file in the file system, it will throw exception.

    Path newP12 = p12.normalize();
    System.out.println(p12 + " normalized to " + newP12);
    System.out.println(p1.equals(newP12));

    Path p111 = Paths.get("C:\\poems");
    Path p211 = Paths.get("luci1.txt");
    System.out.println(p111.resolve(p211));
    Path p311 = Paths.get("C:\\test.txt");
    System.out.println(p111.resolve(p311));
    Path p411 = Paths.get("");
    System.out.println(p111.resolve(p411));
    Path p511 = Paths.get("poems\\Luci");
    Path p611 = Paths.get("luci4.txt");
    System.out.println(p511.resolve(p611));

    /*System.out.println(p2.relativize(p1));
    System.out.println(p1.relativize(p2));*/
  }

  private static void printDetails(Path p) {
    System.out.println("Details for path: " + p);
    int count = p.getNameCount();
    System.out.println("Name count: " + count);
    for (int i = 0; i < count; i++) {
      Path name = p.getName(i);
      System.out.println("Name at index " + i + " is " + name);
    }
    Path parent = p.getParent();
    Path root = p.getRoot();
    Path fileName = p.getFileName();
    System.out.println("Parent: " + parent + ", Root: " + root + ", File Name: " + fileName);
    System.out.println("Absolute Path: " + p.isAbsolute());
  }
}
