package scjp.com.java.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTest
{
	public static void main( String[] args )
	{
		BinaryTree<Integer> root = BinaryTree.formBinaryTree( new int[]{20,9,25,4,5,21,26} );
		System.out.println(root.size());
		BinaryTree.print(root);

		BinaryTree<Integer> finger = root;
		while(!finger.isEmpty())
		{
		  System.out.print(finger.getData() + ", ");
		  finger = finger.getRight();
		}
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		levelOrder(root);
		
		System.out.println();
		mirrorOfTree(root);
		BinaryTree.print(root);
	}
	
	static void mirrorOfTree(BinaryTree<Integer> root)
	{
	  if(!root.isEmpty())
	  {
	    mirrorOfTree(root.getLeft());
	    mirrorOfTree(root.getRight());
	    
	    BinaryTree<Integer> temp = root.getLeft();
	    root.setLeft(root.getRight());
	    root.setRight(temp);
	  }
	}
	
	static void levelOrder(BinaryTree<Integer> root)
	{
	  Queue<BinaryTree<Integer>> queue = new LinkedList<>();
	  BinaryTree<Integer> temp;
	  
	  queue.offer(root);
	  
	  while(!queue.isEmpty())
	  {
	    temp = queue.poll();
	    
	    System.out.print(temp.getData() + ", ");
	    
	    if(!temp.getLeft().isEmpty())
	      queue.offer(temp.getLeft());
	    if(!temp.getRight().isEmpty())
	      queue.offer(temp.getRight());
	  }
	}
	
	static void preOrder(BinaryTree<Integer> root)
	{
	  if(root == null || root.getData() == null)
	    return;
	  
	  System.out.print( root.getData() + ", ");
	  preOrder(root.getLeft());
	  preOrder(root.getRight());
	}

	static void postOrder(BinaryTree<Integer> root)
	{
	  if(root == null || root.getData() == null)
	    return;
	  
	  postOrder(root.getLeft());
	  postOrder(root.getRight());
	  System.out.print( root.getData() + ", ");
	}

	static void inOrder(BinaryTree<Integer> root)
	{
	  if(root == null || root.getData() == null)
	    return;
	  
	  inOrder(root.getLeft());
	  System.out.print( root.getData() + ", ");
	  inOrder(root.getRight());
	}
}