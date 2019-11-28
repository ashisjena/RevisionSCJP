package scjp.com.java.algorithm.datastructures.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
  There are Strings.. ex "A", "B", "C", "D"

  you can have methods like
  "touchAndIncrease", it will increase the value. from n -> n+1
  "touchAndDecrease", it will decrease the value from n -> n-1
  "getMaximumTouched", it will return the item with max value
  "getMinimumTouched", it will return the item with min value

  Give the solution for all the methods, so that any give point of time the complexity should be O(1)
  initially all the values for the keys are 1.
 */
public class MinStackMaxStack_TODO {
  private Map<String, Integer> map = new HashMap<>();
  private Stack<Node> maxStack = new Stack<>();
  private Stack<Node> minStack = new Stack<>();

  public void touchAndIncrease(String key) {
    Integer count = map.get(key);

    if (count == null) {
      count = 0;
    }
    map.put(key, count + 1);

    if (maxStack.isEmpty()) {
      maxStack.push(new Node(key, count + 1));
    } else if(maxStack.peek().key.equals(key)) {
      maxStack.peek().count = count + 1;
    } else if(maxStack.peek().count <= count + 1) {
      maxStack.push(new Node(key, count + 1));
    }

    if (!minStack.isEmpty() && minStack.peek().key.equals(key)) {
      minStack.pop();
    }
    if (minStack.isEmpty() || minStack.peek().count >= count + 1) {
      minStack.push((new Node(key, count + 1)));
    }
  }

  public void touchAndDecrease(String key) {
    Integer count = map.get(key);

    if (count != null) {
      map.put(key, count - 1);

      if (minStack.isEmpty() || minStack.peek().count >= count - 1) {
        minStack.push(new Node(key, count - 1));
      }
      if (!maxStack.isEmpty() || maxStack.peek().key.equals(key)) {
        maxStack.pop();
      }
      if (maxStack.isEmpty() || maxStack.peek().count <= count - 1) {
        maxStack.push(new Node(key, count - 1));
      }
    }

  }

  public Node getMaxNode() {
    return maxStack.isEmpty() ? null : this.maxStack.peek();
  }

  public Node getMinNode() {
    return minStack.isEmpty() ? null : this.minStack.peek();
  }

  class Node {
    private Integer count;
    private String key;

    Node(String key, Integer count) {
      this.key = key;
      this.count = count;
    }

    @Override
    public String toString() {
      return this.key + ", " + this.count;
    }
  }

  public static void main(String[] args) {
    MinStackMaxStack_TODO obj = new MinStackMaxStack_TODO();

    obj.touchAndIncrease("Ram");
    obj.touchAndIncrease("Sita");
    obj.touchAndIncrease("Hari");
    obj.touchAndIncrease("Shyam");
    obj.touchAndIncrease("Hari");
    obj.touchAndIncrease("Hari");
    obj.touchAndIncrease("Hari");
    obj.touchAndIncrease("Sita");
    obj.touchAndIncrease("Sita");

    System.out.println(obj.getMaxNode());
    System.out.println(obj.getMinNode());

    obj.touchAndDecrease("Hari");
    obj.touchAndDecrease("Hari");
    System.out.println(obj.getMaxNode());
    System.out.println(obj.getMinNode());
  }

}
