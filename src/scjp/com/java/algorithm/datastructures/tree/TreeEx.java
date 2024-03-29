package scjp.com.java.algorithm.datastructures.tree;

import org.jetbrains.annotations.NotNull;
import scjp.com.java.algorithm.datastructures.tree.avltree.AVLTree;
import scjp.com.java.algorithm.datastructures.tree.redblacktree.RedBlackTree;

import java.util.*;
import java.util.stream.Collectors;

public class TreeEx {
  public static void main(String[] args) {
        /*Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6};
        Node<Integer> root = insertLevelOrder(arr, 0);
        print(root);*/

        /*
        Integer arr2[] = {40, 35, 20, 10, 45, 50, 65, 60};
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        Arrays.stream(arr2).forEach(value -> tree.insert(value));
        print(tree.getRoot());*/
        /*System.out.println(tree.delete(35));
        print(tree.getRoot());*/

    Integer arr2[] = {40, 35, 20, 10, 5, 15, 45, 50};
    RedBlackTree<Integer> tree = new RedBlackTree<>();
    Arrays.stream(arr2).forEach(value -> tree.insert(value));
    print(tree.getRoot());

    Integer arr3[] = {40, 35, 20, 10, 45, 50, 65, 60, 80, 75, 70, 63, 85, 68, 95, 90};
    AVLTree<Integer> avlTree = new AVLTree<>();
    Arrays.stream(arr3).forEach(value -> avlTree.insert(value));
    print(avlTree.getRoot());
        /*avlTree.delete(75);
        print(avlTree.getRoot());*/
        /*mirrorTreeRecur(avlTree.getRoot());
        print(avlTree.getRoot());
        mirrorTreeLoop(avlTree.getRoot());
        print(avlTree.getRoot());
        */
    System.out.println("PostOrder");
    printPostOrder(avlTree.getRoot());
    System.out.println("\nInOrder");
    printInOrderRecur(avlTree.getRoot());
    System.out.println("\nPreOrder");
    printPreOrder(avlTree.getRoot());
    printLevelOrder(avlTree.getRoot());
    System.out.println();
    printLevelOrderInSpiralForm(avlTree.getRoot());
    System.out.println();
    printKDistanceFromNode(avlTree.findNode(75), 3);


    Node<Integer> node = buildTreeFromPostOrderAndInOrder(new Integer[]{10, 20, 40, 50, 45, 35, 63, 68, 70, 65, 80, 90, 95, 85, 75, 60},
            new Integer[]{10, 20, 35, 40, 45, 50, 60, 63, 65, 68, 70, 75, 80, 85, 90, 95});
    print(node);
  }

  static <T extends Comparable> void printKDistanceFromNode(Node<T> node, int distance) {
    Set<Node<T>> hashSet = new HashSet<>();
    hashSet.add(null); // just to avoid null check at the leaf nodes / empty left / right node.
    hashSet.add(node);

    Queue<Node<T>> queue = new LinkedList<>();
    queue.offer(node);
    while (distance > 0) {
      Queue<Node<T>> nextLevelQueue = new LinkedList<>();
      while (!queue.isEmpty()) {
        node = queue.poll();
        if (hashSet.add(node.getParent())) { // If not present in Hash Table then add to the queue. Otherwise already computed.
          nextLevelQueue.add(node.getParent());
        }
        if (hashSet.add(node.getRight())) {
          nextLevelQueue.add(node.getRight());
        }
        if (hashSet.add(node.getLeft())) {
          nextLevelQueue.add(node.getLeft());
        }
      }
      queue = nextLevelQueue;
      distance--;
    }
    System.out.println(queue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    hashSet.remove(null);
    System.out.println("All the nodes under the distance radius:- ");
    System.out.println(hashSet.stream().map(String::valueOf).collect(Collectors.joining(", ")));
  }

  static <T extends Comparable> Node<T> insertLevelOrder(T[] arr, int i) {
    Node<T> node = null;
    if (i < arr.length) {
      node = new Node<>(arr[i]);

      node.left = insertLevelOrder(arr, 2 * i + 1);
      node.right = insertLevelOrder(arr, 2 * i + 2);
    }
    return node;
  }

  static <T extends Comparable> void printLevelOrder(Node<T> node) {
    Queue<Node<T>> queue = new LinkedList<>();
    queue.offer(node);

    while (!queue.isEmpty()) {
      Node<T> curr = queue.poll();

      System.out.print(curr.getValue() + "  ");
      if (curr.getLeft() != null) {
        queue.offer(curr.getLeft());
      }
      if (curr.getRight() != null) {
        queue.offer(curr.getRight());
      }
    }
  }

  static <T extends Comparable> void printLevelOrderInSpiralForm(Node<T> node) {
    Stack<Node<T>> stack1 = new Stack<>();
    stack1.push(node);
    Stack<Node<T>> stack2 = new Stack<>();

    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        Node<T> n = stack1.pop();

        System.out.print(n.getValue() + "  ");
        if (n.getRight() != null) {
          stack2.push(n.getRight());
        }
        if (n.getLeft() != null) {
          stack2.push(n.getLeft());
        }
      }

      while (!stack2.isEmpty()) {
        Node<T> n = stack2.pop();

        System.out.print(n.getValue() + "  ");
        if (n.getLeft() != null) {
          stack1.push(n.getLeft());
        }
        if (n.getRight() != null) {
          stack1.push(n.getRight());
        }
      }
    }
  }

  static <T extends Comparable> void printInOrderRecur(Node<T> node) {
    if (node == null) {
      return;
    }
    printInOrderRecur(node.getLeft());
    System.out.print(node.getValue() + "  ");
    printInOrderRecur(node.getRight());
  }

  /*
  PostOrder
  10  20  40  50  45  35  63  68  70  65  80  90  95  85  75  60
  InOrder
  10  20  35  40  45  50  60  63  65  68  70  75  80  85  90  95
  */
  static <T extends Comparable> Node<T> buildTreeFromPostOrderAndInOrder(T[] postOrder, T[] inOrder) {
    int n = postOrder.length;
    Index pIndex = new Index(n - 1);
    return buildTreeUtil(inOrder, postOrder, 0, n - 1, pIndex);
  }

  static <T extends Comparable> Node<T> buildTreeUtil(T[] in, T[] post, int iStart, int iEnd, Index pIndex) {
    if (iStart > iEnd) {
      return null;
    }

    Node<T> node = new Node<>(post[pIndex.index]);
    pIndex.index--;

    if (iStart != iEnd) {
      int iIndex = findIndex(in, iStart, iEnd, node);
      node.right = buildTreeUtil(in, post, iIndex + 1, iEnd, pIndex);
      node.left = buildTreeUtil(in, post, iStart, iIndex - 1, pIndex);
    }
    return node;
  }

  @NotNull
  static <T extends Comparable> Integer findIndex(T[] arr, int start, int end, Node<T> node) {
    for (int i = start; i <= end; i++) {
      if (node.getValue() == arr[i]) {
        return i;
      }
    }
    return 0;
  }

  // Index class is for pass by reference of Index.
  static class Index {
    int index;

    public Index(int index) {
      this.index = index;
    }
  }

  static <T extends Comparable> void printInOrderLoop(Node<T> node) {
    Stack<Node<T>> stack = new Stack<>();

    while (node != null || !stack.isEmpty()) {
      // Put the nodes's left subtree in the stack
      while (node != null) {
        stack.push(node);
        node = node.getLeft();
      }

      node = stack.pop();
      System.out.print(node.getValue() + "  ");
      // After printing visit right subtree
      node = node.getRight();
    }

  }

  static <T extends Comparable> void printPreOrder(Node<T> node) {
    if (node == null) {
      return;
    }
    System.out.print(node.getValue() + "  ");
    printPreOrder(node.getLeft());
    printPreOrder(node.getRight());
  }

  static <T extends Comparable> void printPostOrder(Node<T> node) {
    if (node == null) {
      return;
    }
    printPostOrder(node.getLeft());
    printPostOrder(node.getRight());
    System.out.print(node.getValue() + "  ");
  }

  static <T extends Comparable> void mirrorTreeRecur(Node<T> node) {
    if (node != null) {
      mirrorTreeRecur(node.getLeft());
      mirrorTreeRecur(node.getRight());

      Node<T> temp = node.getLeft();
      node.setLeft(node.getRight());
      node.setRight(temp);
    }
  }

  static <T extends Comparable> void mirrorTreeLoop(Node<T> root) {
    if (root == null) {
      return;
    }

    Queue<Node<T>> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node<T> curr = queue.poll();

      if (curr.getLeft() != null) {
        queue.offer(curr.getLeft());
      }
      if (curr.getRight() != null) {
        queue.offer(curr.getRight());
      }

      Node temp = curr.getLeft();
      curr.setLeft(curr.getRight());
      curr.setRight(temp);
    }
  }

  public boolean isSymmetric(Node node) {
    return isMirror(node, node);
  }

  private boolean isMirror(Node node1, Node node2) {
    if (node1 == null && node2 == null) {
      return true;
    } else if (node1 != null && node2 != null && node1.getValue() == node2.getValue()) {
      return isMirror(node1.getLeft(), node2.getRight()) && isMirror(node1.getRight(), node2.getLeft());
    } else {
      return false;
    }
  }

  public static <T extends Comparable<T>> void print(Node<T> root) {
    List<List<String>> lines = new ArrayList<>();

    List<Node<T>> level = new ArrayList<>();
    List<Node<T>> next = new ArrayList<>();

    level.add(root);
    int nn = 1;

    int widest = 0;

    while (nn != 0) {
      List<String> line = new ArrayList<String>();

      nn = 0;

      for (Node n : level) {
        if (n == null || n.toString() == null) {
          line.add(null);

          next.add(null);
          next.add(null);
        } else {
          String aa = n.toString();
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

      List<Node<T>> tmp = level;
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