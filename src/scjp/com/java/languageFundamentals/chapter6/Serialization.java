package scjp.com.java.languageFundamentals.chapter6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Serialization {
  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    /*Student student = new Student(1, "Rama", 5);
    ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(new File("stu.ser")));
    ois.writeObject(student);*/

    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("stu.ser"));
    Student desStu = (Student) inputStream.readObject();
    System.out.println(desStu);
    inputStream.close();

    inputStream = new ObjectInputStream(new FileInputStream("stu.ser"));
    Student des2 = (Student) inputStream.readObject();
    if (des2 == desStu) {
      System.out.println("hi");
    } else if (des2.equals(desStu)) {
      System.out.println("Hello");
    }
    inputStream.close();
  }
}


class Student implements Serializable {
  private static final long serialVersionUID = 1L;
  // If we change the serialization id and try to deserialize older version with different id, it will throw ClassCastException 
  int id;
  String name;
  double sal;

  public Student(int id, String name, double sal) {
    this.id = id;
    this.name = name;
    this.sal = sal;
  }

  @Override
  public String toString() {
    return id + ", " + name + ", " + sal;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Student) {
      Student stu = (Student) obj;
      return this.id == stu.id && this.name.equals(stu.name) && this.sal == stu.sal;
    }
    return false;
  }
}
