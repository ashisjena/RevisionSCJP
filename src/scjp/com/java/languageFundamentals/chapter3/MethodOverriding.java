package scjp.com.java.languageFundamentals.chapter3;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MethodOverriding {
}

class Animal {
  public int x = 10;

  protected Number bark() throws IOException {
    System.out.println("Animal Barks");
    return 10;
  }

}

class Dog extends Animal {
  public int x = 15;

  @Override
  // No private // Can't be more restrictive
  // Return type can be child // Children class.
  // Exception can be children but not broder.
  public Integer bark() throws FileNotFoundException {
    System.out.println("Dog Barks");
    return 20;
  }

}
