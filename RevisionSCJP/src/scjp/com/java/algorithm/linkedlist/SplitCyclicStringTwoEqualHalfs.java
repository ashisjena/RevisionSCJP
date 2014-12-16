package scjp.com.java.algorithm.linkedlist;

public class SplitCyclicStringTwoEqualHalfs
{
	public static void main( String[] args )
	{
		NodeSingleLinkedList<Integer> cyclicList = NodeSingleLinkedList.formCyclicLinkedList( 10, 1 );

		NodeSingleLinkedList<Integer> turtle;
		NodeSingleLinkedList<Integer> hare;

		NodeSingleLinkedList<Integer> endNodeTurtle = null;
		NodeSingleLinkedList<Integer> endNodeHare = null;
		boolean isFirstTime = false;
		for ( turtle = cyclicList, hare = cyclicList; isFirstTime && hare != cyclicList && hare.getNext() != cyclicList; endNodeTurtle = turtle, turtle = turtle.getNext(), endNodeHare = hare, hare = hare.getNext().getNext() )
		{
			System.out.println();
		}

		NodeSingleLinkedList<Integer> head1 = cyclicList;
		NodeSingleLinkedList<Integer> head2 = turtle;

		endNodeHare.setNext( null );
		endNodeTurtle.setNext( null );

		System.out.println( head1 );
		System.out.println( head2 );
	}
}