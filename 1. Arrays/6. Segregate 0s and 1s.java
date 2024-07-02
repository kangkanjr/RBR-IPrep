/**
 * https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
 * 
 * Segregates an array containing only 0s and 1s.
 *
 * This solution uses a two-pointer approach:
 *   - `left`:  Points to the next position where a '0' should be placed.
 *   - `right`: Points to the next position where a '1' should be placed.
 *
 * Algorithm:
 * 1. Initialize Pointers: Set `left` to 0 and `right` to the last index (n - 1).
 * 2. Iterate and Swap (if needed):
 *    - Move `left` rightward until a '1' is found or the pointers cross.
 *    - Move `right` leftward until a '0' is found or the pointers cross.
 *    - If `left` < `right`: Swap arr[left] and arr[right], then increment `left` and decrement `right`.
 *
 * Time Complexity: O(n) - Single pass through the array.
 * Space Complexity: O(1) - Constant extra space used.
 *
 * @param arr the array containing only 0s and 1s
 * @param n   the size of the array 
 */
void segregate0and1(int[] arr, int n) {
  int left = 0, right = n - 1; // Initialize pointers

  while (left < right) { // Continue until the pointers cross

      // Move left pointer to the right as long as we find 0s
      while (arr[left] == 0 && left < right) {
          left++;
      }

      // Move right pointer to the left as long as we find 1s
      while (arr[right] == 1 && left < right) {
          right--;
      }

      // If left is still less than right, swap elements and move pointers
      if (left < right) {
          arr[left] = 0; 
          arr[right] = 1;
          left++;
          right--;
      }
  }
}
