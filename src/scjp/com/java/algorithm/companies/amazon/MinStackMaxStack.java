package scjp.com.java.algorithm.companies.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinStackMaxStack {
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
    MinStackMaxStack obj = new MinStackMaxStack();

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
