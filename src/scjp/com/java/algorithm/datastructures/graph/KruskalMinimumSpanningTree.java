package scjp.com.java.algorithm.datastructures.graph;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/*
 * 1. Sort all the edges in ascending order of their weight.
 * 2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far.
 *    If cycle is not formed, include this edge. Else, discard it.
 * 3. Repeat step#2 until there are (V-1) edges in the spanning tree.
 */


/*
 Application:-  Network design.
– telephone, electrical, hydraulic, TV cable, computer, road
The standard application is to a problem like phone network design. You have a business with several offices;
you want to lease phone lines to connect them up with each other; and the phone company charges different amounts of
money to connect different pairs of cities. You want a set of lines that connects all your offices with a minimum total cost.
It should be a spanning tree, since if a network isn’t a tree you can always remove some edges and save money.
 */
public class KruskalMinimumSpanningTree {

    static class GraphWeighted {
        int V, E; // no of vertices, no of edge
        Edge[] edge;

        GraphWeighted(int V, int E) {
            this.V = V;
            this.E = E;
            edge = new Edge[E];
            for (int i = 0; i < E; i++) {
                edge[i] = new Edge();
            }
        }


        static class Edge implements Comparable<Edge> {
            int src, dest, weight;

            @Override
            public int compareTo(@NotNull Edge o) {
                return this.weight - o.weight;
            }
        }

        static class Subset {
            int parent, rank;
        }

        // find set of an element i (uses path compression technique)
        public static int find(Subset subsets[], int src) {
            // Find the root and make root as parent of 'src' (path compression)
            if (subsets[src].parent != src) {
                subsets[src].parent = find(subsets, subsets[src].parent);
            }
            return subsets[src].parent;
        }

        public static void union(Subset subsets[], int x, int y) {
            int xRoot = find(subsets, x);
            int yRoot = find(subsets, y);

            // Union by Rank. Attach smaller rank tree under root of high rank tree.
            if (subsets[xRoot].rank < subsets[yRoot].rank) {
                subsets[xRoot].parent = yRoot;
            } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
                subsets[yRoot].parent = xRoot;
            } else { // if ranks are same, then make one as root and increment it's rank by one.
                subsets[yRoot].parent = xRoot;
                subsets[xRoot].rank++;
            }
        }

        public void kruskalMST() {
            Edge[] result = new Edge[this.V];
            for (int i = 0; i < this.V; i++) {
                result[i] = new Edge();
            }

            Arrays.sort(this.edge);

            // Allocate memory for creating V subsets
            Subset subsets[] = new Subset[this.V];
            for (int i = 0; i < this.V; ++i) {
                subsets[i] = new Subset();
            }

            // Create V subsets with single elements
            for (int v = 0; v < this.V; v++) {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }

            for (int i = 0, j = 0; j < this.V - 1; i++) {
                Edge nextEdge = this.edge[i];

                int x = find(subsets, nextEdge.src);
                int y = find(subsets, nextEdge.dest);

                if (x != y) {
                    result[j] = nextEdge;
                    union(subsets, x, y);
                    j++;
                }
            }

            System.out.println("Following are the edges in the constructed MST");

            for (int i = 0; i < this.V - 1; i++) {
                System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            }
        }
    }

    public static void main(String[] args) {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edge in graph
        GraphWeighted graph = new GraphWeighted(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        graph.kruskalMST();
    }
}
