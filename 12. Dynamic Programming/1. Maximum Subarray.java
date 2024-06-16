/*
https://leetcode.com/problems/maximum-subarray/description/

53. Maximum Subarray - Kadane's Algorithm

Problem Description:
Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Algorithm Overview (Kadane's Algorithm):

1. Initialization:
   - `maxSum`: A variable to store the maximum sum found so far (initialized to the first element of the array).
   - `currentSum`: A variable to store the sum of the current subarray being considered (initialized to the first element of the array).

2. Iterate through the Array:
   - Starting from the second element, iterate through the `nums` array.
   - For each element `num`:
     - Update `currentSum`: Take the maximum of either the current element itself (`num`) or the sum of the previous subarray 
      plus the current element (`currentSum + num`). This decision is based on whether it's better to start a new subarray or continue the existing one.
     - Update `maxSum`: Keep track of the overall maximum sum encountered during the traversal.

3. Return Result:
   - After processing all elements, return the `maxSum`, which is the sum of the maximum subarray.

Time Complexity: O(N), where N is the length of the array. We iterate through the array once.
Space Complexity: O(1) - We only use constant extra space for the variables.
*/

class Solution {
  public int maxSubArray(int[] nums) {
      int maxSum = nums[0];          // Initialize to the first element's value
      int currentSum = nums[0];     // Current subarray sum starts with the first element

      for (int i = 1; i < nums.length; i++) {
          // Decide to either start a new subarray or continue the existing one
          currentSum = Math.max(nums[i], currentSum + nums[i]); 

          // Update maxSum if the current subarray sum is larger
          maxSum = Math.max(maxSum, currentSum); 
      }

      return maxSum; // Return the maximum sum found
  }
}
