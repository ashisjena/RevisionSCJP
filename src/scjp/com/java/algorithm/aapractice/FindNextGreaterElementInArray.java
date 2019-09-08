package scjp.com.java.algorithm.aapractice;

import java.util.Stack;

public class FindNextGreaterElementInArray {

  public static void main(String[] args) {
    int arr1[] = {4, 5, 2, 25};
    int arr2[] = {13, 7, 6, 12};

    printNGE(arr1, new Stack<Integer>());
    System.out.println();
    printNGE(arr2, new Stack<Integer>());
  }

  static void printNGE(int arr[], Stack<Integer> stack) {
    int element, next;

    /* push the first element to stack */
    stack.push(arr[0]);

    // iterate for rest of the elements
    for (int i = 1; i < arr.length; i++) {

      next = arr[i];

      if (!stack.isEmpty()) {
        // if stack is not empty, then pop an element from stack
        element = stack.pop();

        /*
         * If the popped element is smaller than next, then a) print the pair b) keep popping while
         * elements are smaller and stack is not empty
         */
        while (element < next) {
          System.out.println(element + "------>" + next);
          if (stack.isEmpty())
            break;
          element = stack.pop();
        }

        /*
         * If element is greater than next, then push the element back
         */
        if (element > next)
          stack.push(element);
      }

      /*
       * push next to stack so that we can find next greater for it
       */
      stack.push(next);
    }

    /*
     * After iterating over the loop, the remaining elements in stack do not have the next greater
     * element, so print -1 for them
     */
    while (!stack.isEmpty()) {
      element = stack.pop();
      next = -1;
      System.out.println(element + "----->" + next);
    }
  }
}
