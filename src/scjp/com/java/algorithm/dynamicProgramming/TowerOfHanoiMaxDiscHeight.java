package scjp.com.java.algorithm.dynamicProgramming;

import scjp.com.java.algorithm.ConsoleReader;

import java.util.Arrays;
import java.util.stream.Collectors;

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
                Disc[] sortedDiscs = new Disc[noOfDiscs];
                for (int y = 0; y < noOfDiscs; y++) {
                    sortedDiscs[y] = new Disc(cr.readLong(), cr.readLong());
                }
                Arrays.sort(sortedDiscs);
                Arrays.stream(sortedDiscs).forEach(System.out::println);
                long maxHeight = maxHeightLoop(sortedDiscs);
                System.out.println(maxHeight);
            }
        }
    }

    private static long maxHeightLoop(Disc[] discs) {
        long[] maxHeights = new long[discs.length];
        long max = 0;

        for (int i = 0; i < discs.length; i++) {
            long prevMaxHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (discs[i].radius > discs[j].radius && discs[i].height > discs[j].height && prevMaxHeight < maxHeights[j]) {
                    prevMaxHeight = maxHeights[j];
                }
            }
            maxHeights[i] = discs[i].height + prevMaxHeight;
            if (max < maxHeights[i]) {
                max = maxHeights[i];
            }
        }
        System.out.println(Arrays.stream(maxHeights).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        return max;
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
