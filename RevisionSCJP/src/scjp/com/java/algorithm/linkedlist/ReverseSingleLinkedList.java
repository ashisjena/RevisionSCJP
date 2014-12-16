package scjp.com.java.algorithm.linkedlist;

public class ReverseSingleLinkedList
{
	public static void main( String[] args )
	{
		NodeSingleLinkedList<Integer> headNode = new NodeSingleLinkedList<Integer>( 1 );
		NodeSingleLinkedList<Integer> finger = headNode;
		for ( int i = 2; i < 10; i++ )
		{
			NodeSingleLinkedList<Integer> nextNode = new NodeSingleLinkedList<Integer>( i );
			finger.setNext( nextNode );
			finger = nextNode;
		}

		//		Node<Integer> newHeadNode = reverseLinkedList( headNode );
		NodeSingleLinkedList<Integer> newHeadNode = reverseRecLinkedList( headNode, null );

		while ( newHeadNode != null )
		{
			System.out.println( newHeadNode.getValue() );
			newHeadNode = newHeadNode.getNext();
		}
	}

	private static NodeSingleLinkedList<Integer> reverseLinkedList( NodeSingleLinkedList<Integer> current )
	{
		NodeSingleLinkedList<Integer> reversedPart = null;
		while ( current != null )
		{
			NodeSingleLinkedList<Integer> next = current.getNext();
			current.setNext( reversedPart );
			reversedPart = current;
			current = next;
		}
		return reversedPart;
	}

	private static NodeSingleLinkedList<Integer> reverseRecLinkedList( NodeSingleLinkedList<Integer> current, NodeSingleLinkedList<Integer> reversedPart )
	{
		NodeSingleLinkedList<Integer> next = current.getNext();
		current.setNext( reversedPart );

		return ( next == null ) ? current : reverseRecLinkedList( next, current );
	}
}