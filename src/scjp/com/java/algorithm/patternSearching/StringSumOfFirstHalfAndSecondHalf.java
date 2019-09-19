package scjp.com.java.algorithm.patternSearching;

/*
Input: str = "123123"
Output: 6
The complete string is of even length and sum of first and second
half digits is same

Input: str = "1538023"
Output: 4
The longest substring with same first and second half sum is "5380"
*/

public class StringSumOfFirstHalfAndSecondHalf {
  public static void main(String[] args) {

    String str = "123123";
    System.out.println(findLength(str.toCharArray()));
  }
  
  static int findLength(char[] chars)
  {
      int ans = 0; // Initialize result
   
      // Consider all possible midpoints one by one
      for (int i = 0; i <= chars.length-2; i++)
      {
          /* For current midpoint 'i', keep expanding substring on
             both sides, if sum of both sides becomes equal update
             ans */
          int l = i, r = i + 1;
   
          /* initialize left and right sum */
          int lsum = 0, rsum = 0;
   
          /* move on both sides till indexes go out of bounds */
          while (r < chars.length && l >= 0)
          {
              lsum += chars[l] - '0'; // just to get the number, deducting '0' ASCII
              rsum += chars[r] - '0';
              if (lsum == rsum)
                  ans = Math.max(ans, r-l+1);
              l--;
              r++;
          }
      }
      return ans;
  }
   
}