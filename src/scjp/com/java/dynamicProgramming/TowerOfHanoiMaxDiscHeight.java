package scjp.com.java.dynamicProgramming;

import scjp.com.java.algorithm.ConsoleReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Bob and Alice like to play the game tower of Hanoi. One day Alice challenges Bob to build the tallest tower from a set of disks of different height and radius. The tower of Hanoi can be built by stacking disks on top of each other. In order to put disk A on top of disk B, the radius and height of A must be strictly smaller than those of B. Help Bob to win the challenge.

    Input:
    First line of input contains number of test cases T.
    First line of each test case contains value of N, the number of disks. The next N lines contains two positive integer number Ri and Hi corresponding to the radius and height of ith Disk respectively.

    Output:
    For each test case printKnapsackTable the maximum height of the tower possible.

    Constraints:
    1<=T<=10
    1<=N<=200
    1<=Ri, Hi<=10^9

SAMPLE INPUT
2
3
4 3
1 4
3 2
5
5 6
4 3
1 2
7 5
3 4

SAMPLE OUTPUT
5
12


*/
public class TowerOfHanoiMaxDiscHeight {

    public static void main(String[] args) {
        try (ConsoleReader cr = new ConsoleReader()) {
            int noOfTestCases = cr.readInt();
            for (int x = 0; x < noOfTestCases; x++) {
                int noOfDiscs = cr.readInt();
                SortedSet<Disc> sortedDiscs = new TreeSet<>();
                for (int y = 0; y < noOfDiscs; y++) {
                    sortedDiscs.add(new Disc(cr.readLong(), cr.readLong()));
                }
                sortedDiscs.stream().forEach(System.out::println);
                long maxHeight = maxHeight(sortedDiscs.toArray(new Disc[sortedDiscs.size()]));
                System.out.println(maxHeight);

                long max = maxHeightRec(sortedDiscs.toArray(new Disc[sortedDiscs.size()]), sortedDiscs.size() - 1);
                System.out.println(max);
            }
        }
    }

    private static long maxHeight(Disc[] discs) {
        long[] dp = new long[discs.length];
        Arrays.fill(dp, 0);
        dp[0] = discs[0].height;
        long max = dp[0];
        for (int i = 1; i < discs.length; i++) {
            dp[i] = discs[i].height;
            long dpMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (discs[i].radius > discs[j].radius && discs[i].height > discs[j].height) {
                    if (dp[j] > dpMax) {
                        dpMax = dp[j];
                    }
                }
            }
            dp[i] += dpMax;
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    // TODO: This recursive approach presently taking lot of iterations and needs improvement. Revisit after DP examples.
    private static long maxHeightRec(Disc[] discs, int n) {
        if (n == 0) {
            return discs[0].height;
        } else if (n < 0) {
            return 0;
        }

        if (discs[n].radius < discs[n - 1].radius) {
            int i = n - 2;
            for (; i > 0; i++) {
                if (discs[i].radius < discs[n].radius) {
                    break;
                }
            }

            return Math.max(discs[n].height + maxHeightRec(discs, i), maxHeightRec(discs, n - 1));
        } else {
            return discs[n].height + maxHeightRec(discs, n - 1);
        }
    }

    static class Disc implements Comparable<Disc> {
        private long height;
        private long radius;

        public Disc(long radius, long height) {
            this.radius = radius;
            this.height = height;
        }

        public long getHeight() {
            return this.height;
        }

        @Override
        public int compareTo(Disc disc) {
            return Long.compare(this.height, disc.height);
        }

        @Override
        public String toString() {
            return "(" + this.radius + ", " + this.height + ")";
        }
    }
}
