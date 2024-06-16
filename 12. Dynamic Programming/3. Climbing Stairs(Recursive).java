/*
https://leetcode.com/problems/climbing-stairs/description/

70. Climbing Stairs - Recursive with Memoization (Top-Down DP)

Problem Description:
You are climbing a staircase. It takes `n` steps to reach the top. Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?

Algorithm Overview:

1. Base Cases:
   - If `n` is 0 or 1, there's only one way to reach the top (return 1).
2. Memoization:
   - Create a `memo` array to store calculated results for each step to avoid redundant computation. Initialize with -1 to indicate not yet calculated.
3. Recursive Calculation:
   - If the result for `n` is already calculated, return it from `memo[n]`.
   - Otherwise, recursively calculate the number of ways to reach step `n` by summing the ways to reach steps `n-1` and `n-2`.
   - Store the result in `memo[n]` before returning it.

Time Complexity: O(N) - Each distinct subproblem (number of ways to reach each step) is calculated only once.
Space Complexity: O(N) - For the memoization array and the recursion call stack.
*/

class Solution {
  public int climbStairs(int n) {
      int[] memo = new int[n + 1]; 
      Arrays.fill(memo, -1); // Initialize memo array to -1

      return climbStairsHelper(n, memo);
  }

  private int climbStairsHelper(int n, int[] memo) {
      if (n == 0 || n == 1) {
          return 1; // Base cases: 1 way to reach steps 0 and 1
      }
      if (memo[n] != -1) {
          return memo[n]; // Return memoized result if available
      }
      
      // Recursively calculate and store the result
      memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);  
      return memo[n];
  }
}
