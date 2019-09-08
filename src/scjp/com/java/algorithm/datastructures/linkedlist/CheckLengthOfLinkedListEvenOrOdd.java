package scjp.com.java.algorithm.datastructures.linkedlist;

public class CheckLengthOfLinkedListEvenOrOdd
{
	public static void main( String[] args )
	{
		NodeSingleLinkedList<Integer> head = NodeSingleLinkedList.formLinkedList( 10 );

		findLengthIsEvenOrOdd( head );
	}

	private static void findLengthIsEvenOrOdd( NodeSingleLinkedList<Integer> node )
	{
		if ( node == null )
		{
			System.out.println( "Even Length linked list" );
			return;
		}
		else if ( node.getNext() == null )
		{
			System.out.println( "Odd Length linked list" );
			return;
		}
		
		findLengthIsEvenOrOdd( node.getNext().getNext() );
	}
}