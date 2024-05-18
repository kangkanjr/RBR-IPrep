/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 * 
 * https://www.youtube.com/watch?v=ypn0aZ0nrL4&ab_channel=NeetCodeIO
 * 
 * This method checks if the input array contains duplicate elements within a given range.
 * It uses a sliding window technique along with a HashSet to efficiently check for duplicates.
 *
 * @param nums The input array of integers.
 * @param k The maximum distance between duplicate numbers.
 * @return true if there exists at least one pair of indices i and j such that 
 *         nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *         Otherwise, it returns false.
 *
 * The method works as follows:
 * 1. A HashSet is used to store the elements in the current window of size k.
 * 2. We iterate over the array. For each element:
 *    - If the set already contains the current element, we return true because we've found a duplicate within k distance.
 *    - We add the current element to the set.
 *    - If the window size exceeds k, we remove the leftmost element from the set. This ensures that our set only contains elements within the current window.
 * 3. If we've gone through the entire array and haven't found any duplicates within k distance, we return false.
 */

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a set to store the elements in the current window
        HashSet<Integer> set = new HashSet<>();

        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            // If the set already contains the current element, return true
            if (set.contains(nums[i])) {
                return true;
            }

            // Add the current element to the set
            set.add(nums[i]);

            // Ensure the set only holds elements in the current window
            // If the window size exceeds k, remove the leftmost element from the set
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }

        // If no duplicates were found in any window, return false
        return false;
    }
}
