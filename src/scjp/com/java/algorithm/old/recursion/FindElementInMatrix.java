package scjp.com.java.algorithm.old.recursion;

public class FindElementInMatrix {
  // Search a sorted loop with complexity (O)n
  public static void main(String[] args) {
    int mat[][] = {{10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}};

    //if ( searchUsingLoop( mat, 37 ) )
    if (searchUsingRecurr(mat, 0, mat.length - 1, 37))
      System.out.println("Present");
    else
      System.out.println("Not Present");
  }

  private static boolean searchUsingLoop(int[][] mat, int value) {
    for (int i = 0, j = mat.length - 1; i < mat.length && j >= 0; ) {
      if (mat[i][j] == value)
        return true;
      else {
        if (mat[i][j] > value)
          j--;
        else
          i++;
      }
    }
    return false;
  }

  private static boolean searchUsingRecurr(int[][] mat, int i, int j, int value) {
    if (i == mat.length || j < 0)
      return false;
    else if (mat[i][j] == value)
      return true;
    else if (mat[i][j] > value)
      return searchUsingRecurr(mat, i, --j, value);
    else
      return searchUsingRecurr(mat, ++i, j, value);
  }
}