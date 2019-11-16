package scjp.com.java.algorithm.companies.zapcom;

import java.util.*;

public class Solutions2 {
  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();
    list.addAll(Arrays.asList(new Integer[]{10, 20, 7}));
    int x = minSum(list, 4);
    System.out.println(x);

    System.out.println((int)Math.ceil(3.5));
  }

  public static int minSum(List<Integer> num, int k) {
    Collections.sort(num);
    for (int i = 0; i < k; i++) {
      int x = num.remove(num.size() - 1);
      x = (int) Math.ceil(((double)x) / 2);
      num.add(x);
      Collections.sort(num);
    }

    return num.stream().reduce(0, (acc, x) -> acc += x);
  }
}
