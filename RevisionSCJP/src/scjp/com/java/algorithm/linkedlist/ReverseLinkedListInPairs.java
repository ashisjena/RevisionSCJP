package scjp.com.java.algorithm.linkedlist;

public class ReverseLinkedListInPairs
{
	public static void main( String[] args )
	{
		NodeSingleLinkedList<Integer> linkedList = NodeSingleLinkedList.formLinkedList( 11, 1, 1 );
		System.out.println( linkedList );
		//System.out.println( reversePairWiseRecurr( linkedList ) );
		System.out.println( reversePairWise( linkedList ) );
	}

	private static NodeSingleLinkedList<Integer> reversePairWise( NodeSingleLinkedList<Integer> linkedList )
	{
		if ( linkedList == null )
			return null;
		else if ( linkedList.getNext() == null )
			return linkedList;

		NodeSingleLinkedList<Integer> node = linkedList;
		NodeSingleLinkedList<Integer> head = linkedList.getNext(), next = head;

		while ( node != null && next != null )
		{
			NodeSingleLinkedList<Integer> remaing = next.getNext();

			next.setNext( node );

			if ( remaing == null || remaing.getNext() == null )
			{
				node.setNext( remaing );
				break;
			}
			else
			{
				next = remaing.getNext();
				node.setNext( next );
				node = remaing;
			}
		}

		return head;
	}

	private static NodeSingleLinkedList<Integer> reversePairWiseRecurr( NodeSingleLinkedList<Integer> node )
	{
		if ( node == null )
			return null;
		else if ( node.getNext() == null )
			return node;

		NodeSingleLinkedList<Integer> head = node.getNext();
		NodeSingleLinkedList<Integer> remaing = head.getNext();
		head.setNext( node );
		node.setNext( reversePairWiseRecurr( remaing ) );

		return head;
	}
}