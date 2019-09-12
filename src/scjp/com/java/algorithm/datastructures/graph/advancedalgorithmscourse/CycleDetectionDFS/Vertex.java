package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.CycleDetectionDFS;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T extends Comparable> {

    private T value;
    private boolean visited;
    private boolean beingVisited;
    private List<Vertex<T>> adjacentList;

    public Vertex(T value) {
        this.value = value;
        this.adjacentList = new ArrayList<>();
    }

    public void addNeighbourVertex(Vertex<T> vertex) {
        this.adjacentList.add(vertex);
    }

    public List<Vertex<T>> getAdjacentList() {
        return adjacentList;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
