package scjp.com.java.javaLanguageFeatures.chapterReflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class ClassDescription {
  public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
    System.out.println(getClassDescription(Person.class));
    System.out.println(Person.class.getConstructors().length);
    System.out.println(Person.class.getDeclaredConstructors().length);

    Class<Person> personClass = Person.class;
    Person p = personClass.getConstructor(Object.class, Object.class).newInstance("Ram", 10);
    System.out.println(p);
    Field nameField = personClass.getDeclaredField("name");
    nameField.setAccessible(true);
    System.out.println(nameField.get(p));
  }

  public static String getClassDescription(Class<?> cls) {
    StringBuilder classDesc = new StringBuilder();
    int modifierBits = 0;
    String keyword = "";
    if (cls.isPrimitive()) {
      // We don't want to add anything.
    } else if (cls.isInterface()) {
      modifierBits = cls.getModifiers() & Modifier.interfaceModifiers();
      if (cls.isAnnotation()) {
        keyword = "@interface";
      } else {
        keyword = "interface";
      }
    } else if (cls.isEnum()) {
      modifierBits = cls.getModifiers() & Modifier.classModifiers();
      keyword = "enum";
    } else {
      modifierBits = cls.getModifiers() & Modifier.classModifiers();
      keyword = "class";
    }
    String modifiers = Modifier.toString(modifierBits);
    classDesc.append(modifiers);
    classDesc.append(" ");
    classDesc.append(keyword);
    String simpleName = cls.getSimpleName();
    classDesc.append(" ");
    classDesc.append(simpleName);
    String genericParams = getGenericTypeParams(cls);
    classDesc.append(genericParams);
    Class superClass = cls.getSuperclass();
    if (superClass != null) {
      String superClassSimpleName = superClass.getSimpleName();
      classDesc.append(" extends ");
      classDesc.append(superClassSimpleName);
    }
    String interfaces = getClassInterfaces(cls);
    if (interfaces != null) {
      classDesc.append(" implements ");
      classDesc.append(interfaces);
    }
    return classDesc.toString().trim();
  }

  private static String getClassInterfaces(Class<?> cls) {
    Class<?>[] interfaces = cls.getInterfaces();
    if (interfaces.length == 0) {
      return null;
    }
    String[] names = new String[interfaces.length];
    for (int i = 0; i < interfaces.length; i++) {
      names[i] = interfaces[i].getSimpleName();
    }
    String interfacesList = String.join(",", names);
    return interfacesList;
  }

  public static String getGenericTypeParams(Class<?> cls) {
    StringBuilder sb = new StringBuilder();
    TypeVariable<?>[] typeParms = cls.getTypeParameters();
    if (typeParms.length == 0) {
      return "";
    }
    String[] paramNames = new String[typeParms.length];
    for (int i = 0; i < typeParms.length; i++) {
      paramNames[i] = typeParms[i].getTypeName();
    }
    sb.append('<');
    String parmsList = String.join(",", paramNames);
    sb.append(parmsList);
    sb.append('>');
    return sb.toString();
  }
}

class Person<T, Q> implements Runnable{
  public Person(T name, Q age) {
    this.name = name;
    this.age = age;
  }
  public Person() {}
  protected Person(T name) {
    this.name = name;
  }

  private T name;
  private Q age;
  public T getName() {return name;}
  public void setName(Q name) {}
  @Override
  public void run() {}
}
