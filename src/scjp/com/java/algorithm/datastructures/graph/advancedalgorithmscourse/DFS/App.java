package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.DFS;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Vertex<String> v1 = new Vertex<>("1");
        Vertex<String> v2 = new Vertex<>("2");
        Vertex<String> v3 = new Vertex<>("3");
        Vertex<String> v4 = new Vertex<>("4");
        Vertex<String> v5 = new Vertex<>("5");
        Vertex<String> v6 = new Vertex<>("6");


        v1.addNeighbourVertex(v2);
        v2.addNeighbourVertex(v6);
        v1.addNeighbourVertex(v3);
        v3.addNeighbourVertex(v4);
        v4.addNeighbourVertex(v5);

        List<Vertex<String>> list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);

        DFS<String> dfs = new DFS<>();
        dfs.dfs(list);
    }
}
