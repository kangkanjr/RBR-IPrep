/**
 * https://www.geeksforgeeks.org/batch/ppc-1/track/ppc-arrays/problem/reverse-array-in-groups0255
 * 
 * Reverse Array in Groups:
 * This code reverses the elements of an ArrayList in groups of a specified size 'k'. 
 * It uses a helper function `reverse` to reverse individual sublists within the ArrayList.
 *
 * Algorithm:
 * 1. Iterate in Steps of k: The `reverseInGroups` function iterates through the ArrayList, moving in steps of size 'k'.
 * 2. Determine Group Boundaries: For each iteration, it determines the 'start' (current index) and 'end' 
 *    (index of the last element in the group or the last element of the array if the remaining elements are less than 'k').
 * 3. Reverse Sublist: It calls the `reverse` function to reverse the elements from 'start' to 'end'.
 *
 * Time Complexity: O(n) - It performs a single pass through the array.
 * Space Complexity: O(1) - Constant extra space is used.
 */

 class Solution {
  // Function to reverse a sublist from index start to end
  private static void reverse(ArrayList<Long> arr, int start, int end) {
      while (start < end) {
          Collections.swap(arr, start, end);
          start++;
          end--;
      }
  }

  // Function to reverse array in groups of size k
  public static void reverseInGroups(ArrayList<Long> arr, int k) {
      int n = arr.size();
      for (int i = 0; i < n; i += k) {
          int start = i;
          int end = Math.min(i + k - 1, n - 1); // Ensure end doesn't go out of bounds
          reverse(arr, start, end);
      }
  }
}
