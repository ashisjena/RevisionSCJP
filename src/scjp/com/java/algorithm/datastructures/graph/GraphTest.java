package scjp.com.java.algorithm.datastructures.graph;

import java.util.Stack;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(new Pair(0, 1));
        graph.addEdge(new Pair(0, 4));
        graph.addEdge(new Pair(1, 2));
        graph.addEdge(new Pair(1, 3));
        graph.addEdge(new Pair(1, 4));
        graph.addEdge(new Pair(2, 3));
        graph.addEdge(new Pair(3, 4));

        graph.print();
        graph.BFS(3);

        graph.DFSLoop(3);

        Stack<Integer> stack = graph.topologicalSort(1);
        System.out.println();
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "  ");
        }
        System.out.println();

        Graph gr = new Graph(5);
        gr.addSingleEdge(new Pair(1, 0));
        gr.addSingleEdge(new Pair(0, 2));
        gr.addSingleEdge(new Pair(2, 1));
        gr.addSingleEdge(new Pair(0, 3));
        gr.addSingleEdge(new Pair(3, 4));
        gr.stronglyConnectedComponents();


        gr = new Graph(7);
        gr.addSingleEdge(new Pair(0, 1));
        gr.addSingleEdge(new Pair(0, 2));
        gr.addSingleEdge(new Pair(1, 3));
        gr.addSingleEdge(new Pair(4, 1));
        gr.addSingleEdge(new Pair(6, 4));
        gr.addSingleEdge(new Pair(5, 6));
        gr.addSingleEdge(new Pair(5, 2));
        gr.addSingleEdge(new Pair(6, 0));
        //MotherVertex.png
        // If no mother vertex then returns -1;
        System.out.println(System.lineSeparator() + gr.findMotherVertex());


        gr = new Graph(6);
        gr.addSingleEdge(new Pair(0, 1));
        gr.addSingleEdge(new Pair(0, 2));
        gr.addSingleEdge(new Pair(1, 3));
        gr.addSingleEdge(new Pair(2, 4));
        gr.addSingleEdge(new Pair(2, 5));

        gr.findNodesAtKdistance(0, 2);
    }
}
