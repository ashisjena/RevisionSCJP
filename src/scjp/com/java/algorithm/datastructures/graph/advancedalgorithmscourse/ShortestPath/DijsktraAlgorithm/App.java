package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.ShortestPath.DijsktraAlgorithm;

import java.util.Stack;

public class App {
  public static void main(String[] args) {
    Vertex<String> vertex0 = new Vertex<>("A");
    Vertex<String> vertex1 = new Vertex<>("B");
    Vertex<String> vertex2 = new Vertex<>("C");

    vertex0.addNeighbour(new Edge<>(1, vertex0, vertex1));
    vertex0.addNeighbour(new Edge<>(10, vertex0, vertex2));
    vertex1.addNeighbour(new Edge<>(1, vertex1, vertex2));

    DijsktraAlgorithm algorithm = new DijsktraAlgorithm();
    algorithm.computePaths(vertex0);

    Stack<Vertex<String>> shortestPath = algorithm.getShortestPathTo(vertex2);

    while (!shortestPath.isEmpty()) {
      System.out.print(shortestPath.pop() + ", ");
    }
  }
}
