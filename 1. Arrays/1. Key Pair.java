/**
 * https://www.geeksforgeeks.org/problems/key-pair5616/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
 * 
 * Key Pair Problem:
 * Given an array 'arr' of integers and a target sum 'x', determine whether there exist 
 * two distinct elements in 'arr' whose sum is exactly equal to 'x'.
 *
 * Algorithm:
 * 1. HashMap Initialization: A HashMap is created to store encountered elements 
 *    and their complements (the value needed to reach the target sum). The element
 *    itself is used as the key, and a boolean 'true' is used as a placeholder value.
 *
 * 2. Iteration and Complement Calculation:
 *    The code iterates through the array. For each element 'arr[i]':
 *      - The complement is calculated: `complement = x - arr[i]`
 *      - The HashMap is checked to see if the complement has been seen before.
 *
 * 3. Pair Found or Store Element:
 *      - If the complement is found in the HashMap, it means a pair summing to 
 *        the target has been found, and 'true' is returned immediately.
 *      - If the complement is not found, the current element 'arr[i]' is added to the
 *        HashMap, marking it as seen.
 *
 * 4. No Pair Found: If the iteration completes without finding a complement pair,
 *    'false' is returned, indicating no such pair exists in the array.
 *
 * Time Complexity:
 *   - Average: O(n) - HashMap lookups are typically O(1) (constant time).
 *                     The array is traversed once.
 *   - Worst:  O(n^2) - In rare cases of extreme hash collisions, lookups could 
 *                     degrade to O(n), making the overall complexity quadratic.
 *                     This is highly unlikely in practice.
 *
 * Space Complexity:
 *   - O(n) - In the worst case (no pairs found), all array elements are stored in
 *            the HashMap.
 */

 class Solution {
  boolean hasArrayTwoCandidates(int arr[], int n, int x) {
      // Create a HashMap to store seen elements and their complements
      HashMap<Integer, Boolean> hash = new HashMap<>();

      // Iterate through the array
      for (int i = 0; i < arr.length; i++) {
          // Calculate the complement needed to reach the target sum
          int complement = x - arr[i];

          // Check if the complement is already in the HashMap
          if (hash.containsKey(complement)) {
              return true; // Found a pair!
          }

          // If not found, add the current element to the HashMap
          hash.put(arr[i], true);
      }

      // No pair found
      return false;
  }
}
