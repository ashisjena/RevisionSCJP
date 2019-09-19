package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.ShortestPath.BellmanFordAlgorithm;

import java.util.List;

public class BellmanFord {

  private List<Edge> edgeList;
  private List<Vertex> vertexList;

  public BellmanFord(List<Vertex> vertexList, List<Edge> edgeList) {
    this.edgeList = edgeList;
    this.vertexList = vertexList;
  }

  public void bellmanFord(Vertex srcVertex) {
    srcVertex.setDistance(0);

    for (int i = 0; i < vertexList.size() - 1; i++) { // V-1 iterations --> We relax all the edges

      for (Edge edge : edgeList) {

        Vertex startVertex = edge.getStartVertex();
        Vertex targetVertex = edge.getTargetVertex();

        if (startVertex.getDistance() == Double.MAX_VALUE) {
          continue;
        }

        double newDistance = startVertex.getDistance() + edge.getWeight();

        if (newDistance < targetVertex.getDistance()) {
          targetVertex.setDistance(newDistance);
          targetVertex.setPredecessor(startVertex);
        }
      }
    }

    for (Edge edge : edgeList) { // Vth iteration
      if (edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
        if (hasCycle(edge)) { // Since we considered all the edges. Finding a better solution means there is a negative number.
          System.out.println("There has been a negative cycle detected..");
          return;
        }
      }
    }
  }

  private boolean hasCycle(Edge edge) {
    return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance(); // Has a better solution.
  }

  public void shortestPathTo(Vertex targetVertex) {
    if (targetVertex.getDistance() == Double.MAX_VALUE) {
      System.out.println("This is no path from the source to the target vertex");
    }

    Vertex actualVertex = targetVertex;

    while (actualVertex != null) {
      System.out.print(actualVertex + " - ");
      actualVertex = actualVertex.getPredecessor();
    }
  }
}
