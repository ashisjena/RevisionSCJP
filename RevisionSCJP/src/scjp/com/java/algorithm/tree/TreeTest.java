package scjp.com.java.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTest {
  public static void main(String[] args) {
    int[] arr = new int[] {20, 15, 25, 4, 5, 6, 11, 17, 2, 12, 13, 14, 1, 19};
    Arrays.sort(arr);
    Tree<Integer> root = Tree.sortedArrayToBST(arr, 0, arr.length - 1);
    System.out.println(root.size());
    Tree.print(root);

    System.out.println();
    //preOrder(root);
    System.out.println();
    //postOrder(root);
    System.out.println();
    //inOrder(root);
    System.out.println();
    //levelOrder(root);

    System.out.println();
    //mirrorOfTree(root);
    //BinaryTree.print(root);
  }

  static void mirrorOfTree(Tree<Integer> root) {
    if (!root.isEmpty()) {
      mirrorOfTree(root.getLeft());
      mirrorOfTree(root.getRight());

      Tree<Integer> temp = root.getLeft();
      root.setLeft(root.getRight());
      root.setRight(temp);
    }
  }

  static void levelOrder(Tree<Integer> root) {
    Queue<Tree<Integer>> queue = new LinkedList<>();
    Tree<Integer> temp;

    queue.offer(root);

    while (!queue.isEmpty()) {
      temp = queue.poll();

      System.out.print(temp.getData() + ", ");

      if (!temp.getLeft().isEmpty())
        queue.offer(temp.getLeft());
      if (!temp.getRight().isEmpty())
        queue.offer(temp.getRight());
    }
  }

  static void preOrder(Tree<Integer> root) {
    if (root == null || root.getData() == null)
      return;

    System.out.print(root.getData() + ", ");
    preOrder(root.getLeft());
    preOrder(root.getRight());
  }

  static void postOrder(Tree<Integer> root) {
    if (root == null || root.getData() == null)
      return;

    postOrder(root.getLeft());
    postOrder(root.getRight());
    System.out.print(root.getData() + ", ");
  }

  static void inOrder(Tree<Integer> root) {
    if (root == null || root.getData() == null)
      return;

    inOrder(root.getLeft());
    System.out.print(root.getData() + ", ");
    inOrder(root.getRight());
  }
  
  static boolean isNodePresent(Tree<Integer> root, int data) {
    if (root.getData() == null)
      return false;
    else 
    {
      if (root.getData() == data)
        return true;
      else
      {
        if(isNodePresent(root.getLeft(), data))
          return true;
        else
          return isNodePresent(root.getRight(), data);
      }
    }
  }
}
