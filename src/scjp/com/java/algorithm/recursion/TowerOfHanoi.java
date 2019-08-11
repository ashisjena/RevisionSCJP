package scjp.com.java.algorithm.recursion;

public class TowerOfHanoi {
  public static void main(String[] args) {
    int noOfDisc = 4;
    towerOfHanoi(noOfDisc, 'A', 'B', 'C');
  }

  private static void towerOfHanoi(int topN, char src, char inter, char dest) {
    if (topN == 1)
      System.out.println("Disk 1 from " + src + " to " + dest);
    else {
      towerOfHanoi(topN - 1, src, dest, inter);
      System.out.println("Disk " + topN + " from " + src + " to " + dest);
      towerOfHanoi(topN - 1, inter, src, dest);
    }
  }
}