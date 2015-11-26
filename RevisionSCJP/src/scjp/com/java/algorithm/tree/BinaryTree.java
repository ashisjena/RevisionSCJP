package scjp.com.java.algorithm.tree;

public class BinaryTree<E>
{
	private E data;
	private BinaryTree<E> parent, left, right;

	public BinaryTree( E data, BinaryTree<E> left, BinaryTree<E> right )
	{
		this.data = data;

		if ( left == null )
			left = new BinaryTree<E>();

		this.left = left;
		this.left.setParent( this );

		if ( right == null )
			right = new BinaryTree<E>();

		this.right = right;
		this.right.setParent( this );
	}

	BinaryTree( E val )
	{
		this( val, null, null );
	}

	BinaryTree()
	{
		this.data = null;
		this.left = this.right = null;
	}

	public E getData()
	{
		return data;
	}

	public boolean isEmpty()
	{
		return this.data == null;
	}

	public BinaryTree<E> getParent()
	{
		return this.parent;
	}

	public void setParent( BinaryTree<E> parent )
	{
		if ( !isEmpty() )
			this.parent = parent;
	}

	public BinaryTree<E> getLeft()
	{
		return this.left;
	}

	public void setLeft( BinaryTree<E> left )
	{
		if ( isEmpty() )
			return;

		if ( left == null )
			left = new BinaryTree<E>();
		else if ( this.left != null && this.left.parent == this )
		{
			this.left.parent = null;
			this.left = left;
			left.parent = this;
		}
	}

	public BinaryTree<E> getRight()
	{
		return this.right;
	}

	public void setRight( BinaryTree<E> right )
	{
		if ( isEmpty() )
			return;

		if ( right == null )
			right = new BinaryTree<E>();
		else if ( this.right != null && this.right.parent == this )
		{
			this.right.parent = null;
			this.right = right;
			this.right.parent = this;
		}
	}

	public int size()
	{
		if ( isEmpty() )
			return 0;

		return left.size() + right.size() + 1;
	}

	public BinaryTree<E> getRoot()
	{
		if ( parent == null )
			return this;
		else
			return parent.getRoot();
	}

	public int height()
	{
		if ( isEmpty() )
			return -1;
		else
			return 1 + Math.max( left.height(), right.height() );
	}

	public int depth()
	{
		if ( isEmpty() )
			return 0;
		else
			return 1 + parent.depth();
	}

	public boolean isFull()
	{
		if ( isEmpty() )
			return true;
		else if ( left.height() != right.height() )
			return false;

		return left.isFull() && right.isFull();
	}

	public boolean isComplete()
	{
		if ( isEmpty() )
			return true;

		final int leftHeight, rightHeight;
		final boolean leftIsFull, rightIsFull;
		final boolean leftIsComplete, rightIsComplete;

		leftHeight = left.height();
		rightHeight = right.height();
		leftIsFull = left.isFull();
		rightIsFull = right.isFull();
		leftIsComplete = left.isComplete();
		rightIsComplete = right.isComplete();

		// case 1: left is full, right is complete, heights same
		if ( leftIsFull && rightIsComplete && ( leftHeight == rightHeight ) )
			return true;

		// case 2: left is complete, right is full, heights differ
		if ( leftIsComplete && rightIsFull && ( leftHeight == ( rightHeight + 1 ) ) )
			return true;

		return false;
	}

	public static BinaryTree<Integer> formBinaryTree( int noOfElements )
	{
		BinaryTree<Integer> root = null;

		for ( int i = 0; i < noOfElements; i++ )
		{
			BinaryTree<Integer> node = new BinaryTree<Integer>( i );
			if ( root == null || root.data == null )
				root = node;
			else
			{
				BinaryTree<Integer> finger = root;
				BinaryTree<Integer> parent = null;
				while ( true )
				{
					if ( finger == null || finger.data == null )
					{
						node.setParent( parent );
						break;
					}
					parent = finger;
					if ( node.data > finger.data )
					{
						finger = finger.right;
					}
					else
					{
						finger = finger.left;
					}
				}
			}
		}

		return root;
	}
}