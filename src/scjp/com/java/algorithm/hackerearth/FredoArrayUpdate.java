package scjp.com.java.algorithm.hackerearth;

/*
Fredo is assigned a new task today. He is given an array A containing N integers. His task is to update all elements of array to some minimum value x , that is,  ;  such that sum of this new array is strictly greater than the sum of the initial array. Note that x should be as minimum as possible such that sum of the new array is greater than the sum of the initial array.

Input Format:
First line of input consists of an integer N denoting the number of elements in the array A.
Second line consists of N space separated integers denoting the array elements.

Output Format:
The only line of output consists of the value of x.

Input Constraints:

1 <= N <= 10^5
1 <= A[i] <= 1000

Sample Input:
5
1 2 3 4 5

Output:
4

Explanation
Initial sum of array
When we update all elements to 4, sum of array  which is greater than .
Note that if we had updated the array elements to 3,  which is not greater than . So, 4 is the minimum value to which array elements need to be updated.
*/

import java.io.IOException;
import java.util.Arrays;

public class FredoArrayUpdate {
    public static void main(String[] args) {
        try (ConsoleReader reader = new ConsoleReader()) {
            int n = reader.readInt();
            int[] arr = new int[n];

            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = reader.readInt();
                sum += arr[i];
            }

            int x = (int) (sum / n + 1);

            System.out.println(x);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
