package scjp.com.java.stackoverflow;

public class SortedLinkedList<E>
{
    private int countOfElements;
    private Node< E > head;

    public SortedLinkedList()
    {
        head = null;
        countOfElements = 0;
    }

    public int size()
    {
        return countOfElements;
    }

    public void add( E value )
    {
        Node< E > temp = new Node< E >( value );
        Node< E > finger = null;
        Node< E > previous = null;
        if ( head != null )
        {
            finger = head;
            while ( finger.next() != null && finger.compareTo( temp ) < 1 )
            {
                previous = finger;
                finger = finger.next();
            }

            previous.setNext( temp );
            temp.setNext( finger );
        }
        else
            head = temp;

        countOfElements++;
    }
}

class Node<E>
{
    private E data;
    private Node< E > nextElement;

    public Node( E v )
    {
        this( v, null );
    }

    public Node( E v, Node< E > next )
    {
        data = v;
        nextElement = next;
    }

    public Node< E > next()
    {
        return nextElement;
    }

    public void setNext( Node< E > next )
    {
        nextElement = next;
    }

    public E value()
    {
        return data;
    }

    public void setValue( E v )
    {
        data = v;
    }

    public int compareTo( Node< E > node )
    {
        if ( !( ( node.data instanceof Comparable ) || this.data instanceof Comparable ) )
            throw new ClassCastException( "The value Object doesn't implement Comparable" );

        Comparable comparable = (Comparable)this.data;

        return comparable.compareTo( node.data );
    }
}
