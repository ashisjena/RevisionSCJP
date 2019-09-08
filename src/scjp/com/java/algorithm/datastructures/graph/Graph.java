package scjp.com.java.algorithm.datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;


/*
Pros: Saves Space. Adding new vertex is easier.
Cons: Queries to find if there is an edge from vertex u to vertex v are not efficient and can be done O(V)
 */
public class Graph {

    private final int V;
    private final LinkedList<Integer>[] adjacentArr;

    public Graph(int V) {
        this.V = V;

        adjacentArr = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjacentArr[i] = new LinkedList<>();
        }
    }

    public void addEdge(Pair pair) {
        adjacentArr[pair.x].add(pair.y);
        adjacentArr[pair.y].add(pair.x);
    }

    public void addSingleEdge(Pair pair) {
        adjacentArr[pair.x].add(pair.y);
    }

    public void BFS(int src) {
        boolean visited[] = new boolean[this.V];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            src = queue.poll();

            System.out.print(src + "  ");
            for (Integer dest : this.adjacentArr[src]) {
                if (!visited[dest]) {
                    queue.offer(dest);
                    visited[dest] = true;
                }
            }
        }
        System.out.println();
    }

    public void DFS(int src) {
        boolean visited[] = new boolean[this.V];

        DFSUtil(src, visited, true);
    }

    public void DFSUtil(int src, boolean[] visited, boolean printValues) {
        visited[src] = true;
        if (printValues) {
            System.out.print(src + " ");
        }

        for (int v : this.adjacentArr[src]) {
            if (!visited[v]) {
                DFSUtil(v, visited, printValues);
            }
        }
    }

    public void DFSLoop(int src) {
        boolean visited[] = new boolean[this.V];

        Stack<Integer> stack = new Stack<>();
        stack.push(src);

        while (!stack.isEmpty()) {
            src = stack.pop();
            if (!visited[src]) {
                System.out.print(src + "  ");
                visited[src] = true;
            }
            for (int v : this.adjacentArr[src]) {
                if (!visited[v]) {
                    stack.push(v);
                }
            }
        }

    }

    public int findMotherVertex() {
        boolean visited[] = new boolean[this.V];

        int v = 0;
        for (int i = 0; i < this.V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited, false);
                v = i;
            }
        }

        visited = new boolean[this.V]; // reset
        DFSUtil(v, visited, false);

        for (boolean isVisited : visited) {
            if (!isVisited) {
                return -1;
            }
        }

        return v;
    }

    public void findNodesAtKdistance(int src, int level) {
        boolean[] visited = new boolean[this.V];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited[src] = true;

        while (level > 0) {
            Queue<Integer> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int x : this.adjacentArr[v]) {
                    if (!visited[x]) {
                        newQueue.add(x);
                    }
                }
            }
            queue = newQueue;
            level--;
        }
        System.out.println(queue.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    public Stack<Integer> topologicalSort(int src) { // Just reverse DFS. Instead of printing put in a Stack
        Stack<Integer> sortedStack = new Stack<>();
        boolean visited[] = new boolean[this.V];
        topologicalSortUtil(src, sortedStack, visited);
        return sortedStack;
    }

    private void topologicalSortUtil(int src, Stack<Integer> sortedStack, boolean[] visited) {
        visited[src] = true;

        for (int s : this.adjacentArr[src]) {
            if (!visited[s]) {
                topologicalSortUtil(s, sortedStack, visited);
            }
        }
        sortedStack.push(src);
    }

    public Graph getTranspose() {
        Graph g = new Graph(this.V);
        for (int v = 0; v < V; v++) {
            for (int vertex : this.adjacentArr[v]) {
                g.adjacentArr[vertex].add(v);
            }
        }
        return g;
    }

    public void fillOrderStack(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        for (int n : this.adjacentArr[v]) {
            if (!visited[n]) {
                fillOrderStack(n, visited, stack);
            }
        }
        stack.push(v);
    }

    public void stronglyConnectedComponents() {
        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[this.V];

        fillOrderStack(0, visited, stack);


        Graph gr = getTranspose();
        gr.print();

        visited = new boolean[this.V];

        while (!stack.empty()) {
            int v = stack.pop();

            if (!visited[v]) {
                gr.DFSUtil(v, visited, true);
                System.out.println();
            }
        }
    }

    public void print() {
        for (int i = 0; i < this.adjacentArr.length; i++) {
            System.out.print(String.format("%5d", i) + "|");
            for (Integer vertex : this.adjacentArr[i]) {
                System.out.print(" -> " + vertex);
            }
            System.out.println();
        }
    }
}
