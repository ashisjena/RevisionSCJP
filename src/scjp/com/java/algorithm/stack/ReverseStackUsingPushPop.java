package scjp.com.java.algorithm.stack;

import java.util.Stack;

public class ReverseStackUsingPushPop
{
	public static void main( String[] args )
	{
		Stack<Integer> stack = new Stack<Integer>();

		for ( int i = 1; i < 5; i++ )
			stack.push( i );

		reverseStack( stack );

		while ( !stack.isEmpty() )
			System.out.println( stack.pop() );
	}

	private static void reverseStack( Stack<Integer> stack )
	{
		if ( stack.isEmpty() )
			return;

		int tempValue = stack.pop();
		reverseStack( stack );

		insertAtBottom( stack, tempValue );
	}

	private static void insertAtBottom( Stack<Integer> stack, int value )
	{
		if ( stack.isEmpty() )
		{
			stack.push( value );
			return;
		}

		int tempValue = stack.pop();
		insertAtBottom( stack, value );
		stack.push( tempValue );
	}
}