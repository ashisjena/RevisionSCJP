package scjp.com.java.algorithm.linkedlist;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SingleLinkedListEx {
  public static void main(String[] args) {
    Node<String> head = Node.toLinkedList(new String[]{"Ram", "Sita", "Laxman", "Ravan", "Hanuman", "Dasharath"});

    Node.print(head);
    Node.printReverse(head);
    System.out.println("=============================");
    System.out.println(Node.findNthElementFromEnd(head, 4));
    System.out.println("=============================");
    head = Node.reverseLinkedListRec(head, null);
    Node.print(head);
    System.out.println("=============================");
    head = Node.reverseLinkedList(head);
    Node.print(head);
    System.out.println("=============================");
    head = Node.reverseLinkedListInPairRec(head);
    Node.print(head);
    System.out.println("=============================");
    head = Node.reverseLinkedListInPair(head);
    Node.print(head);
    System.out.println("=============================");

    Node<String> cyclicLinkedList = Node
        .toCyclicLinkedList(new String[]{"Ram", "Sita", "Laxman", "Ravan", "Hanuman", "Dasharath", "Kaikeyee"});
    System.out.println("Is Cyclic : " + Node.isCyclic(cyclicLinkedList));
    Node<String>[] resultArr = Node.splitCyclicLinkedList(cyclicLinkedList);
    Node.print(resultArr[0]);
    System.out.println("---------------------------------");
    Node.print(resultArr[1]);

    System.out.println("=============================");
    Node<Integer> list1 = Node.toLinkedList(new Integer[]{1, 3, 5, 8, 19});
    Node<Integer> list2 = Node.toLinkedList(new Integer[]{2, 6, 7, 8, 9, 10});

    Node.print(Node.mergeSortedLinkedListRec(list1, list2));
//    Node.print(Node.mergeSortedLinkedList(list1, list2, Comparator.naturalOrder()));
  }
}

class Node<E> {
  private Node<E> next;
  private E value;

  public Node(E value) {
    this.value = value;
  }

  public Node<E> insert(E value) {
    return this.next = new Node<>(value);
  }

  public void setValue(E value) {
    this.value = value;
  }

  public E getValue() {
    return this.value;
  }

  public void setNext(Node<E> next) {
    this.next = next;
  }

  public Node<E> getNext() {
    return this.next;
  }

  @Override
  public String toString() {
    return this.value.toString();
  }

  public static <T> Node<T> toLinkedList(T[] values) {
    Node<T> head = new Node<>(values[0]);
    Node<T> finger = head;

    for (T value : Stream.of(values)
                         .skip(1)
                         .collect(Collectors.toList())) {
      finger = finger.insert(value);
    }
    return head;
  }

  public static <T> Node<T> toCyclicLinkedList(T[] values) {
    Node<T> head = new Node<>(values[0]);
    Node<T> finger = head;

    for (T value : Stream.of(values)
                         .skip(1)
                         .collect(Collectors.toList())) {
      finger = finger.insert(value);
    }
    finger.setNext(head);
    return head;
  }

  public static <T> void print(Node<T> linkedList) {
    for (; linkedList != null; linkedList = linkedList.getNext()) {
      System.out.println(linkedList.getValue());
    }
  }

  public static <T> void printReverse(Node<T> linkedList) {
    if (linkedList == null) {
      return;
    }
    printReverse(linkedList.getNext());
    System.out.println(linkedList.getValue());
  }

  public static <T> Node<T> findNthElementFromEnd(Node<T> head, int n) {
    Node<T> finger1 = head;
    Node<T> finger2 = head;
    for (; n > 0; n--, finger1 = finger1.getNext()) ;
    for (; finger1 != null; finger1 = finger1.getNext(), finger2 = finger2.getNext()) ;
    return finger2;
  }

  public static <T> Node<T> reverseLinkedListRec(Node<T> current, Node<T> reversedPart) {
    Node<T> next = current.getNext();
    current.setNext(reversedPart);
    reversedPart = current;

    if (next == null) {
      return reversedPart;
    }
    return reverseLinkedListRec(next, reversedPart);
  }

  public static <T> Node<T> reverseLinkedList(Node<T> current) {
    Node<T> reversedPart = null;
    while (current != null) {
      Node<T> next = current.getNext();
      current.setNext(reversedPart);
      reversedPart = current;
      current = next;
    }
    return reversedPart;
  }

  public static <T> Node<T> reverseLinkedListInPairRec(Node<T> head) {
    if (head == null || head.getNext() == null) {
      return head;
    }

    Node<T> newHead = head.getNext();
    Node<T> remaining = newHead.getNext();
    newHead.setNext(head);
    head.setNext(reverseLinkedListInPairRec(remaining));

    return newHead;
  }

  public static <T> Node<T> reverseLinkedListInPair(Node<T> node) {
    if (node == null || node.getNext() == null) {
      return node;
    }
    Node<T> newHead = node.getNext();

    while (true) {
      Node<T> next = node.getNext();
      Node<T> remaining = next.getNext();
      next.setNext(node);
      if (remaining == null || remaining.getNext() == null) {
        node.setNext(remaining);
        break;
      }
      node.setNext(remaining.getNext());
      node = remaining;
    }
    return newHead;
  }

  public static <T> boolean isCyclic(Node<T> insertionNode) {
    if (insertionNode == null || insertionNode.getNext() == null) {
      return false;
    }

    boolean isCyclic = false;
    Node<T> slowPointer = insertionNode;
    Node<T> fastPointer = insertionNode;

    while (fastPointer != null && fastPointer.getNext() != null) {
      slowPointer = slowPointer.getNext();
      fastPointer = fastPointer.getNext()
                               .getNext();
      if (slowPointer == fastPointer) {
        isCyclic = true;
        break;
      }
    }
    return isCyclic;
  }

  public static <T extends Comparable> Node<T> mergeSortedLinkedListRec(Node<T> list1, Node<T> list2) {
    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    }

    Node<T> result;
    if (list1.getValue()
             .compareTo(list2.getValue()) < 0) {
      result = list1;
      result.setNext(mergeSortedLinkedListRec(list1.getNext(), list2));
    } else {
      result = list2;
      result.setNext(mergeSortedLinkedListRec(list1, list2.getNext()));
    }
    return result;
  }

  public static <T> Node<T> mergeSortedLinkedList(Node<T> list1, Node<T> list2, Comparator<T> comparator) {
    Node<T> head = comparator.compare(list1.getValue(), list2.getValue()) < 0 ? list1 : list2;
    if (list1 == head) {
      list1 = list1.getNext();
    } else {
      list2 = list2.getNext();
    }

    Node<T> finger = head;
    while (list1 != null || list2 != null) {
      if (list1 == null) {
        finger.setNext(list2);
        break;
      } else if (list2 == null) {
        finger.setNext(list1);
        break;
      }

      if (comparator.compare(list1.getValue(), list2.getValue()) < 0) {
        finger.setNext(list1);
        finger = list1;
        list1 = list1.getNext();
      } else {
        finger.setNext(list2);
        finger = list2;
        list2 = list2.getNext();
      }
    }
    return head;
  }

  public static <T> Node<T>[] splitCyclicLinkedList(Node<T> head) {
    Node<T>[] result = new Node[2];
    if (!isCyclic(head)) {
      return result;
    }
    Node<T> turtle = head.getNext();
    Node<T> hare = head.getNext()
                       .getNext();

    Node<T> turtlePrev = null, harePrev = null;
    while (hare != head) {
      turtlePrev = turtle;
      turtle = turtle.getNext();
      harePrev = hare.getNext();
      hare = hare.getNext()
                 .getNext();
    }
    if (turtle == hare) {
      return result; // If Odd number length
    }

    turtlePrev.setNext(null);
    harePrev.setNext(null);
    result[0] = head;
    result[1] = turtle;
    return result;
  }
}

