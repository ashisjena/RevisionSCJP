package scjp.com.java.algorithm.companies.truecaller;

import scjp.com.java.algorithm.dynamicProgramming.PrintMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PieceTour {
  private final Integer boardSize;

  public PieceTour(Integer boardSize) {
    this.boardSize = boardSize;

  }

  public List<Pair<Integer, Integer>> pieceTour(Pair<Integer, Integer> pos, boolean[][] isVisited) {
    final List<Pair<Integer, Integer>> tour = new ArrayList<>();
    isVisited[pos.getX()][pos.getY()] = true;
    tour.add(pos);

    if (isAllCellsVisited(isVisited)) {
      return tour;
    }

    for (Pair<Integer, Integer> pair : getValidMoves(pos, isVisited)) {
      List<Pair<Integer, Integer>> visitedPath = pieceTour(pair, isVisited);
      if (isAllCellsVisited(isVisited)) {
        tour.addAll(visitedPath);
        break;
      } else {
        isVisited[pair.getX()][pair.getY()] = false;
      }
    }

    return tour;
  }

  private boolean isAllCellsVisited(boolean[][] isVisited) {
    return Arrays.stream(isVisited).
        flatMap(arr -> IntStream.range(0, arr.length)
                                .mapToObj(idx -> arr[idx])
        ).reduce(true, (acc, ele) -> acc && ele);
  }

  public static boolean[][] cloneArray(Boolean[][] src) {
    int length = src.length;
    boolean[][] target = new boolean[length][src[0].length];
    for (int i = 0; i < length; i++) {
      System.arraycopy(src[i], 0, target[i], 0, src[i].length);
    }
    return target;
  }

  private List<Pair<Integer, Integer>> getValidMoves(Pair<Integer, Integer> p, boolean[][] isVisited) {
    return Stream.of(
        new Pair<>(p.getX() + 3, p.getY()),
        new Pair<>(p.getX(), p.getY() + 3),
        new Pair<>(p.getX() - 3, p.getY()),
        new Pair<>(p.getX(), p.getY() - 3),
        new Pair<>(p.getX() + 2, p.getY() + 2),
        new Pair<>(p.getX() + 2, p.getY() - 2),
        new Pair<>(p.getX() - 2, p.getY() + 2),
        new Pair<>(p.getX() - 2, p.getX() - 2)
    ).filter(pos -> isValidPosition(pos, isVisited)).collect(Collectors.toList());
  }

  private boolean isValidPosition(Pair<Integer, Integer> pos, boolean[][] isVisited) {
    return pos.getX() >= 0 && pos.getX() < boardSize &&
        pos.getY() >= 0 && pos.getY() < boardSize &&
        !isVisited[pos.getX()][pos.getY()];
  }
}
