/*
https://leetcode.com/problems/house-robber/description/

https://www.youtube.com/watch?v=73r3KWiEvyk&ab_channel=NeetCode

198. House Robber - Dynamic Programming (Tabulation with Space Optimization)

Problem Description:
You are a robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
but you cannot rob two adjacent houses because of connected alarm systems. Given an integer array `nums` representing 
the amount of money in each house, return the maximum amount of money you can rob tonight without alerting the police.

Algorithm Overview (Tabulation with Space Optimization):

1. Initialization:
   - `rob1`: Stores the maximum amount that can be robbed up to the previous house (initially 0).
   - `rob2`: Stores the maximum amount that can be robbed up to the current house (initially 0).

2. Iterate through Houses:
   - For each house `n` in `nums`:
     - `temp`: Calculate the maximum of:
       - Robbing the current house and the maximum from two houses before (`n + rob1`)
       - Not robbing the current house and using the maximum from the previous house (`rob2`)
     - Update `rob1` to the previous value of `rob2`.
     - Update `rob2` to the newly calculated `temp`.

3. Return Result:
   - After processing all houses, `rob2` holds the maximum amount that can be robbed. Return `rob2`.

Time Complexity: O(N), where N is the number of houses. We iterate through the array once.
Space Complexity: O(1) - Constant space is used, as we only need two variables (`rob1`, `rob2`) to keep track of the maximum values.
*/

public class Solution {
  public int rob(int[] nums) {
      int rob1 = 0;   // Max money robbed ending at the previous house
      int rob2 = 0;   // Max money robbed ending at the current house

      for (int n : nums) {
          // Calculate the max amount we can rob at this house
          int temp = Math.max(n + rob1, rob2); // Either rob this house or skip it

          // Update values for the next iteration
          rob1 = rob2;    // Move the current max to previous max
          rob2 = temp;    // Update the current max
      }

      return rob2; // Final max is the max we can rob up to the last house
  }
}
