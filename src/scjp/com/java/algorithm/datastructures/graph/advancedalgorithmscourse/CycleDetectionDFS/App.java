package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.CycleDetectionDFS;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Vertex<String> vertex1 = new Vertex<>("1");
        Vertex<String> vertex2 = new Vertex<>("2");
        Vertex<String> vertex3 = new Vertex<>("3");
        Vertex<String> vertex4 = new Vertex<>("4");
        Vertex<String> vertex5 = new Vertex<>("5");
        Vertex<String> vertex6 = new Vertex<>("6");

        vertex1.addNeighbourVertex(vertex2);
        vertex2.addNeighbourVertex(vertex3);
        vertex3.addNeighbourVertex(vertex1);
        vertex4.addNeighbourVertex(vertex1);
        vertex4.addNeighbourVertex(vertex5);
        vertex5.addNeighbourVertex(vertex6);
        vertex6.addNeighbourVertex(vertex4);

        List<Vertex<String>> vertexList = new ArrayList<>();
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);
        vertexList.add(vertex4);
        vertexList.add(vertex5);
        vertexList.add(vertex6);

        CycleDetection<String> cycleDetection = new CycleDetection<>();
        cycleDetection.detectCycle(vertexList);
    }
}
