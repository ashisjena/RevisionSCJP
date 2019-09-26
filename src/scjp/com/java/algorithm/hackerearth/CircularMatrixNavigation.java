package scjp.com.java.algorithm.hackerearth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Those of you who are familiar with the TV Show Community and it's 'lovable' character, Abed, who likes to travel around dimensions, parallel universes, and various other parallel time lines, would know that Abed needs your help. And if you aren't familiar, help the kid, anyway.

Now Abed has been told by Britta that she's going to marry Jeff, and that has freaked him out. He thinks their study group will no longer be able to stay intact anymore. Abed wants to use his weird super-power to move across coordinates to reach the desired time-line where everyone is together.

From the current coordinate, Abed can go to a cell which is vertically, or horizontally adjacent to it. As we know, every story has a twist: if you're on the rightmost cell, moving right from it will move you to the leftmost cell. And vice versa - for the left move from the leftmost cell will lead you to the rightmost cell. If you move down from the most bottom cell, it will lead you to the corresponding top cell, and vice versa for the top cell, too.

Anyway, everyone gets one chance, Abed has got one, too. He has exactly "1000" time-line coins, which he can use to travel across various time-lines. These time-lines are represented as N rows and M columns. For every move, there's a constant price attached to it, and no matter whatever move you make, you have to pay that price. Obviously, if that price exceeds 1000, Abed will not be able to travel any further, and his group will not be saved. Otherwise, if he can travel from the time-line he's in, to the one he's supposed to go to in less than or equal to 1000 coins, the group will be saved.

Each cell of a matrix is a unique time-line. Also, each time-line is uniquely defined by two variables, x and y. Given a coordinate x1, y1, he would have to go to x2, y2 - and for every move, there'll be a price *p * associated as well.

Input format:
The first line contains the number of test cases, following which two numbers N, and M denoting the number of rows and columns. For every pair of row and column, you need to input the initial coordinates of Abed, the final coordinates where he needs to reach, and the price of every move in that unique matrix.

Output format:
Print the final cost incurred. And "Let go of the group." if the cost is above 1000, or "You saved the group.", if he manages to do it under 1000.

Constraints:
1 <= tc <= 10
1 <= N, M <= 10^6
0 <= x1, x2 <= N-1
0 <= y1, y2 <= M-1
1 <= p <= 10

Sample test case

SAMPLE INPUT
1
4 4
3 0
2 2
9
SAMPLE OUTPUT
27
You saved the group.
Explanation
Total number of moves = number of moves to walk along rows + number of moves to walk along column.

Note that, These two distances are independent. So, we can handle them individually. Also, to reach from a row to another row OR from
a column to another column there are two ways: 1) Go directly i.e abs(x1-x2) where we are going from row x1 to row x2. 2) Use the wrapped
around matrix. abs(n-x1-x2) i.e we will move through all the blocks except which connects them directly.

We take the minimum of two to get the minimum moves to reach there.

ex:
Input:
1
4 4
0 3
3 0
9
Output:
18
You saved the group.
*/

public class CircularMatrixNavigation {

  public static void main(String[] args) {
    try (ConsoleReader cr = new ConsoleReader()) {
      int noOfTestCases = cr.readInt();

      int m = cr.readInt();
      int n = cr.readInt();

      List<Pair[]> srcDest = new ArrayList<>();
      for (int i = 0; i < noOfTestCases; i++) {
        Pair[] pair = {new Pair(cr.readInt(), cr.readInt()), new Pair(cr.readInt(), cr.readInt())};
        srcDest.add(pair);
      }

      int weightPerMove = cr.readInt();

      printCost(m, n, srcDest, weightPerMove);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void printCost(int m, int n, List<Pair[]> srcDestList, int weightPerMove) {

    for (Pair[] srcDest : srcDestList) {
      boolean dp[][] = new boolean[m][n];

      Pair src = srcDest[0];
      Pair dest = srcDest[1];

      int xAxisMovies;
      if (dest.x > src.x) {
        xAxisMovies = Math.min((dest.x - src.x), (m - dest.x + src.x - 0)); // (m - dest.x) + src.x
      } else {
        xAxisMovies = Math.min((src.x - dest.x), (m - src.x + dest.x - 0));
      }

      int yAxisMovies;
      if (dest.y > src.y) {
        yAxisMovies = Math.min((dest.y - src.y), (m - dest.y + src.y - 0));
      } else {
        yAxisMovies = Math.min((src.y - dest.y), (m - src.y + dest.y - 0));
      }

      int weight = (xAxisMovies + yAxisMovies) * weightPerMove;

      if (weight > 1000) {
        System.out.println("Let go of the group.");
      } else {
        System.out.println(weight);
        System.out.println("You saved the group.");
      }
    }
  }

  static class Pair {
    final int x;
    final int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
