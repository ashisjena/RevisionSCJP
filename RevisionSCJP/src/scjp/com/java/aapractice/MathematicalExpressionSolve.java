package scjp.com.java.aapractice;

import java.util.Stack;

public class MathematicalExpressionSolve
{
    public static void main(String[] args)
    {
        String str = "4+(5*2)-12+(5/2)";
        Stack<String> operators = new Stack<String>();
        Stack<Double> values = new Stack<Double>();
        
        String[] strs = str.split( "" );
        
        for(String s : strs)
        {
            if(s.equals( "(" ) || s.equals( "" ) || s.equals( " " ))
                continue;
            else if(s.matches( "[+-/*//%]" ))
                operators.push( s );
            else if(s.equals( ")"))
                calculate(operators, values);
            else
                values.push( Double.valueOf( s ) );
        }
        calculate( operators, values );
        System.out.println( values.pop() );
    }

    private static void calculate( Stack< String > operators, Stack< Double > values )
    {
        if(operators.isEmpty())
            return;
        String operator =  operators.pop();
        Double value = values.pop();
        
        if(operator.equals( "+" ))
            value += values.pop();
        else if(operator.equals( "-" ))
            value -= values.pop();
        else if(operator.equals( "*" ))
            value *= values.pop();
        else if(operator.equals( "/" ))
            value = values.pop() / value;
        else if(operator.equals( "%" ))
            value = values.pop() % value;
        
        values.push( value );
    }
    
    
//    public static void main( String[] args )
//    {
//        Stack< String > ops = new Stack< String >();
//        Stack< Double > vals = new Stack< Double >();
//        String str = "4+(5*2)";
//        String[] strs = str.split( "" );
//        // i is taken as 1 as the first value of string array will be null.
//        for ( int i = 1; i < strs.length; i++ )
//        {
//            String s = strs[ i ];
//            if ( s.equals( "(" ) )
//                continue;
//            else if ( s.matches( "[+-/*//]" ) )
//                ops.push( s );
//            else if ( s.equals( ")" ) )
//                calculate( ops, vals );
//            else
//                vals.push( Double.parseDouble( s ) );
//        }
//        //for final calculation
//        calculate( ops, vals );
//        System.out.println( vals.pop() );
//    }
//
//    static void calculate( Stack< String > operators, Stack< Double > values )
//    {
//        if ( operators.isEmpty() )
//            return;
//        String op = operators.pop();
//        double v = values.pop();
//        if ( op.equals( "+" ) )
//            v = values.pop() + v;
//        else if ( op.equals( "-" ) )
//            v = values.pop() - v;
//        else if ( op.equals( "*" ) )
//            v = values.pop() * v;
//        else if ( op.equals( "/" ) )
//            v = values.pop() / v;
//
//        values.push( v );
//    }
}