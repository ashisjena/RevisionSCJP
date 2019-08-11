package scjp.com.java.javaLanguageFeatures.chapterNIO;

import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

public class BufferInfo {
  public static void main(String[] args) {
//    ByteBuffer bb = ByteBuffer.allocate(8);
    ByteBuffer bb = ByteBuffer.allocateDirect(8); // This allocate directly in the RAM(outside of the JVM logical memory). This is faster but creation cost is more. So to be avoided when short lived.
    System.out.println("Capacity: " + bb.capacity());
    System.out.println("Limit: " + bb.limit());
    System.out.println("Position: " + bb.position());

    ByteBuffer bb2 = ByteBuffer.allocate(8);
    System.out.println(bb2.isReadOnly());
    ByteBuffer readOnlyBuffer = bb2.asReadOnlyBuffer(); // If the contents of the ReadOnlyBuffer is changed, it will throw ReadOnlyBufferException
    System.out.println(readOnlyBuffer.isReadOnly());

    try {
      bb.reset(); // Mark is not set. So this line will throw exception.
    } catch (InvalidMarkException e) {
      System.out.println("Mark is not set!");
    }
  }
}
