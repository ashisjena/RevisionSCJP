package scjp.com.java.dynamicProgramming;

import java.util.Stack;

public class SolveMathematicalEquation
{

    public static void main( String[] args )
    {
        Stack< String > operators = new Stack< String >();
        Stack< Double > values = new Stack< Double >();

        String exp = "(5+4)-3";

        String[] arr = exp.split( "" );

        for ( String s : arr )
        {
            if ( s.equals( "" ) || s.equals( "(" ) )
                continue;
            if ( s.matches( "[-+/*///%]" ) )
                operators.push( s );
            else if ( s.equals( ")" ) )
                calculate( operators, values );
            else
                values.add( Double.parseDouble( s ) );
        }
        
        while ( values.size() > 1 )
            calculate( operators, values );
        System.out.println( values.pop() );

    }

    private static void calculate( Stack< String > operators, Stack< Double > values )
    {
        String operator = operators.pop();

        Double value = values.pop();

        if ( operator.equals( "+" ) )
            value += values.pop();
        else if ( operator.equals( "-" ) )
            value = values.pop() - value;
        else if ( operator.equals( "/" ) )
            value = values.pop() / value;
        else if ( operator.equals( "*" ) )
            value *= values.pop();
        else if ( operator.equals( "%" ) )
            value = values.pop() % value;

        values.push( value );
    }
}
