package scjp.com.java.algorithm.datastructures.maze.truecaller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PieceTour {
  private final Integer boardSize;
  private final boolean[][] isVisited;
  private Integer movesCount;

  public PieceTour(Integer boardSize) {
    this.boardSize = boardSize;
    this.isVisited = new boolean[boardSize][boardSize];
    this.movesCount = 0;
  }

  public List<Pair<Integer, Integer>> getTourRoute(Pair<Integer, Integer> pos) {
    final List<Pair<Integer, Integer>> tour = new ArrayList<>();
    tour.add(pos);
    isVisited[pos.getX()][pos.getY()] = true;
    movesCount++;

    final List<Pair<Integer, Integer>> validPositions = getValidMoves(pos);
    sortByNoOfNextAvailableMoves(validPositions);
    for (Pair<Integer, Integer> nextPos : validPositions) {
      final List<Pair<Integer, Integer>> visitedPath = getTourRoute(nextPos);
      if (areAllPositionsVisited()) {
        tour.addAll(visitedPath);
        break;
      } else {
        movesCount--;
        isVisited[nextPos.getX()][nextPos.getY()] = false;
      }
    }

    return tour;
  }

  private void sortByNoOfNextAvailableMoves(List<Pair<Integer, Integer>> positions) {
    positions.sort(Comparator.comparingInt(pos -> getValidMoves(pos).size()));
  }

  private boolean areAllPositionsVisited() {
    return movesCount == boardSize * boardSize;
  }

  private List<Pair<Integer, Integer>> getValidMoves(Pair<Integer, Integer> p) {
    return Stream.of(
            new Pair<>(p.getX() + 3, p.getY()),
            new Pair<>(p.getX() + 2, p.getY() - 2),
            new Pair<>(p.getX(), p.getY() - 3),
            new Pair<>(p.getX() - 2, p.getY() - 2),
            new Pair<>(p.getX() - 3, p.getY()),
            new Pair<>(p.getX() - 2, p.getY() + 2),
            new Pair<>(p.getX(), p.getY() + 3),
            new Pair<>(p.getX() + 2, p.getY() + 2)
    ).filter(this::isValidPosition).collect(Collectors.toList());
  }

  private boolean isValidPosition(Pair<Integer, Integer> pos) {
    return pos.getX() >= 0 && pos.getX() < boardSize &&
            pos.getY() >= 0 && pos.getY() < boardSize &&
            !isVisited[pos.getX()][pos.getY()];
  }
}
