package dynamic_programming_problems.Knapsack_Problem;

public class Knapsack {
    /*
    In 0-1 Knapsack problem, we are given a set of items, each with a weight
    and a value and we need to determine the number of each item to include in
    a collection so that the total weight is less than or equal to a given
    limit and the total value is as large as possible.

    Input:
    Values (stored in array v)
    Weights (stored in array w)
    Knapsack capacity (W)
    */
    public static int knapsack(int[] v, int[] w, int W) {
        // T[i][j] stores the maximum value of knapsack having weight
        // less than equal to j with only first i items considered.
        int[][] T = new int[v.length + 1][W + 1];

        // do for ith item
        for (int i = 1; i <= v.length; i++) {
            // consider all weights from 0 to maximum capacity W
            for (int j = 0; j <= W; j++) {
                // don't include ith element if j-w[i-1] is negative
                if (w[i-1] > j) {
                    T[i][j] = T[i-1][j];
                }
                else {
                    // find maximum value we get by excluding / including the ith item
                    T[i][j] = Integer.max(T[i-1][j], T[i-1][j-w[i-1]] + v[i-1]);
                }
            }
        }
        // return maximum value
        return T[v.length][W];
    }

    public static void main(String[] args) {

        // Input: set of items each with a weight and a value
        int[] v = { 20, 5, 10, 40, 15, 25 };
        int[] w = {  1, 2,  3,  8,  7,  4 };

        // Knapsack capacity
        int W = 10;

        System.out.println("Knapsack value is " + knapsack(v, w, W));
    }
}
