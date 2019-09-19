package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.ShortestPath.BellmanFordAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

  private String name;
  private List<Edge> adjacentList;
  private boolean visited;
  private double distance = Double.MAX_VALUE;
  private Vertex predecessor;

  public Vertex(String name) {
    this.name = name;
    this.adjacentList = new ArrayList<>();
  }

  public void addNeighbour(Edge edge) {
    this.adjacentList.add(edge);
  }

  public List<Edge> getAdjacentList() {
    return adjacentList;
  }

  public Vertex getPredecessor() {
    return predecessor;
  }

  public void setPredecessor(Vertex predecessor) {
    this.predecessor = predecessor;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  @Override
  public String toString() {
    return name;
  }
}
