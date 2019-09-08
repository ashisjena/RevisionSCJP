package scjp.com.java.algorithm.datastructures.linkedlist;

public class DisplayLinkedListFromEnd
{

	public static void main( String[] args )
	{
		NodeSingleLinkedList<Integer> head = NodeSingleLinkedList.formLinkedList( 10 );

		recurrDisplay( head );
	}

	private static void recurrDisplay( NodeSingleLinkedList<Integer> node )
	{
		if ( node.getNext() != null )
			recurrDisplay( node.getNext() );

		System.out.println( node.getValue() );
	}
}