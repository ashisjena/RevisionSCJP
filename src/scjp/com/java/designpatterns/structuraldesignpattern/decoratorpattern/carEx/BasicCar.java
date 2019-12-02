package scjp.com.java.designpatterns.structuraldesignpattern.decoratorpattern.carEx;

public class BasicCar implements Car
{
    @Override
    public void assemble()
    {
        System.out.print( "Basic Car." );
    }
}