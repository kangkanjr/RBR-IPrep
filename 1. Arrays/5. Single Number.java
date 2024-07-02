  /**
   * https://leetcode.com/problems/single-number/description/
   * 
   * Finds the single element that appears only once in an array where every other element appears twice.
   *
   * This solution leverages the bitwise XOR (^) operator's properties:
   * 1. Commutative: x ^ y = y ^ x
   * 2. Associative: (x ^ y) ^ z = x ^ (y ^ z)
   * 3. Identity: x ^ 0 = x
   * 4. Self-Inverse: x ^ x = 0
   *
   * By XOR-ing all elements together, the pairs of duplicates cancel each other out, leaving 
   * only the single number as the result.
   *
   * Time Complexity: O(n) - Single linear pass through the array.
   * Space Complexity: O(1) - Constant extra space.
   */
class Solution {
  public int singleNumber(int[] nums) {
      int res = 0; // Initialize result with 0 (identity element for XOR)

      // Iterate through the array
      for (int i = 0; i < nums.length; i++) {
          res ^= nums[i]; // XOR the current element with the running result
      }
      
      return res; // The final result will be the single unique number
  }
}
