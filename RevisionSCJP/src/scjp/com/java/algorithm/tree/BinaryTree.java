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
			this.left.parent = null;

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
			this.right.parent = null;
	}
}