package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.TopologicalOrdering;

import java.util.Stack;

public class TopologicalOrdering<T extends Comparable> {
    private Stack<Vertex<T>> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }

    public void dfs(Vertex<T> vertex) {
        vertex.setVisited(true);

        for(Vertex<T> v : vertex.getNeighbourList()) {
            if(!v.isVisited()) {
                dfs(v);
            }
        }

        this.stack.push(vertex);
    }

    public Stack<Vertex<T>> getStack() {
        return this.stack;
    }
}
