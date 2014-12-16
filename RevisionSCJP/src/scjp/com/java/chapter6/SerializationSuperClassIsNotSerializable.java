package scjp.com.java.chapter6;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationSuperClassIsNotSerializable
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( bas );
        Dog dog = new Dog( "Jimmy", 30, "Black" );
        System.out.println( "Before Serialization : " + dog.name + ", " + dog.weight + ", " + dog.collar.collarColor);
        dog.name = "Sita";
        oos.writeObject( dog );

        ObjectInputStream ois = new ObjectInputStream( new ByteArrayInputStream( bas.toByteArray() ) );
        // or for speed-up reading --->  ois = new ObjectInputStream( new BufferedInputStream( new ByteArrayInputStream( bas.toByteArray() ) ) );
        dog = (Dog)ois.readObject();
        System.out.println( "Before Serialization : " + dog.name + ", " + dog.weight + ", " + dog.collar.collarColor);
    }
}

class Dog extends Animal implements Serializable
{
    private static final long serialVersionUID = 1L;
    public String name;
    public transient Collar collar;

    Dog( String name, int weight, String collarColor )
    {
        super( weight );
        this.name = name;
        this.weight = weight - 5;
        collar = new Collar();
        collar.collarColor = collarColor;
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.defaultWriteObject();
        oos.writeBytes(collar.collarColor);
    }
    
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException
    {
        ois.defaultReadObject();
        int ch = 0;
        String collarColor = "";
        while((ch = ois.read()) != -1)
        {
            collarColor += (char)ch;
        }
        this.collar = new Collar();
        this.collar.collarColor = collarColor;
    }
}

class Animal //implements Serializable
{
    public int weight;
    
    Animal(){this.weight = 10;};

    Animal( int weight )
    {
        this.weight = weight;
    }
}

class Collar
{
    public String collarColor;
}