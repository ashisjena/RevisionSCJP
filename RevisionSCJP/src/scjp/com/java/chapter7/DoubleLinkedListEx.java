package scjp.com.java.chapter7;

public class DoubleLinkedListEx
{
    public static void main( String[] args )
    {

    }
}

class DoubleLinkedList<E> implements ILinkedList< E >
{
    int countOfElements = 0;
    NodeD< E > head = null;
    NodeD< E > tail = null;

    @Override
    public int size()
    {
        return countOfElements;
    }

    @Override
    public void addFirst( E value )
    {
        head = new NodeD< E >( value, head, null );

        if ( tail == null )
            tail = head;

        countOfElements++;
    }

    @Override
    public E removeFirst()
    {
        if ( head == null )
            return null;
        NodeD< E > finger = head;
        head = head.next();
        head.setPrevious( null );

        if ( tail == finger )
            tail = null;

        countOfElements--;
        return finger.value();
    }

    @Override
    public E getFirst()
    {
        return head.value();
    }

    @Override
    public void addLast( E value )
    {
        tail = new NodeD< E >( value, null, tail );
        countOfElements++;
    }

    @Override
    public E removeLast()
    {
        if ( tail == null )
            throw new RuntimeException( "Exception" );

        NodeD< E > finger = tail;
        tail = tail.previous();

        if ( head == finger )
            head = null;

        countOfElements--;
        return finger.value();
    }

    @Override
    public boolean contains( E value )
    {
        NodeD< E > finger = head;

        while ( finger != null && !finger.value().equals( value ) )
            finger = finger.next();

        return finger != null;
    }

    @Override
    public E remove( E value )
    {
        NodeD< E > finger = head;

        while ( finger != null && !finger.value().equals( value ) )
            finger = finger.next();

        if ( finger != null )
        {
            if ( finger.previous() != null )
                finger.previous().setNext( finger.next() );
            else
                head = finger.next();

            if ( finger.next() != null )
                finger.next().setPrevious( finger.previous() );
            else
                tail = finger.previous();

            countOfElements--;
            return finger.value();
        }
        else
            return null;
    }

    @Override
    public void clear()
    {
        head = null;
        tail = null;
        countOfElements = 0;
    }

    @Override
    public void add( int index, E value )
    {
        if ( index < 0 && index >= countOfElements )
            throw new RuntimeException();

        if ( index == 0 )
            addFirst( value );
        else if ( index == countOfElements - 1 )
            addLast( value );
        else
        {
            int count = 0;
            NodeD< E > finger = head;
            while ( finger != null )
                if ( count++ == index )
                    break;
                else
                    finger = finger.next();

            NodeD< E > temp = new NodeD< E >( value, finger, finger.previous() );
            finger.previous().setNext( temp );
            finger.setPrevious( temp );
            countOfElements++;
        }
    }

    @Override
    public E remove( int index )
    {
        if ( index > 0 && index < countOfElements )
            throw new RuntimeException();

        if ( index == 0 )
            return removeFirst();
        else if ( index == countOfElements - 1 )
            return removeLast();
        else
        {
            int count = 0;
            NodeD< E > finger = head;
            while ( finger != null )
                if ( count++ == index )
                    break;
                else
                    finger = finger.next();

            finger.previous().setNext( finger.next() );
            finger.next().setPrevious( finger.previous() );

            countOfElements--;
            return finger.value();
        }
    }

}

class NodeD<E>
{
    private E data;
    private NodeD< E > nextElement;
    private NodeD< E > previousElement;

    NodeD( E data )
    {
        this( data, null, null );
    }

    NodeD( E data, NodeD< E > next, NodeD< E > previous )
    {
        this.data = data;
        this.nextElement = next;
        this.previousElement = previous;
    }

    public E value()
    {
        return data;
    }

    public void setValue( E value )
    {
        this.data = value;
    }

    public NodeD< E > next()
    {
        return nextElement;
    }

    public NodeD< E > previous()
    {
        return previousElement;
    }

    public void setNext( NodeD< E > next )
    {
        this.nextElement = next;
    }

    public void setPrevious( NodeD< E > previous )
    {
        this.previousElement = previous;
    }
}
