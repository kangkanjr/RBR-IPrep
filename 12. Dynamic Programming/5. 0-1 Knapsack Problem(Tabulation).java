/*
https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

https://www.youtube.com/watch?v=8LusJS5-AGo&ab_channel=TusharRoy-CodingMadeSimple

0-1 Knapsack Problem - Dynamic Programming Solution

Problem Description:
Given a knapsack with weight capacity 'W' and a set of 'n' items with weights 'wt[]' and values 'val[]', find the 
maximum total value of items that can be included in the knapsack so that the total weight is less than or equal to 
'W'. Each item can either be taken entirely or left behind (0-1 property).

Algorithm Overview (Dynamic Programming - Tabulation):

1. Create DP Table:
   - Create a 2D table `K[][]` where `K[i][w]` represents the maximum value that can be obtained with the first `i` items and a knapsack of capacity `w`.

2. Initialize Base Cases:
   - `K[0][w]` = 0 for all `w` (no items, no value)
   - `K[i][0]` = 0 for all `i` (zero capacity, no items can be included)

3. Fill DP Table:
   - Iterate through items (`i` from 1 to `n`) and capacities (`w` from 1 to `W`).
   - For each cell `K[i][w]`:
     - If the weight of the current item `wt[i-1]` is greater than the current capacity `w`, the item cannot be included, 
        so the optimal value is the same as the value without this item: `K[i][w] = K[i-1][w]`.
     - Otherwise, we have a choice:
       - Include the item: The value would be `val[i-1]` (value of current item) + `K[i-1][w-wt[i-1]]` (the optimal 
          value for the remaining capacity after including this item).
       - Exclude the item: The value would be `K[i-1][w]` (the optimal value without this item).
       - Take the maximum of these two options to get the optimal value for `K[i][w]`.

4. Return Result:
   - The final answer is stored in the bottom-right corner of the table, `K[n][W]`, 
      representing the maximum value achievable with all items and the given capacity.

Time Complexity: O(N*W), where N is the number of items and W is the capacity of the knapsack. We fill an N*W table.
Space Complexity: O(N*W) for the DP table. (Can be optimized to O(W) using a 1D array.)
*/
class Solution 
{ 
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        // DP table to store max values for different items and capacities
        int[][] K = new int[val.length + 1][W + 1];

        // Fill the DP table
        for (int i = 0; i <= val.length; i++) { // Iterate over items
            for (int w = 0; w <= W; w++) {     // Iterate over capacities
                if (i == 0 || w == 0) {
                    K[i][w] = 0; // Base cases: 0 value when no items or zero capacity
                    continue;
                }

                // If the current item's weight exceeds the current capacity
                if (wt[i - 1] > w) {
                    K[i][w] = K[i - 1][w]; // Optimal value is the same as without this item
                } else {
                    // Choose the maximum value achievable by either including or excluding the current item
                    K[i][w] = Math.max(
                        val[i - 1] + K[i - 1][w - wt[i - 1]], // Include the item
                        K[i - 1][w]                           // Exclude the item
                    );
                }
            }
        }

        return K[val.length][W]; // The final answer is in the bottom-right corner
    } 
}
