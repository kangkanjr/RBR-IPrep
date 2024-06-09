/*
https://www.geeksforgeeks.org/problems/missing-element-of-ap2228/1

Missing Element of AP - Binary Search Approach

Problem Description:
Given a sorted array `arr` representing an arithmetic progression with exactly one missing element, find and return the missing element.

Algorithm Overview:

1. Calculate Common Difference:
   - Calculate the common difference (`diff`) of the AP: `diff = (arr[n - 1] - arr[0]) / n`.

2. Binary Search (Recursive Helper Function):
   - `findMissingUtil(arr, left, right, diff)`:
     - Base Case: If `left >= right`, the subarray has 0 or 1 elements, and there's no missing element within it (return -1).
     - Calculate `mid` as the middle index.

     - Check Next Element:
       - If `arr[mid + 1]` is not equal to `arr[mid] + diff`, it means the missing element is the expected value after `arr[mid]`.  Return `arr[mid] + diff`.

     - Check Previous Element:
       - If `mid > 0` (not the first element) and `arr[mid]` is not equal to `arr[mid - 1] + diff`, 
          it means the missing element is the expected value before `arr[mid]`. Return `arr[mid - 1] + diff`.

     - Determine Search Direction:
       - If `arr[mid]` is equal to what it should be in a complete AP (`arr[0] + mid * diff`), the left part of the subarray is correct, 
          and the missing element is in the right part. Recursively call `findMissingUtil` on the right half.
       - Otherwise, the missing element is in the left part. Recursively call `findMissingUtil` on the left half.

Time Complexity: O(log N), where N is the size of the array, due to the binary search approach.
Space Complexity: O(log N) in the worst case, due to the recursive call stack.
*/

class Solution {
  // Main function to find the missing element
  int findMissing(int[] arr, int n) {
      // Calculate the common difference of the arithmetic progression
      int diff = (arr[n - 1] - arr[0]) / n; 
      
      // Call the recursive helper function to perform the binary search
      return findMissingUtil(arr, 0, n - 1, diff); 
  }

  // Recursive helper function for binary search
  private int findMissingUtil(int[] arr, int left, int right, int diff) {
      // Base case: 0 or 1 element left, no missing element in this subarray
      if (left >= right) {
          return -1; 
      }

      int mid = left + (right - left) / 2; // Calculate middle index

      // Check if the next element is missing
      if (arr[mid + 1] != arr[mid] + diff) { 
          return arr[mid] + diff;  // Return the missing element
      }

      // Check if the previous element is missing (only if not the first element)
      if (mid > 0 && arr[mid] != arr[mid - 1] + diff) { 
          return arr[mid - 1] + diff; // Return the missing element
      }

      // Determine which half to search next
      if (arr[mid] == arr[0] + mid * diff) { 
          // Left half is complete, search the right half
          return findMissingUtil(arr, mid + 1, right, diff);
      } else {
          // Left half has the missing element, search there
          return findMissingUtil(arr, left, mid - 1, diff); 
      }
  }
}
