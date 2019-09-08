package scjp.com.java.algorithm.datastructures.linkedlist;

import java.util.Random;

public class NodeSingleLinkedList<E>
{
	public static void main( String[] args )
	{
		NodeSingleLinkedList<Integer> linkedList = NodeSingleLinkedList.formLinkedList( 11, 1, 1 );
		System.out.println( linkedList );
	}


	public final static NodeSingleLinkedList<Integer> DEMO_NODE = new NodeSingleLinkedList<Integer>( new Random().nextInt( Integer.MAX_VALUE ) + Integer.MIN_VALUE );

	private E value;
	private NodeSingleLinkedList<E> next;

	public NodeSingleLinkedList( E value, NodeSingleLinkedList<E> next )
	{
		this.value = value;
		this.next = next;
	}

	public NodeSingleLinkedList( E value )
	{
		this.value = value;
	}

	public E getValue()
	{
		return this.value;
	}

	public void setNext( NodeSingleLinkedList<E> next )
	{
		this.next = next;
	}

	public NodeSingleLinkedList<E> getNext()
	{
		return this.next;
	}

	@Override
	public String toString()
	{
		NodeSingleLinkedList<E> head = this;
		StringBuilder sb = new StringBuilder();
		while ( head != null )
		{
			sb.append( head.getValue() + "   " );
			head = head.getNext();
		}

		return sb.toString();
	}

	public static NodeSingleLinkedList<Integer> formLinkedList( int[] values )
	{
		NodeSingleLinkedList<Integer> head = new NodeSingleLinkedList<Integer>( values[0] );
		NodeSingleLinkedList<Integer> finger = head;

		boolean isSkipped = false;
		for ( int value : values )
		{
			if ( !isSkipped )
			{
				isSkipped = true;
				continue;
			}
			finger.next = new NodeSingleLinkedList<Integer>( value );
			finger = finger.next;
		}

		return head;
	}

	public static NodeSingleLinkedList<Integer> formLinkedList( int size )
	{
		return formLinkedList( size, null );
	}

	public static NodeSingleLinkedList<Integer> formLinkedList( int size, Integer start )
	{
		if ( start == null )
			start = 1;
		return formLinkedList( size, null, start );
	}

	public static NodeSingleLinkedList<Integer> formLinkedList( int size, Integer increment, Integer start )
	{
		if ( increment == null )
			increment = 1;

		NodeSingleLinkedList<Integer> head = new NodeSingleLinkedList<Integer>( start );
		NodeSingleLinkedList<Integer> finger = head;

		for ( int i = start + increment, length = 1; length < size; i += increment, length++ )
		{
			finger.next = new NodeSingleLinkedList<Integer>( i );
			finger = finger.next;
		}

		return head;
	}

	public static NodeSingleLinkedList<Integer> formCyclicLinkedList( int size, Integer increment, Integer start, int intersectionNode )
	{
		if ( increment == null )
			increment = 1;

		NodeSingleLinkedList<Integer> head = NodeSingleLinkedList.formLinkedList( size, increment );
		NodeSingleLinkedList<Integer> finger1 = head;
		for ( int i = 0; i < ( size - intersectionNode ) && finger1 != null; finger1 = finger1.getNext(), i++ )
			;

		NodeSingleLinkedList<Integer> finger2 = head;
		for ( ; finger1.getNext() != null; finger1 = finger1.getNext(), finger2 = finger2.getNext() )
			;

		finger1.setNext( finger2 );

		return head;
	}

	public static NodeSingleLinkedList<Integer> formCyclicLinkedList( int size, Integer start, int intersectionNode )
	{
		return formCyclicLinkedList( size, null, start, intersectionNode );
	}

	public static NodeSingleLinkedList<Integer> formCyclicLinkedList( int size, int intersectionNode )
	{
		return formCyclicLinkedList( size, null, null, intersectionNode );
	}
}