  /**
   * https://www.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
   * 
   * Finds if there exists a triplet in the array that adds up to the given sum 'x'.
   * 
   * Algorithm (Two-Pointer Approach):
   * 1. Sort the Array: Sort the array in ascending order to facilitate the two-pointer approach.
   * 2. Iterate and Fix One Element: Loop through the array, fixing each element `arr[i]` as the first element of a potential triplet.
   * 3. Two-Pointer Search:
   *    - Initialize two pointers: `left = i + 1` (next element) and `right = n - 1` (last element).
   *    - While `left < right`:
   *      - Calculate `curr_sum = arr[i] + arr[left] + arr[right]`.
   *      - If `curr_sum == x`, a triplet is found, return true.
   *      - If `curr_sum < x`, increment `left` (need a larger value to increase the sum).
   *      - If `curr_sum > x`, decrement `right` (need a smaller value to decrease the sum).
   * 4. No Triplet Found: If the loop completes without finding a triplet, return false.
   *
   * Time Complexity: O(n^2) - Sorting takes O(n log n), and the nested loop iterates n * n times.
   * Space Complexity: O(1) - Constant extra space.
   */
class Solution {
  public static boolean find3Numbers(int arr[], int n, int x) {
      // Sort the array in ascending order
      Arrays.sort(arr);

      // Iterate over the array, fixing one element at a time
      for (int i = 0; i < n - 2; i++) { 
          int left = i + 1; // Initialize left pointer
          int right = n - 1; // Initialize right pointer

          while (left < right) {
              int curr_sum = arr[i] + arr[left] + arr[right]; // Calculate current sum

              if (curr_sum == x) {
                  return true; // Triplet found
              } else if (curr_sum < x) {
                  left++; // Move left pointer to the right (need a larger value)
              } else {
                  right--; // Move right pointer to the left (need a smaller value)
              }
          }
      }

      return false; // No triplet found
  }
}
