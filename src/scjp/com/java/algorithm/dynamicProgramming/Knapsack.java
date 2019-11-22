package scjp.com.java.algorithm.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

// Weight: 1, 2, 3, 5
// Price:  2, 2, 5, 6
// Knapsack size : 5
// Find the maximum price in which weight combines to Knapsack size.
public class Knapsack {
    public static void main(String[] args) {
        int weightArr[] = {1, 2, 3, 4};
        int priceArr[] = {2, 8, 5, 6};

        int knapsackSize = 5;
        int n = priceArr.length;
        int[][] knapsackTable = knapsack(knapsackSize, weightArr, priceArr, n);
        printKnapsackTable(knapsackTable, weightArr, priceArr, knapsackSize);
        System.out.println(knapsackTable[n][knapsackSize]);
        System.out.println(getItems(knapsackTable, weightArr, priceArr, knapsackSize));
    }

    private static int knapsackRecur(int remainingKnapsackWeight, int[] weightArr, int[] priceArr, int n) {
        // Base case
        if (n == 0 || remainingKnapsackWeight == 0) {
            return 0;
        }

        int currentWeight = weightArr[n - 1];
        int currentPrice = priceArr[n - 1];
        if (currentWeight > remainingKnapsackWeight) {
            return knapsackRecur(remainingKnapsackWeight, weightArr, priceArr, n - 1);
        } else {
            return Math.max(
                    currentPrice + knapsackRecur(remainingKnapsackWeight - currentWeight, weightArr, priceArr, n - 1),
                    knapsackRecur(remainingKnapsackWeight, weightArr, priceArr, n - 1)
            );
        }
    }

    private static int[][] knapsack(int totalKnapsackSize, int[] weightArr, int[] priceArr, int n) {
        int K[][] = new int[n + 1][totalKnapsackSize + 1];

        // Build table K[][] in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int currKnapsackSize = 1; currKnapsackSize <= totalKnapsackSize; currKnapsackSize++) {
                /*if (i == 0 || currKnapsackSize == 0) {
                    K[i][currKnapsackSize] = 0;
                    continue;
                }*/

                int currentSackWeight = weightArr[i - 1];
                int currentSackPrice = priceArr[i - 1];
                if (currKnapsackSize < currentSackWeight) { // current knapsack size is less than weight of current sack
                    K[i][currKnapsackSize] = K[i - 1][currKnapsackSize]; // Copy previous price.
                } else {
                    K[i][currKnapsackSize] = Math.max(
                            // Previous price of the current knapsack weight (not including current weight)
                            K[i - 1][currKnapsackSize],
                            // current price + previous price of remaining weight(current knapsack size - current sack weight)
                            currentSackPrice + K[i - 1][currKnapsackSize - currentSackWeight]
                    );
                }
            }
        }
        return K;
    }

    private static List<String> getItems(int K[][], int[] weightArr, int[] priceArr, int knapsackSize) {
        List<String> result = new ArrayList<>();
        int remainingPrice = K[weightArr.length][knapsackSize];
        for (int i = weightArr.length, j = knapsackSize; i > 0 && remainingPrice > 0; i--) {
            if (K[i][j] > K[i - 1][j]) {
                result.add("(" + priceArr[i - 1] + ") " + weightArr[i - 1]);

                remainingPrice -= priceArr[i - 1];
                while (K[i][j] != remainingPrice) {
                    j--;
                }
            }
        }
        return result;
    }

    static void printKnapsackTable(int arr[][], int[] weightArr, int[] priceArr, int knapsackTotalWeight) {
        System.out.print(String.format("%5s", "") + " |");
        for (int i = 0; i <= knapsackTotalWeight; i++) {
            System.out.print(String.format("%3d", i));
        }
        System.out.println();
        System.out.println("----------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%5s", "(" + (i == 0 ? 0 : priceArr[i - 1]) + ") " + (i == 0 ? 0 : weightArr[i - 1])) + " |");
            for (int value : arr[i]) {
                System.out.print(String.format("%3d", value));
            }
            System.out.println();
        }
    }
}
