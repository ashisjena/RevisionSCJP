package scjp.com.java.languageFundamentals.chapter3;

public class CreateConstructorInFieldDeclarations {
  
  CreateConstructorInFieldDeclarations test = new CreateConstructorInFieldDeclarations();
  
  public CreateConstructorInFieldDeclarations()
  {
    System.out.println("Constructor");
  }
  
  public static void main(String[] args) throws InterruptedException {
    
  CreateConstructorInFieldDeclarations test2 = new CreateConstructorInFieldDeclarations();
  }
}