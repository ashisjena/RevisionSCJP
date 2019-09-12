package scjp.com.java.algorithm.hackerearth;

/*
Little Bob comes to you for candies as you are his favorite coder! He wants X candies. You have N bags and the ith bag contains A[i] candies.

You can give him a set of one or more bags such that the sum of candies in those bags is EXACTLY equal to X. Bob wants to find smallest such set of bags. If there are multiple smallest such sets than Bob wants the lexicographically smallest set of such bags.

See the sample test cases for more clarity.

Input:
The first line contains two space-separated integers N and X.
The second line contains N integers, the number of candies in each bag.

Output:
Print the indices of the bags that you give to Bob. If it is not possible to form such a set, print -1.

Constraints:
1 ≤ N ≤ 20
1 ≤ X ≤ 106
1 ≤ A[i] ≤ 106

SAMPLE INPUT
6 9
5 7 1 4 4 1
SAMPLE OUTPUT
1 4
Explanation
There are 3 such sets possible whose sum is 9 :
1 (5) + 4 (4) = 9
1 (5) + 5 (4) = 9
2 (7) + 3 (1) + 6 (1) = 9
Now in the 3rd set there are 3 bags being given but in 1st and 2nd set we can give 2 bags which is less than 3. We don't allot 2nd set because for the second set bags allocated will be 1 and 5 which is lexicographically larger than 1 and 4 in the case of 1st set.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BagProblem {
    public static void main(String[] args) {
        try(ConsoleReader reader = new ConsoleReader()) {
            int n = reader.readInt();
            int sum = reader.readInt();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = reader.readInt();
            }

            List<List<Integer>> bags = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                findBags(arr, sum, i, bags);
            }

            System.out.println(bags);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findBags(int[] arr, int remaining, int start, List<List<Integer>> bags) {
        List<Integer> list = new ArrayList<>();
        for(int i = start; i < arr.length; i++) {
            remaining -= arr[i];
            if(remaining == 0) {
                list.add(i);
                bags.add(list);
            } else if(remaining > 0 ) {
                list.add(i);
            } else {
                remaining += arr[i];
            }
        }
    }
}
