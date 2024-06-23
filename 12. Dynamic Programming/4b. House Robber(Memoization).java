/*
https://leetcode.com/problems/house-robber/description/

198. House Robber - Dynamic Programming (Memoization)

Problem Description:
You are a robber planning to rob houses along a street. Each house has a certain amount of money stashed, but you 
cannot rob two adjacent houses because of connected alarm systems. Given an integer array `nums` representing the 
amount of money in each house, return the maximum amount of money you can rob tonight without alerting the police.

Algorithm Overview (Memoization):

1. Edge Cases:
   - Handle the case where there are no houses (`n == 0`) and return 0.

2. Memoization Array:
   - Create a `memo` array of size `n` to store the maximum amount that can be robbed up to each house.
   - Initialize all elements of `memo` to -1, indicating that the values haven't been calculated yet.

3. Recursive Function `robFrom`:
   - Parameters:
     - `i`: The current house index being considered.
     - `nums`: The array containing the money in each house.
     - `memo`: The memoization array to store results.
   - Base Case:
     - If `i` is out of bounds (beyond the last house), return 0 (no money can be robbed).
   - Memoization Check:
     - If the maximum amount for the current house (`memo[i]`) is already calculated, return it.
   - Recursive Calculation:
     - `robCurrent`: Recursively calculate the maximum amount that can be robbed if we choose to rob the current 
          house (`i`) and the houses that are not adjacent to it (`i + 2`).
     - `skipCurrent`: Recursively calculate the maximum amount that can be robbed if we skip the current house (`i + 1`).
     - Calculate `memo[i]` as the maximum of `robCurrent` and `skipCurrent`, indicating the maximum amount that can 
          be robbed up to the current house.
   - Return `memo[i]`: Return the calculated maximum amount.

4. Main Function `rob`:
   - Initialize the `memo` array and fill it with -1.
   - Start the recursion by calling `robFrom` with the initial index 0.

Time Complexity: O(N). Each house is visited only once due to memoization.
Space Complexity: O(N). The memoization array takes N space, and the recursion stack can also reach a depth of N in the worst case.
*/

public class Solution {
  public int rob(int[] nums) {
      int n = nums.length;
      if (n == 0) { // No houses, no money to rob
          return 0; 
      }
      
      // Initialize memoization array with -1 for all values.
      int[] memo = new int[n]; 
      Arrays.fill(memo, -1);
      // Start recursion from the first house (index 0)
      return robFrom(0, nums, memo); 
  }

  // Recursively computes the maximum money that can be robbed starting from house i.
  private int robFrom(int i, int[] nums, int[] memo) {
      if (i >= nums.length) { // Base case: out of bounds
          return 0;  
      }
      
      // Check if the max money for this house is already calculated
      if (memo[i] != -1) { 
          return memo[i];  
      }
      
      // If we rob this house, add its value to the max we can get from the one 2 steps away
      int robCurrent = nums[i] + robFrom(i + 2, nums, memo); 

      // If we skip this house, check the max we can get from the next house
      int skipCurrent = robFrom(i + 1, nums, memo); 

      // Take the best of the two options and store it for future reference
      memo[i] = Math.max(robCurrent, skipCurrent); 
      return memo[i]; // Return the maximum money
  }
}

