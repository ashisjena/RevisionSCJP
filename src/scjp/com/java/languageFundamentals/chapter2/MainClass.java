package scjp.com.java.languageFundamentals.chapter2;

public class MainClass
{
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub
        Animal animal = new Animal();
        //String str = (String)animal;
        Dog dog = (Dog)animal;  // No compilation error but fail during runtime.   
        //Cat cat = (Cat)animal;  // Inconvertible types
    }
}


class Animal 
{
}

class Dog extends Animal
{
}

class Cat
{
}