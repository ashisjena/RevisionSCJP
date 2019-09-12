package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS<T extends Comparable> {
    public void bfs(Vertex<T> root) {
        Queue<Vertex<T>> queue = new LinkedList<>();

        queue.offer(root);
        root.setVisited(true);

        while (!queue.isEmpty()) {
            Vertex<T> currVertex = queue.poll();
            System.out.print(currVertex + " ");

            for (Vertex<T> v : currVertex.getNeighbourList()) {
                if (!v.isVisited()) {
                    queue.offer(v);
                }
            }
        }
    }
}
