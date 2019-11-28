package scjp.com.java.languageFundamentals.chapter3;

public class MainClass
{
    public static void main( String[] args )
    {
        float f = 13.34f;
        short s = (short)f;
        System.out.println(s);
        
        byte b1 = 10;
        byte b2 = 15;
        
//        byte b3 = b1 + b2; // Incompatible types error. Require Int
//        byte b4 = b1 + 7; // Incompatible types error
//        System.out.println(b3);
        
        int x = 21;
        int[] intarr = {2, x, b1};
        
       
        int[][] scores = {{1,2,31,1}, {2,1}, {6,3}};
        
        scores = new int[3][];
//        scores[0] = {1,2,31,1}; // Array initializer is not allowed here.
        scores[0] = new int[]{1,2,31,1};
        
        Car[] cars;
        Honda[] hondaCars = new Honda[5];
        
        cars =  hondaCars;
//        hondaCars = cars;
        System.out.println(cars);
    }
}


class Car
{
    
}

class Honda extends Car
{
    
}
