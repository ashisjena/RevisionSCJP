package scjp.com.java.algorithm.linkedlist;

public class MergeTwoSortedLinkedListKeepingOrder
{
	public static void main( String[] args )
	{
		NodeSingleLinkedList<Integer> linkedList1 = NodeSingleLinkedList.formLinkedList( new int[] { 1, 3, 5, 9, 16 } );
		NodeSingleLinkedList<Integer> linkedList2 = NodeSingleLinkedList.formLinkedList( new int[] { 2, 4, 8, 10, 14, 22 } );

		System.out.println( mergeListRecurr( linkedList1, linkedList2 ) );

		//System.out.println( mergeList( linkedList1, linkedList2 ) );
	}

	private static NodeSingleLinkedList<Integer> mergeList( NodeSingleLinkedList<Integer> linkedList1, NodeSingleLinkedList<Integer> linkedList2 )
	{
		NodeSingleLinkedList<Integer> head = null;
		NodeSingleLinkedList<Integer> finger = null;

		while ( linkedList1 != null || linkedList2 != null )
		{
			if ( linkedList1 == null )
			{
				finger.setNext( linkedList2 );
				break;
			}
			else if ( linkedList2 == null )
			{
				finger.setNext( linkedList1 );
				break;
			}

			if ( linkedList1.getValue() < linkedList2.getValue() )
			{
				if ( head == null )
				{
					head = finger = linkedList1;
					linkedList1 = linkedList1.getNext();
					continue;
				}

				finger.setNext( linkedList1 );
				finger = linkedList1;
				linkedList1 = linkedList1.getNext();
			}
			else
			{
				if ( head == null )
				{
					head = finger = linkedList2;
					linkedList2 = linkedList2.getNext();
					continue;
				}

				finger.setNext( linkedList2 );
				finger = linkedList2;
				linkedList2 = linkedList2.getNext();
			}
		}

		return head != null ? head : finger;
	}

	private static NodeSingleLinkedList<Integer> mergeListRecurr( NodeSingleLinkedList<Integer> linkedList1, NodeSingleLinkedList<Integer> linkedList2 )
	{
		if ( linkedList1 == null )
			return linkedList2;
		if ( linkedList2 == null )
			return linkedList1;

		NodeSingleLinkedList<Integer> result = null;

		if ( linkedList1.getValue() <= linkedList2.getValue() )
		{
			result = linkedList1;
			result.setNext( mergeListRecurr( linkedList1.getNext(), linkedList2 ) );
		}
		else
		{
			result = linkedList2;
			result.setNext( mergeListRecurr( linkedList2.getNext(), linkedList1 ) );
		}

		return result;
	}
}