/*
198. House Robber - Dynamic Programming (Tabulation)

Problem Description:
You are a robber planning to rob houses along a street. Each house has a certain amount of money stashed, but you 
cannot rob two adjacent houses because of connected alarm systems. Given an integer array `nums` representing the 
amount of money in each house, return the maximum amount of money you can rob tonight without alerting the police.

Algorithm Overview (Tabulation):

1. Edge Cases:
   - Handle the case where there are no houses (`n == 0`) and return 0.
   - Handle the case where there's only one house (`n == 1`) and return the amount in that house.

2. Initialize DP Array:
   - Create a `dp` array of size `n` to store the maximum amount that can be robbed up to the `i`-th house.
   - Base Cases for `dp`:
     - `dp[0]` = `nums[0]` (maximum amount if we only rob the first house)
     - `dp[1]` = `Math.max(nums[0], nums[1])` (maximum amount if we rob either the first or second house)

3. Build DP Table:
   - Iterate through the `nums` array from the third house (`i = 2`) to the last house.
   - For each house `i`, calculate `dp[i]` as the maximum of:
     - The maximum amount obtained by not robbing the current house (`dp[i - 1]`).
     - The maximum amount obtained by robbing the current house and the maximum from two houses before (`dp[i - 2] + nums[i]`).
     - This recurrence captures the idea that the maximum amount at the current house depends on the maximum amounts 
        possible at the previous two houses.

4. Return Result:
   - After filling the `dp` array, the maximum amount that can be robbed is stored in `dp[n - 1]` (the last element), so return this value.

Time Complexity: O(N), where N is the number of houses. We iterate through the array once to fill the DP table.
Space Complexity: O(N), due to the DP array storing values for each house.
*/

public class Solution {
  public int rob(int[] nums) {
      int n = nums.length;
      
      // If no houses, you can't rob anything.
      if (n == 0) return 0; 
      
      // If only one house, rob that house.
      if (n == 1) return nums[0]; 

      // Create DP array to store max stolen amount up to each house.
      int[] dp = new int[n];
      dp[0] = nums[0];                     // Max for 1 house is the money in that house.
      dp[1] = Math.max(nums[0], nums[1]);  // Max for 2 houses is the max of the two amounts.
      
      // Iterate through the houses from the third onwards.
      for (int i = 2; i < n; i++) {
          // At each house, you can either rob it and add to the max from two houses ago, or not rob it and use the max from the previous house.
          dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]); 
      }
      
      // The max money you can steal is the max amount possible up to the last house.
      return dp[n - 1]; 
  }
}

