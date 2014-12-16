package scjp.com.java.designpatterns.creationaldesignpattern.factorypattern;

public class FactoryDesignPattern
{

}

class Animal
{
    
}

class Dog extends Animal
{
    
}

class Cat extends Animal
{
    
}


// the AnimalFactory needs to be singleton or the method should be static
class AnimalFactory
{
    public static Animal getInstance(String animalType)
    {
        if(animalType.equals( "Cat" ))
            return new Cat();
        else if(animalType.equals( "Dog" ))
            return new Dog();
        else
            return null;
    }
}