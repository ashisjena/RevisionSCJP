package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.ShortestPath.DAGShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AcyclicShortestPath {

  public void shortestPath(List<Vertex> vertexList, Vertex sourceVertex, Vertex targetVertex) {
    TopologicalSort topologicalSort = new TopologicalSort();
    topologicalSort.makeTopologicalOrder(vertexList);

    Stack<Vertex> stack = topologicalSort.getTopologicalOrder();

    sourceVertex.setDistance(0); // Marking the starting vertex with distance zero

    for (Vertex actualVertex : stack) {

      for (Edge edge : actualVertex.getAdjacentList()) {
        Vertex u = edge.getStartVertex();
        Vertex v = edge.getTargetVertex();

        double newDistance = u.getDistance() + edge.getWeight();

        if (newDistance < v.getDistance()) {
          v.setDistance(newDistance);
          v.setPredecessor(u);
        }
      }
    }

    if (targetVertex.getDistance() == Double.MAX_VALUE) {
      System.out.println("No shortest path there...");
    } else {
      System.out.println("Target vertex shortest path: " + targetVertex.getDistance());
    }
  }

  public void showShortextPathTo(Vertex targetVertex) {
    List<Vertex> list = new ArrayList<>();

    Vertex actualVertex = targetVertex;
    list.add(actualVertex);

    while(actualVertex.getPredecessor() != null) {
      actualVertex = actualVertex.getPredecessor();
      list.add(actualVertex);
    }

    Collections.reverse(list);
    System.out.println(list);
  }
}
