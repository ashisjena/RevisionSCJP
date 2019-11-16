package scjp.com.java.algorithm.companies.zapcom;

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    list.add(Arrays.asList(new Integer[]{0, 1, 1, 0, 1, 0, 1}));
    list.add(Arrays.asList(new Integer[]{1, 1, 0, 1, 0, 1, 0}));
    list.add(Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1, 1}));
    list.add(Arrays.asList(new Integer[]{1, 0, 1, 1, 1, 1, 1}));
    list.add(Arrays.asList(new Integer[]{1, 0, 1, 1, 1, 1, 1}));
    list.add(Arrays.asList(new Integer[]{1, 0, 1, 1, 1, 1, 1}));
    list.add(Arrays.asList(new Integer[]{1, 0, 1, 0, 1, 1, 1}));

    int result = largestMatrix(list);
    System.out.println(result);
  }

  public static int largestMatrix(List<List<Integer>> arr) {
    int result = 0;


    for (int i = 0; i < arr.size(); i++) {
      for (int j = 0; j < arr.size(); j++) {
        if (arr.get(i).get(j) == 0) {
          continue;
        }

        int innerResult = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        while (!queue.isEmpty()) {
          LinkedHashSet<Pair> set = new LinkedHashSet<>();
          while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            List<Pair> adjPairs = getAdjacentValues(pair, arr.size());

            if (adjPairs.size() == 3) {
              boolean hasZeros = adjPairs.stream().anyMatch(p -> arr.get(p.x).get(p.y) == 0);
              if (!hasZeros) {
                set.addAll(adjPairs);
              }
            }
          }
          int k = 0;
          for (int x = 0; x <= innerResult + 1; x++) {
            k += x;
          }

          if (set.size() == k) {
            queue.addAll(set);
            innerResult++;
          }
        }

        if (result < innerResult) {
          result = innerResult;
        }
      }
    }


    return result;

  }

  static List<Pair> getAdjacentValues(Pair pair, int n) {
    List<Pair> list = new ArrayList<>();

    if (pair.x + 1 < n) {
      list.add(new Pair(pair.x + 1, pair.y));
    }
    if (pair.y + 1 < n) {
      list.add(new Pair(pair.x, pair.y + 1));
    }
    if (pair.x + 1 < n && pair.y + 1 < n) {
      list.add(new Pair(pair.x + 1, pair.y + 1));
    }

    return list;
  }

  static class Pair {
    int x, y;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Pair)) return false;
      Pair pair = (Pair) o;
      return x == pair.x &&
              y == pair.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

}
