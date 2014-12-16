package scjp.com.java.chapter1;

public class VarArgs
{
    
    public void varArgsMethod1(int... i)
    {
        System.out.println( "VarArgs.varArgsMethod1()" );
        for( int j : i )
        {
            System.out.println(j);
        } 
        
        //System.out.println(i[0] + ",  " + i[1]);
    }
    
    public void varArgsMethod1(Integer j, int... i)                 // Defining this is legal, but we can't call this method.
    {
        System.out.println( "VarArgs.varArgsMethod1() with two arguments" );
        for(int x : i)
        {
            System.out.println(x);
        }
    }

}
