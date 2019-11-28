package scjp.com.java.languageFundamentals.chapter6.oldExamples;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableExample {
  private final static String OUTPUT_FILE = "externalizable_file";

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    ExternalizablePair pair = new ExternalizablePair("Hello", "World");
    System.out.println("Initially: " + pair.toString());

    // Serialize the pair to a file.
    FileOutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
    pair.writeExternal(objectOutputStream);

    // Read the contents from the file and create a new instance.
    ExternalizablePair copyOfPair = new ExternalizablePair();
    FileInputStream inputStream = new FileInputStream(OUTPUT_FILE);
    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
    copyOfPair.readExternal(objectInputStream);

    System.out.println("After de-serialization: " + copyOfPair.toString());
  }
}

class ExternalizablePair implements Externalizable {
  private String key = null;
  private String value = null;

  public ExternalizablePair() {}

  public ExternalizablePair(String key, String value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeUTF(key);
    out.writeUTF(value);
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    this.key = in.readUTF();
    this.value = in.readUTF();
  }
  
  @Override
  public String toString() {
    return "Pair ";
  }
}