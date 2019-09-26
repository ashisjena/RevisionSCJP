package scjp.com.java.algorithm.companies.eagleview;

import java.util.ArrayList;
import java.util.List;

// Battleship
public class Solution {

  public static void main(String[] args) {
//    int arr[] = {1, 2, 3};
//    int arr[] = {1, 4, -1, 3, 2};

//    System.out.println(solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"));
    System.out.println(solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A 1B 1C 2C"));
  }

  public static String solution(int N, String S, String T) {

    List<Pair[]> shipLists = new ArrayList<>();
    for (String addr : S.split(",")) {
      String[] shipAddr = addr.split("\\s+");
      Pair[] shipDetail = {getPair(shipAddr[0]), getPair(shipAddr[1])};
      shipLists.add(shipDetail);
    }

    List<Pair> hits = new ArrayList<>();
    for (String addr : T.split("\\s+")) {
      hits.add(getPair(addr));
    }

    return sinkAndHit(N, shipLists, hits);
  }

  private static String sinkAndHit(int n, List<Pair[]> shipLists, List<Pair> hits) {
    boolean arr[][] = new boolean[n + 1][n + 1];
    for (Pair hit : hits) {
      arr[hit.x][hit.y] = true;
    }

    int hitCount = 0;
    int sinkCount = 0;
    for (Pair[] startEnd : shipLists) {
      Pair start = startEnd[0];
      Pair end = startEnd[1];

      boolean isHit = false;
      boolean isSink = true;
      for (int i = start.x; i <= end.x; i++) {
        for (int j = start.y; j <= end.y; j++) {
          isHit = isHit || arr[i][j];
          isSink = isSink && arr[i][j];
        }
      }
      if (isHit && !isSink) hitCount++;
      if (isSink) sinkCount++;
    }

    return sinkCount + "," + hitCount;
  }

  static Pair getPair(String s) {
    int x = Integer.parseInt(s.substring(0, s.length() - 1));
    int y = Character.getNumericValue(s.charAt(s.length() - 1)) - (Character.getNumericValue('A') - 1);

    return new Pair(x, y);
  }

  static class Pair {
    int x, y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int solution3(String S) {
    int bCount = 1;
    int aCount = 1;
    int lCount = 2;
    int oCount = 2;
    int nCount = 1;

    int lengthOfBalloon = 7;

    for (char ch : S.toCharArray()) {
      if (ch == 'B' && bCount > 0) {
        bCount--;
      }
      if (ch == 'A' && aCount > 0) {
        aCount--;
      }
      if (ch == 'L' && lCount > 0) {
        lCount--;
      }
      if (ch == 'O' && oCount > 0) {
        oCount--;
      }
      if (ch == 'N' && nCount > 0) {
        nCount--;
      }
    }

    if (bCount == 0 && aCount == 0 && lCount == 0 && oCount == 0 && nCount == 0) {
      return (int) Math.ceil((double) (S.length() - lengthOfBalloon) / lengthOfBalloon);
    } else {
      return 0;
    }
  }

  public static int solution2(int[] A) {
    int length = 0;

    if (A == null || A.length == 0) {
      return 0;
    }

    int x = A[0];
    while (x != -1) {
      x = A[x];
      length++;
    }
    return length + 1;
  }

  public static int solution1(int[] A) {
    int nextPositiveNumber = 1;

    int biggestNumber = 0;
    for (int x : A) {
      if (x > biggestNumber) {
        biggestNumber = x;
      }
    }


    boolean visited[] = new boolean[biggestNumber + 2];
    visited[0] = true;

    for (int x : A) {
      if (x > 0) {
        visited[x] = true;
      }
    }

    for (int i = 0; i < biggestNumber + 2; i++) {
      if (!visited[i]) {
        return i;
      }
    }

    return 1;
  }
}
