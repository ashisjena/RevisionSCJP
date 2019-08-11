package scjp.com.java.javaLanguageFeatures.chapterNIO2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemTest {
  public static void main(String[] args) {
    FileSystem fs = FileSystems.getDefault();
    System.out.println("Read-only file system: " + fs.isReadOnly());
    System.out.println("File name separator: " + fs.getSeparator());
    System.out.println(System.lineSeparator() + "Available file-stores are: ");
    for (FileStore store : fs.getFileStores()) {
      printDetails(store);
    }
    System.out.println(System.lineSeparator() + "Available root directories are");
    for (Path root : fs.getRootDirectories()) {
      System.out.println(root);
    }
  }

  private static void printDetails(FileStore store) {
    try {
      String desc = store.toString();
      String type = store.type();
      long totalSpace = store.getTotalSpace();
      long unallocatedSpace = store.getUnallocatedSpace();
      long availableSpace = store.getUsableSpace();
      System.out.println(desc + ", Type: " + type + ", Total: " + totalSpace + ", Unallocated: " + unallocatedSpace + ", Available: " + availableSpace);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
