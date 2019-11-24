package scjp.com.java.algorithm.companies.truecaller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PieceTour {
  private final Integer boardSize;
  private final boolean[][] isVisited;

  public PieceTour(Integer boardSize) {
    this.boardSize = boardSize;
    this.isVisited = new boolean[boardSize][boardSize];
  }

  public List<Pair<Integer, Integer>> pieceTour(Pair<Integer, Integer> pos) {
    final List<Pair<Integer, Integer>> tour = new ArrayList<>();
    isVisited[pos.getX()][pos.getY()] = true;
    tour.add(pos);
    getValidMoves(pos).
            stream().
            filter(p -> !isVisited[p.getX()][p.getY()]).
            findFirst().
            ifPresent(p -> tour.addAll(pieceTour(p)));
    return tour;
  }

  private List<Pair<Integer, Integer>> getValidMoves(Pair<Integer, Integer> p) {
    return Stream.of(
            new Pair<>(p.getX() + 3, p.getY()),
            new Pair<>(p.getX(), p.getY() + 3),
            new Pair<>(p.getX() - 3, p.getY()),
            new Pair<>(p.getX(), p.getY() - 3),
            new Pair<>(p.getX() + 2, p.getY() + 2),
            new Pair<>(p.getX() + 2, p.getY() - 2),
            new Pair<>(p.getX() - 2, p.getY() + 2),
            new Pair<>(p.getX() - 2, p.getX() - 2)
    ).filter(this::isValidPosition).collect(Collectors.toList());
  }

  private boolean isValidPosition(Pair<Integer, Integer> pos) {
    return pos.getX() >= 0 && pos.getX() < boardSize && pos.getY() >= 0 && pos.getY() < boardSize;
  }
}
