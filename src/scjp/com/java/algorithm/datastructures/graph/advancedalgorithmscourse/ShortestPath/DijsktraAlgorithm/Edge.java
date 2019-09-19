package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.ShortestPath.DijsktraAlgorithm;

public class Edge<T> {
  private double weight;
  private Vertex<T> startVertex;
  private Vertex<T> targetVertex;

  public Edge(double weight, Vertex<T> startVertex, Vertex<T> targetVertex) {
    this.weight = weight;
    this.startVertex = startVertex;
    this.targetVertex = targetVertex;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public Vertex<T> getStartVertex() {
    return startVertex;
  }

  public void setStartVertex(Vertex<T> startVertex) {
    this.startVertex = startVertex;
  }

  public Vertex<T> getTargetVertex() {
    return targetVertex;
  }

  public void setTargetVertex(Vertex<T> targetVertex) {
    this.targetVertex = targetVertex;
  }
}
