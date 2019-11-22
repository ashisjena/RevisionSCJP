package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.MazeSolver;

public class MazeSolver {

    private final int[][] mazeMap;
    private final int startPositionRow;
    private final int startPositionColumn;
    private final boolean[][] visited;

    public MazeSolver(int[][] mazeMap, int startPositionRow, int startPositionColumn) {
        this.mazeMap = mazeMap;
        this.startPositionRow = startPositionRow;
        this.startPositionColumn = startPositionColumn;

        this.visited = new boolean[mazeMap.length][mazeMap.length];
    }

    public void findWayOut() {
        boolean found = dfs(startPositionRow, startPositionColumn);
        if (found) {
            System.out.println("Route found to exit....");
        } else {
            System.out.println("No BarterMarket found....");
        }
    }

    private boolean dfs(int rowIndex, int columnIndex) {

        System.out.println("Visiting i=" + rowIndex + ", j=" + columnIndex);

        if (this.mazeMap[rowIndex][columnIndex] == 3) {
            return true;
        }
        int endOfMap = this.mazeMap.length - 1;

        if (visited[rowIndex][columnIndex]) { // If visited, skip it.
            return false;
        } else if (rowIndex < 0 || rowIndex >= endOfMap || columnIndex < 0 || columnIndex >= endOfMap) {
            return false;
        } else if (this.mazeMap[rowIndex][columnIndex] == 1) { // if it's a wall then we can't go in that direction.
            return false;
        } else {
            this.visited[rowIndex][columnIndex] = true;

            /*
            boolean a = dfs(rowIndex + 1, columnIndex); // moving down
            boolean b = dfs(rowIndex, columnIndex + 1); // moving right
            boolean c = dfs(rowIndex - 1, columnIndex); // moving up
            boolean d = dfs(rowIndex, columnIndex - 1); // moving left

            return a || b || c || d;
            */

            return dfs(rowIndex + 1, columnIndex) ||
                    dfs(rowIndex, columnIndex + 1) ||
                    dfs(rowIndex, columnIndex - 1) ||
                    dfs(rowIndex - 1, columnIndex);
        }
    }
}
