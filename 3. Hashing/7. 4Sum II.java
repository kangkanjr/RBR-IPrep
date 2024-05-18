/**
 * https://leetcode.com/problems/4sum-ii/
 * 
  * The `fourSumCount` method calculates the number of tuples `(i, j, k, l)` such that:
 * `nums1[i] + nums2[j] + nums3[k] + nums4[l] = 0`.
 *
 * Approach:
 * 1. We create a hash map (`sumMap`) to store the sum of pairs from `nums1` and `nums2`.
 * 2. The nested loops calculate the sum of all possible pairs from `nums1` and `nums2`.
 * 3. For each sum, we increment its count in the map.
 * 4. Next, we iterate through `nums3` and `nums4`.
 * 5. For each pair `(num3, num4)`, we calculate the target sum needed to make the overall sum zero.
 * 6. We add the count of occurrences of the inverse of this target sum from `sumMap`.
 * 7. The final result is the total count of valid tuples.
 *
 * Time Complexity: O(n^2)
 *   - Constructing `sumMap`: O(n^2)
 *   - Iterating through `nums3` and `nums4`: O(n^2)
 * Space Complexity: O(n^2) (for the hash map)
 *
 * @param nums1 First input array
 * @param nums2 Second input array
 * @param nums3 Third input array
 * @param nums4 Fourth input array
 * @return Number of tuples with sum equal to zero
 */


 class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // Create a hash map to store the sum of pairs from nums1 and nums2
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int count = 0;

        // Calculate the sum of pairs from nums1 and nums2
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                // Increment the count for this sum in the map
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }

        // Check how many times the inverse of sum appears in nums3 and nums4
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int targetSum = -(num3 + num4); // Calculate the target sum needed to make overall sum zero
                count += sumMap.getOrDefault(targetSum, 0); // Add the count of occurrences from sumMap
            }
        }

        return count; // Return the total count of valid tuples
    }
}