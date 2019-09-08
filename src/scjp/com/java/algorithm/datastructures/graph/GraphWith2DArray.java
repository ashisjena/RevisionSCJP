package scjp.com.java.algorithm.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

// Image undirectedgraph.jpg

/*
V: no of vertices

Pros: Representation is easier to implement and follow. Removing an edge takes O(1) time.
Queries like whether there is an edge from vertex ‘u’ to vertex ‘v’ are efficient and can be done O(1).

Cons: Consumes more space O(V^2). Even if the graph is sparse(contains less number of edge),
it consumes the same space. Adding a vertex is O(V^2) time.
 */
public class GraphWith2DArray {
    public static void main(String[] args) {
        // Array Vertices / nodes = 5
        int noOfVertices = 5;
        List<Pair> edges = new ArrayList<>();
        edges.add(new Pair(0, 1));
        edges.add(new Pair(1, 0));
        edges.add(new Pair(0, 4));
        edges.add(new Pair(4, 0));
        edges.add(new Pair(4, 1));
        edges.add(new Pair(1, 4));
        edges.add(new Pair(4, 3));
        edges.add(new Pair(3, 4));
        edges.add(new Pair(3, 1));
        edges.add(new Pair(1, 3));
        edges.add(new Pair(3, 2));
        edges.add(new Pair(2, 3));
        edges.add(new Pair(2, 1));
        edges.add(new Pair(1, 2));

        int[][] graph = new int[noOfVertices][noOfVertices];

        for (Pair pair : edges) {
            graph[pair.x][pair.y] = 1;
        }

        printGraph(graph);

    }

    static void printGraph(int arr[][]) {
        System.out.print(String.format("%3s", "") + " |");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%5d", i));
        }
        System.out.println();
        for (int i = 0; i <= arr.length + 1; i++) {
            System.out.print("-----");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%3d", i) + " |");
            for (int value : arr[i]) {
                System.out.print(String.format("%5d", value));
            }
            System.out.println(System.lineSeparator());
        }
    }
}
