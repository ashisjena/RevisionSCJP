package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.BFS;

public class App {

    public static void main(String[] args) {
        BFS<Integer> bfs = new BFS<>();

        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);
        Vertex<Integer> vertex5 = new Vertex<>(5);

        vertex1.addNeighbourVertex(vertex2);
        vertex1.addNeighbourVertex(vertex4);
        vertex4.addNeighbourVertex(vertex5);
        vertex2.addNeighbourVertex(vertex3);

        bfs.bfs(vertex1);
    }
}
