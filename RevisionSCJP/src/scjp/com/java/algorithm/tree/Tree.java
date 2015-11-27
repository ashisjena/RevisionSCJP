package scjp.com.java.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<E extends Comparable<E>>
{
	private E data;
	private Tree<E> parent, left, right;

	public Tree( E data, Tree<E> left, Tree<E> right )
	{
		this.data = data;

		if ( left == null )
			this.left = new Tree<E>();
		else
            this.left = left;
        
		this.left.setParent(this);

		if ( right == null )
			this.right = new Tree<E>();
		else
          this.right = right;
        
		this.right.setParent(this);
	}

	Tree( E val )
	{
		this( val, null, null );
	}

	Tree()
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

	public Tree<E> getParent()
	{
		return this.parent;
	}

	public void setParent( Tree<E> parent )
	{
		if ( !isEmpty() )
			this.parent = parent;
	}

	public Tree<E> getLeft()
	{
		return this.left;
	}

	public void setLeft( Tree<E> left )
	{
		if ( isEmpty() )
			return;

		if ( left == null )
			left = new Tree<E>();
		else if ( this.left != null )
		{
			this.left.parent = null;
			this.left = left;
			left.parent = this;
		}
	}

	public Tree<E> getRight()
	{
		return this.right;
	}

	public void setRight( Tree<E> right )
	{
		if ( isEmpty() )
			return;

		if ( right == null )
			right = new Tree<E>();
		else if ( this.right != null)
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

		int leftSize = left.size();
		int rightSize = right.size();
		return leftSize + rightSize + 1;
	}

	public Tree<E> getRoot()
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
	
	// Get complete tree
    public static Tree<Integer> sortedArrayToBST(int[] num, int start, int end) {
      if (start > end)
        return new Tree<>();
  
      //      int mid = start + ((end - start) / 2); for Binary search tree... for complete tree below code

      /*
       *  2^0 + 2^1 + 2^2 .... 2^n = 2^(n+1) - 1 == length in Ideal case
       *  height = log(length + 1)
       */
      
      int heightOfLeft = (int) (Math.ceil(log(((end - start + 1) + 1), 2)) - 1);  // Math.ceil for ideal value
      int idealMidConsideringLeftasFull = (int) (start + Math.pow(2, heightOfLeft) - 1);
  
      int minNosOnRight = (int) (Math.pow(2, (heightOfLeft - 1)) - 1);
  
      int mid;
      if (idealMidConsideringLeftasFull + minNosOnRight > end)
        mid = end - minNosOnRight;
      else
        mid = idealMidConsideringLeftasFull;
      
      Tree<Integer> root = new Tree<Integer>(num[mid]);
      root.left = sortedArrayToBST(num, start, mid - 1);
      root.right = sortedArrayToBST(num, mid + 1, end);
  
      return root;
    }
    
    public static double log(int x, int base)
    {
        return Math.log(x) / Math.log(base);
    }
    
	public static void print(Tree<Integer> root)
    {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<Tree<Integer>> level = new ArrayList<Tree<Integer>>();
        List<Tree<Integer>> next = new ArrayList<Tree<Integer>>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (Tree<Integer> n : level) {
                if (n == null || n.data == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getData().toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Tree<Integer>> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '^' : '|';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '|';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "-");
                        }
                        System.out.print(j % 2 == 0 ? "|" : "|");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "-" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
}