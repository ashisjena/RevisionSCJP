package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.ShortestPath.DijsktraAlgorithm;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> implements Comparable<Vertex<T>> {

  private T name;
  private List<Edge<T>> adjacentList;
  private boolean visited;
  private Vertex<T> predecessor;
  private double distance = Double.MAX_VALUE;

  public Vertex(T name) {
    this.name = name;
    this.adjacentList = new ArrayList<>();
  }

  public void addNeighbour(Edge<T> edge) {
    this.adjacentList.add(edge);
  }

  public T getName() {
    return name;
  }

  public void setName(T name) {
    this.name = name;
  }

  public List<Edge<T>> getAdjacentList() {
    return adjacentList;
  }

  public void setAdjacentList(List<Edge<T>> adjacentList) {
    this.adjacentList = adjacentList;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public Vertex<T> getPredecessor() {
    return predecessor;
  }

  public void setPredecessor(Vertex<T> predecessor) {
    this.predecessor = predecessor;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  @Override
  public String toString() {
    return this.name.toString();
  }

  @Override
  public int compareTo(@NotNull Vertex otherVertex) {
    return Double.compare(this.distance, otherVertex.distance);
  }
}
