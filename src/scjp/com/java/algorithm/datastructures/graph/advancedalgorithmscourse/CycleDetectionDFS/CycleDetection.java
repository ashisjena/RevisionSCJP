package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.CycleDetectionDFS;

import java.util.List;

public class CycleDetection<T extends Comparable> {

    public void detectCycle(List<Vertex<T>> vertexList) {
        for (Vertex<T> v : vertexList) {
            if (!v.isVisited()) {
                dfs(v);
            }
        }
    }

    private void dfs(Vertex<T> vertex) {

        System.out.println("DFS on vertex " + vertex);

        vertex.setBeingVisited(true);

        for (Vertex<T> v : vertex.getAdjacentList()) {
            System.out.println("Visiting the neighbours of vertex " + vertex + " --> " + v);

            if (v.isBeingVisited()) {
                System.out.println("This is a backward edge, so there is a cycle");
                return;
            }

            if (!v.isVisited()) {
                System.out.println("Visiting vertex " + v + " recursively..");
                v.setVisited(true);
                dfs(v);
            }
        }

        System.out.println("Set vertex " + vertex + " setBeingVisited(false) and setVisited(true)...");
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}
