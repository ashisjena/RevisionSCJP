package scjp.com.java.javaLanguageFeatures.chapterReflection;

public class TestClassForname {
  public static void main(String[] args) throws ClassNotFoundException {
//    createObject();
//    classLiteral();
//    forNameVersion1();
//    forNameVersion2();
    forNameVersion3();
  }

  public static void classLiteral() {
    // Will load the class but won't initialize it.
    Class<Bulb> c = Bulb.class;
  }

  public static void forNameVersion1() throws ClassNotFoundException {
    String className = "scjp.com.java.javaLanguageFeatures.chapterReflection.Bulb";
    // Will load and initialize the class
    Class c = Class.forName(className);
  }
  public static void forNameVersion2() throws ClassNotFoundException {
    String className = "scjp.com.java.javaLanguageFeatures.chapterReflection.Bulb";
    boolean initialize = false;
    // Get the classloader for the current class
    ClassLoader cLoader = TestClassForname.class.getClassLoader();
    // Will load the class but won't initialize upon passing the initialize arg to false.
    Class c = Class.forName(className, initialize, cLoader);
  }
  public static void forNameVersion3() throws ClassNotFoundException {
    String className = "scjp.com.java.javaLanguageFeatures.chapterReflection.Bulb";
    boolean initialize = true;
    // Get the classloader for the current class
    ClassLoader cLoader = TestClassForname.class.getClassLoader();
    // Will load the class and will initialize.
    Class c = Class.forName(className, initialize, cLoader);
  }
  public static void createObject() {
    new Bulb();
  }
}

class Bulb {
  static {
    System.out.println("Loading class Bulb..");
  }
}