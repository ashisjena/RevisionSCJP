package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.DFS;

import java.util.List;
import java.util.Stack;

public class DFS<T extends Comparable> {
    private Stack<Vertex<T>> stack;

    public DFS() {
        this.stack = new Stack<>();
    }

    public void dfs(List<Vertex<T>> vertexList) {
        for (Vertex<T> v : vertexList) {
            if (!v.isVisited()) {
                v.setVisited(true);
                dfsWithStack(v);
                // dfsRecursive(v);
            }
        }
    }

    private void dfsRecursive(Vertex<T> v) {
        System.out.print(v + " ");
        for (Vertex<T> vertex : v.getNeighbourList()) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfsRecursive(vertex);
            }
        }
    }

    private void dfsWithStack(Vertex<T> rootVertex) {
        this.stack.add(rootVertex);
        rootVertex.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex<T> actualVertex = this.stack.pop();
            System.out.print(actualVertex + " ");

            for (Vertex<T> v : actualVertex.getNeighbourList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    this.stack.push(v);
                }
            }
        }
    }
}
