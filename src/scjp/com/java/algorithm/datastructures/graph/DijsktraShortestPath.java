package scjp.com.java.algorithm.datastructures.graph;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijsktraShortestPath {

    static class Graph {
        int V;
        LinkedList<Edge>[] adjacentArr;

        Graph(int V) {
            this.V = V;
            adjacentArr = new LinkedList[this.V];

            for (int i = 0; i < this.V; i++) {
                this.adjacentArr[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest, int weight) {
            this.adjacentArr[src].add(new Edge(dest, weight));
        }

        public void findShortestPath(int src, int dest) {

            PriorityQueue<Edge> resultQueue = new PriorityQueue<>();
            resultQueue.add(new Edge(src, 0, src));
            for (int i = 0; i < this.V; i++) { // Fill the result with dummy edges.
                if (i == src) {
                    continue;
                }
                resultQueue.add(new Edge(i, Integer.MAX_VALUE, null));
            }

            boolean[] visited = new boolean[this.V];

            while (true) {
                Edge currEdge = resultQueue.peek();
                if(currEdge.dest == dest) {
                    System.out.println(currEdge.weight);
                    break;
                }
                for (Edge edge : this.adjacentArr[currEdge.dest]) {
                    Edge e = findEdge(resultQueue, edge.dest);

                    int destX = e.dest;
                    int srcX = currEdge.dest;
                    int weight = 0;
                    if(e.src == currEdge.src && e.weight > currEdge.weight + edge.weight) {
                        weight = currEdge.weight + edge.weight;
                    } else {
                        weight = edge.weight;
                    }

                    resultQueue.offer(new Edge(destX, weight, srcX));
                }
                resultQueue.poll();
            }
        }

        public Edge findEdge(PriorityQueue<Edge> queue, int dest) {
            for (Edge edge : queue) {
                if (edge.dest == dest) {
                    return edge;
                }
            }
            return null;
        }
    }

    static class Edge implements Comparable {
        int dest;
        int weight;

        Integer src;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        Edge(int dest, int weight, Integer src) {
            this.dest = dest;
            this.weight = weight;
            this.src = src;
        }

        @Override
        public int compareTo(@NotNull Object o) {
            if (o == null) {
                return -1;
            } else if (!(o instanceof Edge)) {
                throw new RuntimeException("Not compatible");
            }
            return this.weight - ((Edge) o).weight;
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph(9);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        graph.findShortestPath(0, 4);
    }
}
