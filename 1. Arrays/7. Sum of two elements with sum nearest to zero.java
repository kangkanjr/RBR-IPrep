/**
 * https://www.geeksforgeeks.org/problems/two-numbers-with-sum-closest-to-zero1737/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
 * 
 * Finds the sum of two elements in an array closest to zero.
 *
 * Algorithm:
 * 1. Initialization:
 *    - left: Pointer to the beginning of the array (index 0)
 *    - right: Pointer to the end of the array (index n-1)
 *    - min_sum: Variable to store the minimum sum closest to zero (initialized to MAX_VALUE)
 *    - sum: Temporary variable to store the sum of the current pair
 *    - min_left, min_right: Variables to store indices of the pair with min_sum
 *
 * 2. Sort Array: Sort the array in ascending order to facilitate the two-pointer approach.
 *
 * 3. Two-Pointer Iteration:
 *    - While `left < right`:
 *      - Calculate the current sum: `sum = arr[left] + arr[right]`
 *      - If the absolute value of `sum` is less than the absolute value of `min_sum`, update `min_sum` and the indices `min_left` and `min_right`.
 *      - If the absolute value of `sum` is equal to the absolute value of `min_sum` and `sum` is greater than `min_sum`, 
 *          update `min_sum` and the indices to prioritize the positive sum closer to zero.
 *      - If `sum < 0`, increment `left` (move to a larger element to increase the sum).
 *      - If `sum > 0`, decrement `right` (move to a smaller element to decrease the sum).
 *      - If `sum == 0`, the optimal pair is found, return 0.
 *
 * 4. Return Result: Return the minimum sum found (`min_sum`).
 *
 * Time Complexity: O(n log n) due to sorting
 * Space Complexity: O(1) (Constant extra space)
 */
class Solution {
  public static int closestToZero(int arr[], int n) {
      // Initialize variables
      int left = 0, right = n - 1;
      int min_sum = Integer.MAX_VALUE, sum = 0;
      int min_left = left, min_right = n - 1;

      // Sort the array in ascending order
      Arrays.sort(arr);

      while (left < right) {
          sum = arr[left] + arr[right];

          // Update min_sum if current sum is closer to zero
          if (Math.abs(sum) < Math.abs(min_sum)) {
              min_sum = sum;
              min_left = left;
              min_right = right;
          }
          // Update min_sum if current sum is equal in magnitude to the minimum sum, but positive
          if (Math.abs(sum) == Math.abs(min_sum)) { 
              if (sum > min_sum) {
                  min_sum = sum;
                  min_left = left;
                  min_right = right;
              }
          }

          // Move pointers towards a smaller absolute sum
          if (sum < 0) {
              left++;
          } else {
              right--;
          }
      }

      return min_sum;
  }
}
