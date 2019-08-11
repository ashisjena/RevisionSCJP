package scjp.com.java.algorithm.stack;

import java.util.Stack;

public class ReverseStackUsingPushPop {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 1; i < 5; i++)
      stack.push(i);

    reverseStackRecur(stack);

    while (!stack.isEmpty())
      System.out.println(stack.pop());
  }

  private static <T extends Number> void reverseStackRecur(Stack<T> stack) {
    if (stack.empty()) {
      return;
    }
    T tempValue = stack.pop();
    reverseStackRecur(stack);
    insertAtBottomRecur(stack, tempValue);
  }

  private static <T extends Number> void insertAtBottomRecur(Stack<T> stack, T value) {
    if (stack.isEmpty()) {
      stack.push(value);
      return;
    }

    T tempValue = stack.pop();
    insertAtBottomRecur(stack, value);
    stack.push(tempValue);
  }
}