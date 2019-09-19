package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.ShortestPath.DijsktraAlgorithm;

import java.util.PriorityQueue;
import java.util.Stack;

public class DijsktraAlgorithm {

  public <T> void computePaths(Vertex<T> sourceVertex) {
    sourceVertex.setDistance(0);

    PriorityQueue<Vertex<T>> priorityQueue = new PriorityQueue<>();
    priorityQueue.offer(sourceVertex);

    while (!priorityQueue.isEmpty()) {
      Vertex<T> actualVertex = priorityQueue.poll();

      for (Edge<T> edge : actualVertex.getAdjacentList()) {
        Vertex v = edge.getTargetVertex();

        double newDistance = actualVertex.getDistance() + edge.getWeight();

        if (newDistance < v.getDistance()) {
          priorityQueue.remove(v); // Remove from priority queue
          v.setDistance(newDistance);
          v.setPredecessor(actualVertex);
          priorityQueue.offer(v); // Re-Add it
        }
      }
    }
  }

  public <T> Stack<Vertex<T>> getShortestPathTo(Vertex<T> targetVertex) {
    Stack<Vertex<T>> shortestPathToTarget = new Stack<>();

    for (Vertex<T> vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
      shortestPathToTarget.push(vertex);
    }

    return shortestPathToTarget;
  }
}
