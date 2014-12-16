package scjp.com.java.designpatterns.structuraldesignpattern.decoratorpattern;

public class BasicCar implements Car
{
    @Override
    public void assemble()
    {
        System.out.print( "Basic Car." );
    }
}