/**
 * https://www.geeksforgeeks.org/find-missing-elements-of-a-range/
 * 
 * 
 * 
 */


import java.util.*;

public class Solution {
    /**
     * This method finds all the numbers that are in the given range but not in the array.
     * @param nums the input array
     * @param low the lower bound of the range
     * @param high the upper bound of the range
     * @return a list of all numbers that are in the range but not in the array
     */
    public List<Integer> findMissingNumbers(int[] nums, int low, int high) {
        // Step 1: Initialize a HashSet to store the elements that are present in the array
        HashSet<Integer> mark = new HashSet<Integer>();

        // Step 2: Iterate over each element in the array
        for (int i : nums) {
            // Add the element to the HashSet
            mark.add(i);
        }

        // Step 3: Initialize a List to store missing elements in the range
        List<Integer> result = new ArrayList<>();

        // Step 4: Iterate over each element in the range [low, high]
        for (int i = low; i <= high; i++) {
            // If an element is not present in the HashSet, it means it's missing in the array
            if (!mark.contains(i)) {
                // So, add it to the result List
                result.add(i);
            }
        }

        // Step 5: Return the result
        return result;
    }
}