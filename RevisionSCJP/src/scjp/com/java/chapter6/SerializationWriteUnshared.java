package scjp.com.java.chapter6;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationWriteUnshared {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Student student = new Student(5, "Raja", 800);
    
    ByteArrayOutputStream b1 = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(b1);
    oos.writeObject(student);   // If only one writeObject and more than one readObject it will through EOFexception.
    System.out.println(student);
    student.name = "Rani";
    oos.writeObject(student);
    System.out.println(student);
    
    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(b1.toByteArray())));
    Student des = (Student) ois.readObject();
    Student des1 = (Student) ois.readObject();
    if(des == des1)
      System.out.println("yes, references point to same object");
    else
      System.out.println("Diff Objects alltogether");
    System.out.println(des);
    System.out.println(des1);
    
    
    
    b1 = new ByteArrayOutputStream();
    oos = new ObjectOutputStream(b1);
    oos.writeUnshared(student);
    System.out.println("\n"+student);
    student.name = "Siva";
    oos.writeUnshared(student);
    System.out.println(student);
    
    ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(b1.toByteArray())));
    des = (Student) ois.readObject();  // readUnshared
    des1 = (Student) ois.readObject(); // readUnshared
    if(des == des1)
      System.out.println("yes, references point to same object");
    else
      System.out.println("Diff Objects alltogether");
    System.out.println(des);
    System.out.println(des1);
    
    
    b1 = new ByteArrayOutputStream();
    oos = new ObjectOutputStream(b1);
    oos.writeObject(student);
    oos.writeObject(student);
    
    ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(b1.toByteArray())));
    des = (Student) ois.readUnshared();  
    des1 = (Student) ois.readUnshared(); 
    // InvalidObjectException as object is written via writeObject and both points to same Object. and readUnshared expects
    // that the objects should be written with Unshared and to be different objects
    
  }
}