package scjp.com.java.algorithm.datastructures.heap;

/*
Array = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17}

Corresponding Complete Binary Tree is:
                 1
              /     \
            3         5
         /    \     /  \
        4      6   13  10
       / \    / \
      9   8  15 17
 */

import scjp.com.java.algorithm.datastructures.tree.Node;
import scjp.com.java.algorithm.datastructures.tree.TreeEx;

import java.util.LinkedList;
import java.util.Queue;

public class Heap {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
    Node<Integer> head = createHeapFromArray(arr);
    TreeEx.print(head);
    System.out.println();
    head = buildMaxHeap(arr);
    TreeEx.print(head);

    int[] intArr = new int[]{3, 2, 1, 7, 8, 4, 10, 16, 12};
    Node<Integer> minHeap = buildMinHeap(arr);
    TreeEx.print(minHeap);
  }

  static Node<Integer> createHeapFromArray(int[] arr) {
    Node<Integer> head = new Node<>(arr[0]);
    Queue<Node<Integer>> queue = new LinkedList<>();
    queue.add(head);
    int i = 1;
    while (!queue.isEmpty() && i < arr.length) {
      Node<Integer> node = queue.poll();
      node.setLeft(new Node<>(arr[i]));
      i++;
      if (i < arr.length) {
        node.setRight(new Node<>(arr[i]));
        i++;
      }
      queue.offer(node.getLeft());
      queue.offer(node.getRight());
    }
    return head;
  }

  // Complexity O(N*logN)
  static Node<Integer> buildMaxHeap(int[] arr) {
    // {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17}
    // Total Nodes = 11
    // Last Non-leaf node Index = (11 / 2) - 1 = 4. (n/2)-1
    // i.e To build the heap, heapify only the nodes {1, 3, 4, 5, 6}

    int startIndx = arr.length / 2 - 1;

    for (int i = startIndx; i >= 0; i--) {
      heapify(arr, i);
    }

    return createHeapFromArray(arr);
  }

  static Node<Integer> buildMinHeap(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      bubbleUp(arr, i);
    }
    return createHeapFromArray(arr);
  }

  private static void bubbleUp(int[] arr, int pos) {
    int parentIdx = pos / 2;
    int currentIdx = pos;
    while (currentIdx > 0 && arr[parentIdx] > arr[currentIdx]) {
      swap(arr, parentIdx, currentIdx);
      currentIdx = parentIdx;
      parentIdx = parentIdx / 2;
    }
  }

  private static void heapify(int[] arr, int i) {
    int largest = i; // Initialize largest as root
    int left = 2 * i + 1; // left = 2 * i + 1
    int right = 2 * i + 2; // right = 2 * i + 2

    // If left child is larger than root
    if (left < arr.length && arr[left] > arr[largest]) {
      largest = left;
    }
    // If right child is larger than root
    if (right < arr.length && arr[right] > arr[largest]) {
      largest = right;
    }
    // If largest is not root
    if (largest != i) {
      swap(arr, i, largest);

      heapify(arr, largest);
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int swap = arr[i];
    arr[i] = arr[j];
    arr[j] = swap;
  }

}
