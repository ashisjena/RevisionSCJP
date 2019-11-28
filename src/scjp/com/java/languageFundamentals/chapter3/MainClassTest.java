package scjp.com.java.languageFundamentals.chapter3;

public class MainClassTest extends SuperClass
{
    static
    {
        System.out.println( "MainClassTest.static block" );
    }
    
    MainClassTest()
    {
        System.out.println( "MainClassTest.MainClassTest()" );
    }
    
    public static void main( String[] args )
    {
        new MainClassTest();
        Short srt = 5;
        test(srt); // This will invoke the method with primitive parameter
//        test1(srt); // Short can't be applied to Integer
    }
    
    static void test(int i)
    {
        System.out.println( "MainClassTest.test()" );   
    }
    
    static void test(Integer i)
    {
        System.out.println( "MainClassTest.test()" );
    }
    
    static void test1(Integer i)
    {
        System.out.println( "MainClassTest.test1()" );
    }
    
    {
        System.out.println( "MainClassTest.initialization block()" );
    }
}

class SuperClass
{
    SuperClass()
    {
        System.out.println( "SuperClass.SuperClass()" );
    }
}
