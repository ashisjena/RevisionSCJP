package scjp.com.java.chapter7;

@Deprecated
public class SingleLinkedListEx
{

    public static void main( String[] args )
    {

    }

}
@Deprecated
class SingleyLinkedList<E> implements ILinkedList< E >
{
    protected int countOfElements;
    protected Node< E > head;

    public SingleyLinkedList()
    {
        head = null;
        countOfElements = 0;
    }

    public int size()
    {
        return countOfElements;
    }

    public void addFirst( E value )
    {
        /*Node< E > newHead = new Node< E >( value );
        newHead.setNext( head );
        head = newHead;*/
        // or
        head = new Node< E >( value, head );
        countOfElements++;
    }

    public E removeFirst()
    {
        Node< E > temp = head;
        head = head.next();
        countOfElements--;
        return temp.value();
    }

    public E getFirst()
    {
        return head.value();
    }

    public void addLast( E value )
    {
        Node< E > temp = new Node< E >( value );
        if ( head != null )
        {
            Node< E > finger = head;
            while ( finger.next() != null )
                finger = finger.next();

            finger.setNext( temp );
        }
        else
            head = temp;

        countOfElements++;
    }

    public E removeLast()
    {
        if ( head != null )
        {
            Node< E > finger = head;
            Node< E > previous = null;
            while ( finger.next() != null )
            {
                previous = finger;
                finger = previous.next();
            }

            if ( previous == null )
                head = null;
            else
                previous.setNext( null );

            countOfElements--;
            return finger.value();
        }
        else
            return null;
    }

    public boolean contains( E value )
    {
        Node< E > finger = head;
        while ( finger != null && !finger.value().equals( value ) )
            finger = finger.next();

        return finger != null;
    }

    public E remove( E value )
    {
        Node< E > finger = head;
        Node< E > previous = null;
        while ( finger != null && !finger.value().equals( value ) )
        {
            previous = finger;
            finger = finger.next();
        }

        if ( finger != null )
        {
            if ( previous != null )
                previous.setNext( finger.next() );
            else
                head = null;

            countOfElements--;
            return finger.value();
        }
        else
            return null;
    }

    public void clear()
    {
        head = null;
        countOfElements = 0;
    }

    public void add( int index, E value )
    {
        if ( index == size() - 1 )
            addLast( value );
        else if ( index == 0 )
            addFirst( value );
        else
        {
            Node< E > finger = head;
            Node< E > previous = null;
            while ( index > 0 )
            {
                previous = finger;
                finger = finger.next();
                index--;
            }

            previous.setNext( new Node< E >( value, finger ) );
        }

        countOfElements++;
    }

    public E remove( int index )
    {
        if ( index >= size() )
            throw new RuntimeException( "size is more than the list size" );

        countOfElements--;
        if ( index == size() - 1 )
            return removeLast();
        else if ( index == 0 )
            return removeFirst();
        else
        {
            Node< E > finger = head;
            Node< E > previous = null;
            while ( index > 0 )
            {
                previous = finger;
                finger = finger.next();
                index--;
            }

            previous.setNext( finger.next() );
            return finger.value();
        }
    }
}

@Deprecated
class Node<G> implements Comparable< Node<G> >
{
    private G data;
    private Node< G > nextElement;

    public Node( G v )
    {
        this( v, null );
    }

    public Node( G v, Node< G > next )
    {
        data = v;
        nextElement = next;
    }

    public Node< G > next()
    {
        return nextElement;
    }

    public void setNext( Node< G > next )
    {
        nextElement = next;
    }

    public G value()
    {
        return data;
    }

    public void setValue( G v )
    {
        data = v;
    }

    @Override
    public int compareTo( Node< G > node )
    {
        // write own logic to compare
        // return one of the values 1, 0, -1 if passed value is bigger, equal and less respectively
        return 0;
    }

}