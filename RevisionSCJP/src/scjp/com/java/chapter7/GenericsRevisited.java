package scjp.com.java.chapter7;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class GenericsRevisited
{

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        List< ? super Dog > list1 = new ArrayList< Animal >(); // Lower bound
        list1.add( new Dog() ); // only dog can be added
        /*list1.add( new Animal() );
        list1.add( new Creature() );*/

        List< Dog > dogs = new ArrayList< Dog >();
        dogs.add( new Dog() );
        dogs.add( new Dog() );
        List< ? extends Animal > list2 = new ArrayList< Dog >( dogs );  // Upper bound
        //        list2.add( new Dog() );  //Nothing can be added

        List< ? > list3 = new ArrayList< Dog >();
        //        list3.add( new Dog() ); // Nothing can be added   `   `

        List< Cat > animals = (List< Cat >)list2;
        for ( Cat cat : animals )
            System.out.println( cat );

    }
}

class Dog extends Animal
{

}

class Cat extends Animal
{

}

class Animal extends Creature
{

}

class Creature
{

}
