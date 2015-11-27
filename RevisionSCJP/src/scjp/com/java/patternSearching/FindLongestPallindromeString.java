package scjp.com.java.patternSearching;

import java.util.Arrays;

public class FindLongestPallindromeString {
 public static void main(String[] args) {
  String str = "forgeeksskeegfor";
  findLongestPalindromicString(str.toCharArray());
}
 static void findLongestPalindromicString(char[] strArr)
 {
     if(strArr.length == 0)
         return;
     
     int N = 2*strArr.length - 1; //Position count
     int[] L = new int[N]; //LPS Length Array
     L[0] = 0;
     L[1] = 1;
     int C = 1; //centerPosition 
     int R = 2; //centerRightPosition
     int i = 0; //currentRightPosition
     int iMirror; //currentLeftPosition
     int expand = -1;
     int diff = -1;
     int maxLPSLength = 0;
     int maxLPSCenterPosition = 0;
     int start = -1;
     int end = -1;
      
     for (i = 2; i < N; i++) 
     {
         //get currentLeftPosition iMirror for currentRightPosition i
         iMirror  = 2*C-i;
         //Reset expand - means no expansion required
         expand = 0;
         diff = R - i;
         //If currentRightPosition i is within centerRightPosition R
         if(diff > 0) 
         {
             if(L[iMirror] < diff) // Case 1
                 L[i] = L[iMirror];
             else if(L[iMirror] == diff && i == N-1) // Case 2
                 L[i] = L[iMirror];
             else if(L[iMirror] == diff && i < N-1)  // Case 3
             {
                     L[i] = L[iMirror];
                     expand = 1;  // expansion required
             }
             else if(L[iMirror] > diff)  // Case 4
             {
                 L[i] = diff;
                 expand = 1;  // expansion required
             }
         }
         else
         {
             L[i] = 0;
             expand = 1;  // expansion required
         }
          
         if (expand == 1)
         {
             //Attempt to expand palindrome centered at currentRightPosition i
             //Here for odd positions, we compare characters and 
             //if match then increment LPS Length by ONE
             //If even position, we just increment LPS by ONE without 
             //any character comparison
             while (((i + L[i]) < N && (i - L[i]) > 0) &&
                 ( ((i + L[i] + 1) % 2 == 0) || (strArr[(i + L[i] + 1)/2] == strArr[(i-L[i]-1)/2] )))
             {
                 L[i]++;
             }
         }
  
         if(L[i] > maxLPSLength)  // Track maxLPSLength
         {
             maxLPSLength = L[i];
             maxLPSCenterPosition = i;
         }
  
         // If palindrome centered at currentRightPosition i 
         // expand beyond centerRightPosition R,
         // adjust centerPosition C based on expanded palindrome.
         if (i + L[i] > R) 
         {
             C = i;
             R = i + L[i];
         }
     }
     start = (maxLPSCenterPosition - maxLPSLength)/2;
     end = start + maxLPSLength - 1;
     
     System.out.println("LPS of string is : " + Arrays.toString(strArr));
     for(i=start; i<=end; i++)
       System.out.print( strArr[i]);
 }
}
