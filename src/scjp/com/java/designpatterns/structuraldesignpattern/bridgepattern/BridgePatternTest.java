package scjp.com.java.designpatterns.structuraldesignpattern.bridgepattern;

public class BridgePatternTest
{
    public static void main( String[] args )
    {
        /*
            It decouple an abstraction from its implementation  so that two can vary independently.
            A Bridge pattern separates out responsibilities into different abstract classes.
         */

        Shape tri = new Triangle( new RedColor() );
        tri.applyColor();

        Shape pent = new Pentagon( new GreenColor() );
        pent.applyColor();
    }
}