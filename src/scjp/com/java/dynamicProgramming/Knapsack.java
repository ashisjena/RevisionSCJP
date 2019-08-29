package scjp.com.java.dynamicProgramming;

// Weight: 1, 2, 3, 5
// Price:  2, 2, 5, 6
// Knapsack size : 5
// Find the maximum price in which weight combines to Knapsack size.
public class Knapsack {
    public static void main(String[] args) {
        int weightArr[] = {1, 2, 3, 4};
        int priceArr[] = {2, 8, 5, 6};

        int knapsackWeight = 5;
        int n = priceArr.length;
        int [][] knapsackTable = knapsack(knapsackWeight, weightArr, priceArr, n);
        printKnapsackTable(knapsackTable, weightArr, priceArr, knapsackWeight);
        System.out.println(knapsackTable[knapsackTable[0].length - 1][knapsackWeight + 1]);
    }

    private static int knapsackRecur(int remainingKnapsackWeight, int[] weightArr, int[] priceArr, int n) {
        // Base case
        if (n == 0 || remainingKnapsackWeight == 0) {
            return 0;
        }

        if (weightArr[n - 1] > remainingKnapsackWeight) {
            return knapsackRecur(remainingKnapsackWeight, weightArr, priceArr, n - 1);
        } else {
            return Math.max(
                    priceArr[n - 1] + knapsackRecur(remainingKnapsackWeight - weightArr[n - 1], weightArr, priceArr, n - 1),
                    knapsackRecur(remainingKnapsackWeight, weightArr, priceArr, n - 1)
            );
        }
    }

    private static int[][] knapsack(int totalKnapsackWeight, int[] weightArr, int[] priceArr, int n) {
        int K[][] = new int[n + 1][totalKnapsackWeight + 1];

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int currKnapsackSize = 0; currKnapsackSize <= totalKnapsackWeight; currKnapsackSize++) {
                int currentSackWeight = weightArr[i - 1];
                int currentSackPrice = priceArr[i - 1];
                if (i == 0 || currKnapsackSize == 0) {
                    K[i][currKnapsackSize] = 0;
                } else if (currKnapsackSize < weightArr[i - 1]) { // current knapsack size is less than weight of current sack
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
