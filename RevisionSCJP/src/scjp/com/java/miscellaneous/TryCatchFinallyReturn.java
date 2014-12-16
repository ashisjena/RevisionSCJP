package scjp.com.java.miscellaneous;

public class TryCatchFinallyReturn
{
    public static void main( String[] args )
    {
        System.out.println(method(false));
        System.out.println();
        System.out.println(method(true));
    }

    public static String method( boolean bool )
    {
        try
        {
            if ( bool )
                return "try";
            throw new Exception();
        }
        catch ( Exception e )
        {
            System.out.println( "catch" );
        }
        finally
        {
            return "Finally";
        }
    }

}
