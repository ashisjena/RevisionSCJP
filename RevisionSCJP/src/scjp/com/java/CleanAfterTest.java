package scjp.com.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import scjp.com.java.algorithm.tree.Tree;


public class CleanAfterTest {

  public static void main(String[] args) throws InterruptedException {

    int[] arr = new int[] {20, 15, 25, 4, 5, 6, 11, 17, 2, 12, 13, 14, 1, 19,8,9};
    Arrays.sort(arr);
    Tree<Integer> root = Tree.sortedArrayToBST(arr, 0, arr.length - 1);
    Tree.print(root);

  }

  static int method(Tree<Integer> root, Tree<Integer> target, int dist) {
    
    if(root.getData() == null)
      return -1;
    
    if(root.getData() ==  target.getData())
    {
      findAllChildNodesWithDistance(root, dist);
      return 0;
    }
    
    int dl = method(root.getLeft(), target, dist);
    
    if(dl != -1)
    {
      if(dl + 1 == dist)
        System.out.println(root.getData());
      else
        method(root.getRight(), target, dist - 2 - dl);
      
      return dl + 1;
    }
    
    dl = method(root.getRight(), target, dist);
    if(dl != -1)
    {
      if(dl + 1 == dist)
        System.out.println(root.getData());
      else
        method(root.getLeft(), target, dist - 2 - dl);
    
    return dl + 1;
      
    }
    
    return -1;
  }

  private static void findAllChildNodesWithDistance(Tree<Integer> root, int dist) {

    if(dist == 0 || root.getData() == null)
    {
      System.out.println(root.getData());
      return;
    }
    
    findAllChildNodesWithDistance(root.getLeft(), dist - 1);
    findAllChildNodesWithDistance(root.getRight(), dist - 1);
  }
}
