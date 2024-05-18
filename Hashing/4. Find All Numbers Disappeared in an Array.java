/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/1261121944/
 * 
 * 
 */

 import java.util.*;

public class Solution {
    /**
     * This method finds all the numbers that have disappeared in an array using in-place modification.
     * It iterates over each element in the array, treats the value of each element as an index (1-indexed) and marks the element at this index as negative.
     * Then it iterates over the array again and adds the index (1-indexed) of each positive element to the result.
     * The index of the positive numbers would be the numbers that did not appear in the array (since we did not mark them as negative).
     * 
     * @param nums the input array
     * @return a list of all numbers that disappeared in the array
     */
    public List<Integer> findDisappearedNumbersInPlace(int[] nums) {
        // Iterate over each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Treat the value of each element as an index (1-indexed)
            int index = Math.abs(nums[i]) - 1;
            // Mark the element at this index as negative to keep track of numbers that appear in the array
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Initialize a List to store missing elements in the array
        List<Integer> res = new ArrayList<>();
        // Iterate over the array again
        for (int i = 0; i < nums.length; i++) {
            // If an element is positive, it means its index (1-indexed) did not appear in the array
            if (nums[i] > 0) {
                // So, add the index (1-indexed) to the result
                res.add(i + 1);
            }
        }

        // Return the result
        return res;
    }

    /**
     * This method finds all the numbers that have disappeared in an array using a HashSet.
     * It initializes a HashSet to store the elements that are present in the array.
     * Then it iterates over each element in the array and adds it to the HashSet.
     * It initializes a List to store the missing elements in the array.
     * Then it iterates over each element in the range [1, N] (where N is the size of the array). If an element is not present in the HashSet, it means it's missing in the array, so it adds it to the result List.
     * 
     * @param nums the input array
     * @return a list of all numbers that disappeared in the array
     */
    public List<Integer> findDisappearedNumbersHashing(int[] nums) {
        // Initialize a HashSet to store the elements that are present in the array
        HashSet<Integer> mark = new HashSet<Integer>();

        // Iterate over each element in the array
        for (int i : nums) {
            // Add the element to the HashSet
            mark.add(i);
        }

        // Initialize a List to store missing elements in the array
        List<Integer> result = new ArrayList<>();

        // Iterate over each element in the range [1, N] (where N is the size of the array)
        for (int i = 1; i <= nums.length; i++) {
            // If an element is not present in the HashSet, it means it's missing in the array
            if (!mark.contains(i)) {
                // So, add it to the result List
                result.add(i);
            }
        }

        // Return the result
        return result;
    }
}
