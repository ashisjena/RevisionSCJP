package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.TopologicalOrdering;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        TopologicalOrdering<String> topologicalOrdering = new TopologicalOrdering<>();

        List<Vertex<String>> graph = new ArrayList<>();

        graph.add(new Vertex<>("0"));
        graph.add(new Vertex<>("1"));
        graph.add(new Vertex<>("2"));
        graph.add(new Vertex<>("3"));
        graph.add(new Vertex<>("4"));
        graph.add(new Vertex<>("5"));

        graph.get(2).addNeighbourVertex(graph.get(3));

        graph.get(3).addNeighbourVertex(graph.get(1));

        graph.get(4).addNeighbourVertex(graph.get(0));
        graph.get(4).addNeighbourVertex(graph.get(1));

        graph.get(5).addNeighbourVertex(graph.get(0));
        graph.get(5).addNeighbourVertex(graph.get(1));

        for(int i = 0; i < graph.size(); i++) {
            if(!graph.get(i).isVisited()) {
                topologicalOrdering.dfs(graph.get(i));
            }
        }

        Stack<Vertex<String>> stack = topologicalOrdering.getStack();
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
