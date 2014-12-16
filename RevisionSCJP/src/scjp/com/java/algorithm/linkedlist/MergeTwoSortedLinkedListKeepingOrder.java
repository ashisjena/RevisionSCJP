package scjp.com.java.algorithm.linkedlist;

public class MergeTwoSortedLinkedListKeepingOrder
{
	public static void main( String[] args )
	{
		NodeSingleLinkedList<Integer> linkedList1 = NodeSingleLinkedList.formLinkedList( new int[] { 1, 3, 5, 9, 16 } );
		NodeSingleLinkedList<Integer> linkedList2 = NodeSingleLinkedList.formLinkedList( new int[] { 2, 4, 8, 10, 14, 22 } );

		NodeSingleLinkedList<Integer> mergedHead = mergeList( linkedList1, linkedList2 );
		NodeSingleLinkedList.toString( mergedHead );
	}

	private static NodeSingleLinkedList<Integer> mergeList( NodeSingleLinkedList<Integer> linkedList1, NodeSingleLinkedList<Integer> linkedList2 )
	{
		if ( linkedList1 == null )
			return linkedList2;
		if ( linkedList2 == null )
			return linkedList1;

		NodeSingleLinkedList<Integer> result = null;

		if ( linkedList1.getValue() <= linkedList2.getValue() )
		{
			result = linkedList1;
			result.setNext( mergeList( linkedList1.getNext(), linkedList2 ) );
		}
		else
		{
			result = linkedList2;
			result.setNext( mergeList( linkedList2.getNext(), linkedList1 ) );
		}

		return result;
	}
}