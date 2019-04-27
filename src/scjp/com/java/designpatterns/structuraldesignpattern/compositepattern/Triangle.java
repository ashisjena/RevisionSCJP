package scjp.com.java.designpatterns.structuraldesignpattern.compositepattern;

public class Triangle implements Shape
{
    @Override
    public void draw( String fillColor )
    {
        System.out.println( "Drawing Triangle with color " + fillColor );
    }

}