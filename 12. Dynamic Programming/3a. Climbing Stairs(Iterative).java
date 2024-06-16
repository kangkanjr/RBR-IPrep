/*
https://leetcode.com/problems/climbing-stairs/description/

70. Climbing Stairs - Iterative (Bottom-Up DP)

Problem Description:
You are climbing a staircase. It takes `n` steps to reach the top. Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?

Algorithm Overview:

1. Base Cases:
   - Create a `dp` array of size `n + 1` to store the number of ways to reach each step.
   - Initialize `dp[0]` and `dp[1]` to 1, representing the base cases.

2. Iterative Calculation:
   - For `i` from 2 to `n`, calculate `dp[i]` as the sum of `dp[i - 1]` (ways to reach the previous step) and `dp[i - 2]` (ways to reach two steps before).

3. Return Result:
   - Return `dp[n]`, the number of ways to reach the nth step (the top).

Time Complexity: O(N) - Single loop from 2 to N.
Space Complexity: O(N) - For the `dp` array. 
*/

class Solution {
  public int climbStairs(int n) {
      int[] dp = new int[n + 1]; // Array to store results
      dp[0] = 1; 
      dp[1] = 1; 

      for (int i = 2; i <= n; i++) {
          dp[i] = dp[i - 1] + dp[i - 2]; // Calculate ways to reach current step from previous two
      }

      return dp[n];
  }
}
