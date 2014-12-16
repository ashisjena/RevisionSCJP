package scjp.com.java.algorithm.linkedlist;

public class CheckForCyclicLinkedList
{
	public static void main( String[] args )
	{
		NodeSingleLinkedList<Integer> head = NodeSingleLinkedList.formCyclicLinkedList( 100, 57 );
//		Node<Integer> head = Node.formLinkedList( 100 );

		NodeSingleLinkedList<Integer> fastPointer = isCyclic( head );
		if ( !( fastPointer == NodeSingleLinkedList.DEMO_NODE ) )
		{
			System.out.println( "This linkedList is cyclic" );
			System.out.println( "IntersectionNode is : " + getIntersectionNode( head, fastPointer ).getValue() );
		}
		else
			System.out.println( "This linkedList is not cylic" );
	}

	private static NodeSingleLinkedList<Integer> isCyclic( NodeSingleLinkedList<Integer> head )
	{
		NodeSingleLinkedList<Integer> slowPointer = head;
		NodeSingleLinkedList<Integer> fastPointer = head;

		boolean isCyclic = false;
		while ( fastPointer != null && fastPointer.getNext() != null )
		{
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();

			if ( slowPointer == fastPointer )
			{
				isCyclic = true;
				break;
			}
		}

		if ( isCyclic )
			return fastPointer;
		else
			return NodeSingleLinkedList.DEMO_NODE;
	}
	
	private static NodeSingleLinkedList<Integer> getIntersectionNode( NodeSingleLinkedList<Integer> slowPointer, NodeSingleLinkedList<Integer> fastPointer )
	{
		for ( ; slowPointer.getNext() != fastPointer.getNext(); slowPointer = slowPointer.getNext(), fastPointer = fastPointer.getNext() )
			;
		return slowPointer.getNext();
	}
}