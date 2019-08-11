package scjp.com.java.algorithm.tree;

public class TreeEx {
  public static void main(String[] args) {
    Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6};
    BinaryTree<Integer> tree = new BinaryTree<>();
    tree.root = insertLevelOrder(arr, null, 0);
    System.out.println("Done");
  }

  static <T> Node<T> insertLevelOrder(T[] arr, Node root, int i) {
    if (i < arr.length) {
      root = new Node<>(arr[i]);

      root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
      root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
    }
    return root;
  }

  static class BinaryTree<T> {
    Node<T> root;
  }

  static class Node<T> {
    final T key;
    Node<T> left, right;

    public Node(T item) {
      this.key = item;
    }

    public T getKey() {
      return key;
    }

    public Node<T> getLeft() {
      return left;
    }

    public void setLeft(Node<T> left) {
      this.left = left;
    }

    public Node<T> getRight() {
      return right;
    }

    public void setRight(Node<T> right) {
      this.right = right;
    }
  }
}

