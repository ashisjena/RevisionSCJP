package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.MazeSolver;

import scjp.com.java.algorithm.ConsoleReader;

public class App {
    public static void main(String[] args) {

        int[][] map = new int[7][7];
        int startPositionRow = 0, startPositionCol = 0;

        String fileName = "map.txt";
        try (ConsoleReader reader = new ConsoleReader(App.class.getResourceAsStream(fileName))) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = reader.readInt();
                    if (map[i][j] == 2) {
                        startPositionRow = i;
                        startPositionCol = j;
                    }
                }
            }
        }

        MazeSolver mazeSolver = new MazeSolver(map, startPositionRow, startPositionCol);
        mazeSolver.findWayOut();
    }
}
