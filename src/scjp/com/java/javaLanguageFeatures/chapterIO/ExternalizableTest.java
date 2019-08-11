package scjp.com.java.javaLanguageFeatures.chapterIO;

/*
Key differences between Serializable and Externalizable

Implementation :
    Unlike Serializable interface which will serialize the variables in object with just by implementing interface,
    here we have to explicitly mention what fields or variables you want to serialize.
Methods :
    Serializable is marker interface without any methods. Externalizable interface contains two methods: writeExternal() and readExternal().
Process:
    Default Serialization process will take place for classes implementing Serializable interface.
    Programmer defined Serialization process for classes implementing Externalizable interface.
Backward Compatibility and Control:
    If you have to support multiple versions, you can have full control with Externalizable interface.
    You can support different versions of your object. If you implement Externalizable, it’s your responsibility to serialize super class.
public No-arg constructor:
    Serializable uses reflection to construct object and does not require no arg constructor.
    But Externalizable requires public no-arg constructor.
*/

import java.io.*;

public class ExternalizableTest {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Emp emp = new Emp("Ram", 25, 6);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(emp);
    emp.name = "Laxman";
    oos.writeObject(emp); // It doesn't write object 2 times to the stream. Rather the JVM back references to the first object written.
    oos.flush();
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
    Emp newEmp = (Emp)ois.readObject();
    Emp newEmp2 = (Emp)ois.readObject();
    ois.close();

    System.out.println(newEmp);
    System.out.println(newEmp2);
  }
}

class Emp implements Externalizable {
  String name;
  int age;
  int height;
  private static final long serialVersionUUID = 31234123412341234L;

  public Emp() {} // Default constructor is mandatory for Externalizable

  public Emp(String name, int age, int height) {
    this.name = name;
    this.age = age;
    this.height = height;
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
//    out.writeObject(this.name);
    out.writeUTF(this.name);
    out.writeInt(this.age);
    out.writeInt(this.height);
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//    this.name = (String) in.readObject();
    this.name = in.readUTF();
    this.age = in.readInt();
    this.height = in.readInt();
  }

  @Override
  public String toString() {
    return "Name: " + this.name + ", Age: " + this.age + ", Height: " + this.height;
  }
}
