package scjp.com.java.companies.techgig;

import java.util.Stack;

/*
 *  A --> And
 *  N --> Not
 *  I --> Implies
 *  F --> If And Only If
 *  O --> Or
 *  
 *  Ex : 
 *  !(!p&p) ---> NANpp
 *  
 *  for p == true or p == false
 *  the result must be true. (Tautology)
 */

public class TautologyProblem {
  public static void main(String[] args) {

    String exp = "NANpp";
    System.out.println(iteration(exp));

  }

  public static String iteration(String input1) {
    String result1 = solveExpr(input1, true);
    String result2 = solveExpr(input1, false);

    if (result1.equals("Invalid") || result2.equals("Invalid"))
      return "Invalid";
    else if (result1.equals("true") && result2.equals("true"))
      return "Yes";
    else
      return "No";
  }

  private static String solveExpr(String exp, boolean valueOfP) {
    Stack<String> operators = new Stack<String>();
    Stack<Boolean> values = new Stack<Boolean>();
    String[] arr = exp.split("(?!^)");
    for (String s : arr) {
      if (s.matches("[AOIFN]"))
        operators.push(s);
      else if (s.matches("[pP]"))
        values.push(valueOfP);
      else
        return "Invalid";
    }
    while (!operators.isEmpty()) {
      if (operators.peek().matches("[AOIF]") && values.size() == 1)
        return "Invalid";
      calculate(operators, values);
    }
    return values.pop().toString();
  }

  private static void calculate(Stack<String> operators, Stack<Boolean> values) {
    if (operators.peek().equals("N")) {
      values.push(!values.pop());
      operators.pop();
      return;
    }

    boolean val1 = values.pop();
    boolean val2 = values.pop();

    switch (operators.pop()) {
      case "A":
        values.push(val1 && val2);
        break;
      case "O":
        values.push(val1 || val2);
        break;
      case "I":
        values.push(implies(val1, val2));
        break;
      case "F":
        values.push(ifAndOnlyIf(val1, val2));
    }
  }

  public static boolean implies(boolean val1, boolean val2) {
    return !val1 || val2;
  }

  public static boolean ifAndOnlyIf(boolean val1, boolean val2) {
    return val1 == val2;
  }

}
