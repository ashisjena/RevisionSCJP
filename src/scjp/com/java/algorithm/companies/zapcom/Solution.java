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
    int maxResult = 0;

    for (int i = 0; i < arr.size(); i++) {
      for (int j = 0; j < arr.size(); j++) {
        if (isPositionZero(arr, i, j)) {
          continue;
        }

        int resultForCurrPos = resultForCurrPosition(arr, i, j);

        if (maxResult < resultForCurrPos) {
          maxResult = resultForCurrPos;
        }
      }
    }

    return maxResult;
  }

  private static int resultForCurrPosition(List<List<Integer>> arr, int i, int j) {
    int result = 1;
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(i, j));

    outer:
    while (!queue.isEmpty()) {
      LinkedHashSet<Pair> uniquePairs = new LinkedHashSet<>();
      while (!queue.isEmpty()) {
        Pair pair = queue.poll();
        List<Pair> adjPairs = getAdjacentValues(pair, arr.size());

        if (areValidPositions(arr, adjPairs)) {
          uniquePairs.addAll(adjPairs);
        } else {
          break outer;
        }
      }
      queue.addAll(uniquePairs);
      result++;
    }
    return result;
  }

  private static boolean areValidPositions(List<List<Integer>> orgArr, List<Pair> adjPairs) {
    boolean hasZeros = adjPairs.stream().anyMatch(p -> isPositionZero(orgArr, p.x, p.y));
    return adjPairs.size() == 3 && !hasZeros;
  }

  private static boolean isPositionZero(List<List<Integer>> arr, int i, int j) {
    return arr.get(i).get(j) == 0;
  }

  private static List<Pair> getAdjacentValues(Pair pair, int matrixSize) {
    List<Pair> list = new ArrayList<>();

    if (pair.x + 1 < matrixSize) {
      list.add(new Pair(pair.x + 1, pair.y));
    }
    if (pair.y + 1 < matrixSize) {
      list.add(new Pair(pair.x, pair.y + 1));
    }
    if (pair.x + 1 < matrixSize && pair.y + 1 < matrixSize) {
      list.add(new Pair(pair.x + 1, pair.y + 1));
    }

    return list;
  }

  static class Pair {
    int x, y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

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
  }
}
