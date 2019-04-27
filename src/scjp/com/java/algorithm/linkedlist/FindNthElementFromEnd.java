package scjp.com.java.algorithm.linkedlist;

public class FindNthElementFromEnd
{
	public static void main( String[] args )
	{
		NodeSingleLinkedList<Integer> head = NodeSingleLinkedList.formLinkedList( 10 );

		int nthFromLast = 4;

		NodeSingleLinkedList<Integer> finger1 = head;
		for ( int i = 0; i < nthFromLast && finger1 != null; i++, finger1 = finger1.getNext() )
			;

		NodeSingleLinkedList<Integer> finger2 = head;
		for ( ; finger1 != null; finger1 = finger1.getNext(), finger2 = finger2.getNext() )
			;

		System.out.println( finger2.getValue() );

	}
}