package scjp.com.java.algorithm.tree;

import java.util.Arrays;

public class FindNodesAtKdistance {
  public static void main(String[] args) {
    int[] arr = new int[] {20, 15, 25, 4, 5, 6, 11, 17, 2, 12, 13, 14, 1, 19};
    Arrays.sort(arr);
    Tree<Integer> root = Tree.sortedArrayToBST(arr, 0, arr.length - 1);
    Tree.print(root);
    printkdistanceNode(root, new Tree<Integer>(5), 2);
  }
   
  // Prints all nodes at distance k from a given target node.
  // The k distant nodes may be upward or downward.  This function
  // Returns distance of root from target node, it returns -1 if target
  // node is not present in tree rooted with root.
  static int printkdistanceNode(Tree root, Tree target , int k)
  {
      // Base Case 1: If tree is empty, return -1
      if (root == null) return -1;
   
      // If target is same as root.  Use the downward function
      // to print all nodes at distance k in subtree rooted with
      // target or root
      if (root.getData() == target.getData())
      {
          printkdistanceNodeDown(root, k);
          return 0;
      }
   
      // Recur for left subtree
      int dl = printkdistanceNode(root.getLeft(), target, k);
   
      // Check if target node was found in left subtree
      if (dl != -1)
      {
           // If root is at distance k from target, print root
           // Note that dl is Distance of root's left child from target
           if (dl + 1 == k)
              System.out.println(root.getData());
   
           // Else go to right subtree and print all k-dl-2 distant nodes
           // Note that the right child is 2 edges away from left child
           else
              printkdistanceNodeDown(root.getRight(), k-dl-2);
   
           // Add 1 to the distance and return value for parent calls
           return 1 + dl;
      }
   
      // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
      // Note that we reach here only when node was not found in left subtree
      int dr = printkdistanceNode(root.getRight(), target, k);
      if (dr != -1)
      {
           if (dr + 1 == k)
              System.out.println(root.getData());
           else
              printkdistanceNodeDown(root.getLeft(), k-dr-2);
           return 1 + dr;
      }
   
      // If target was neither present in left nor in right subtree
      return -1;
  }
  
  static void printkdistanceNodeDown(Tree root, int k)
  {
      // Base Case
      if (root == null || k < 0)  return;
   
      // If we reach a k distant node, print it
      if (k==0)
      {
          System.out.println(root.getData());
          return;
      }
   
      // Recur for left and right subtrees
      printkdistanceNodeDown(root.getLeft(), k-1);
      printkdistanceNodeDown(root.getRight(), k-1);
  }
}
