/*
https://leetcode.com/problems/majority-element/description/

169. Majority Element - Binary Search Approach

Problem Description:
Given an integer array `nums` of size `n`, return the majority element. 
The majority element is the element that appears more than `⌊ n / 2 ⌋` times. 

Algorithm Overview (Binary Search on Sorted Array):

1. Sort the Array:
   - Sort the input array `nums` in ascending order to group identical elements together.

2. Binary Search for Potential Majority Elements:
   - Initialize variables `low` and `high` to the start and end of the array.
   - While `low` is less than or equal to `high`:
     - Calculate the middle index `mid`.
     - Find the first occurrence of the element at `mid` using a binary search (`findFirstIndex`).
     - Find the last occurrence of the element at `mid` using a binary search (`findLastIndex`).
     - If the number of occurrences (lastIndex - firstIndex + 1) is greater than half the array length, 
        we've found the majority element.
     - If the majority element is not found in the current range, adjust the search window:
       - If the majority element is expected to be smaller, set `high = mid - 1`.
       - If the majority element is expected to be larger, set `low = mid + 1`.

Time Complexity: O(N log N) due to the initial sorting. The binary search operations have a logarithmic complexity, 
but we perform them multiple times, so the overall complexity remains dominated by sorting.

Space Complexity: O(log N) for the sorting algorithm's recursion stack in the average case (or O(N) in the worst case for some sorting algorithms).
*/

class Solution {
  public int majorityElement(int[] nums) {
      Arrays.sort(nums);  // Sort the array
      int n = nums.length;
      int low = 0;
      int high = n - 1;

      while (low <= high) {
          int mid = low + (high - low) / 2;

          // Find the first occurrence of nums[mid] using binary search
          int firstIndex = findFirstIndex(nums, low, high, nums[mid]); 

          // Find the last occurrence of nums[mid] using binary search
          int lastIndex = findLastIndex(nums, low, high, nums[mid]);

          // Check if nums[mid] appears more than n/2 times
          if (lastIndex - firstIndex + 1 > n / 2) { 
              return nums[mid];
          }

          // Adjust the search window based on where we expect the majority element to be
          if (firstIndex > n / 2) {
              high = mid - 1; // Majority element must be in the left half
          } else {
              low = mid + 1;  // Majority element must be in the right half
          }
      }

      return -1; // Majority element not found (shouldn't happen in this problem)
  }

  // Binary search to find the first index of a target element
  private int findFirstIndex(int[] nums, int low, int high, int target) {
      while (low <= high) {
          int mid = low + (high - low) / 2;
          if (nums[mid] < target) {
              low = mid + 1;
          } else {
              high = mid - 1;
          }
      }
      return low; // If not found, returns the potential insertion point
  }

  // Binary search to find the last index of a target element
  private int findLastIndex(int[] nums, int low, int high, int target) {
      while (low <= high) {
          int mid = low + (high - low) / 2;
          if (nums[mid] <= target) { // Note the <= for last index
              low = mid + 1;
          } else {
              high = mid - 1;
          }
      }
      return high; // If not found, returns the last index where the target would be inserted
  }
}
