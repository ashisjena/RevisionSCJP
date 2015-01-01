package scjp.com.java.algorithm.tree;

public class TreeTest
{
	public static void main( String[] args )
	{
		BinaryTree<Integer> root = BinaryTree.formBinaryTree( 10 );
		System.out.println(root.size());
	}
}