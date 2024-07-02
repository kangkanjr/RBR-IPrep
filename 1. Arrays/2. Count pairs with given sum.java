/**
 * https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
 * 
 * Count pairs with given sum:
 * Given an array of integers `arr` and a target sum `sum`, find the number of pairs of integers
 * in the array whose sum is equal to `sum`.
 *
 * Algorithm:
 * 1. HashMap Initialization: Create a HashMap to store the frequency of each element encountered.
 * 2. Iterate and Count Pairs: Loop through the array:
 *    - Calculate the complement needed for the current element to reach the target sum.
 *    - If the complement exists in the HashMap, increment the count by its frequency 
 *      (all previous occurrences of the complement can form a valid pair).
 *    - Update the frequency of the current element in the HashMap.
 * 3. Return Count: Return the final count of pairs that sum to the target value.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
  int getPairsCount(int[] arr, int sum) { 
      // code here
      HashMap<Integer, Integer> hash = new HashMap<>(); // Create HashMap to store frequency of elements
      int count = 0; // Initialize count of pairs to 0

      for(int i=0;i<arr.length;i++){ // Iterate through each element in the array
          if(hash.containsKey(sum - arr[i])) // If complement of current element exists in the HashMap
              count+= hash.get(sum-arr[i]);  // Increment count by the frequency of the complement

          hash.put(arr[i],hash.getOrDefault(arr[i],0)+1); // Update/store frequency of current element
      }

      return count; // Return the final count of pairs
  }
}
