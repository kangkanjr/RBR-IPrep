  /**
   * https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/
   * 
   * Finds the maximum difference between two elements in an array where the larger element appears after the smaller element.
   *
   * Algorithm:
   * 1. Base Case: Check if the array has less than two elements; if so, no valid difference exists, return -1.
   * 2. Initialize Variables:
   *    - min_ele_so_far: Keep track of the minimum element encountered so far. Initialized to the first element.
   *    - maxdiff_so_far: Keep track of the maximum difference found so far. Initialized to the difference between the first two elements.
   *    - curr_diff: Temporary variable to store the difference between the current element and min_ele_so_far.
   * 3. Iterate and Update:
   *    - Iterate through the array starting from the second element (index 1).
   *    - If the current element (nums[i]) is smaller than min_ele_so_far, update min_ele_so_far.
   *    - Otherwise:
   *        - Calculate curr_diff as the difference between nums[i] and min_ele_so_far.
   *        - If curr_diff is greater than maxdiff_so_far, update maxdiff_so_far.
   * 4. Final Check and Return:
   *    - If maxdiff_so_far remains 0 (meaning no increasing pair was found), return -1.
   *    - Otherwise, return maxdiff_so_far as the maximum difference.
   *
   * Time Complexity: O(n) - Single pass through the array.
   * Space Complexity: O(1) - Constant extra space used.
   */

class Solution {
  public int maximumDifference(int[] nums) {
      // Base case: Array size less than 2
      if (nums.length < 2) { 
          return -1; 
      }

      // Initialize variables
      int min_ele_so_far = nums[0];      // Minimum element seen so far
      int maxdiff_so_far = nums[1] - nums[0];  // Maximum difference seen so far
      int curr_diff = nums[1] - nums[0];        // Current difference

      // Iterate and update variables
      for (int i = 0; i < nums.length; i++) { 
          if (nums[i] < min_ele_so_far) {
              min_ele_so_far = nums[i];   // Update minimum element
          } else {
              curr_diff = nums[i] - min_ele_so_far;  // Calculate current difference
              if (curr_diff > maxdiff_so_far) {
                  maxdiff_so_far = curr_diff;  // Update maximum difference
              }
          }
      }

      // Check if maxdiff_so_far remains 0, indicating no increasing pair found
      if (maxdiff_so_far == 0) {
          return -1;
      }

      return maxdiff_so_far; // Return the maximum difference
  }
}
