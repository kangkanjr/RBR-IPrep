/*
https://leetcode.com/problems/search-in-rotated-sorted-array/description/

33. Search in Rotated Sorted Array - Binary Search with Pivot Detection

Problem Description:
Given an array of integers `nums` sorted in ascending order and then rotated at an unknown pivot index, 
find the index of the `target` value in the rotated array. If not found, return -1.

Algorithm Overview:

1. Initialize:
   - Set `left` to 0 (start index) and `right` to `nums.length - 1` (end index).

2. Binary Search with Pivot Detection:
   - While `left` is less than or equal to `right`:
     - Calculate `mid` index.
     - If `nums[mid]` equals `target`, return `mid` (target found!).
     - Check if the left half (`nums[left]` to `nums[mid]`) is sorted:
       - If the left half is sorted, and the target is within that range, search the left half (update `right = mid - 1`).
       - Otherwise, search the right half (update `left = mid + 1`).
     - Check if the right half (`nums[mid]` to `nums[right]`) is sorted:
       - If the right half is sorted, and the target is within that range, search the right half (update `left = mid + 1`).
       - Otherwise, search the left half (update `right = mid - 1`).

3. Target Not Found:
   - If the loop completes without finding the `target`, return -1.

Time Complexity: O(log N), where N is the length of `nums`. 
The algorithm performs a binary search on a sorted portion in each iteration, halving the search space.
Space Complexity: O(1) - Constant extra space is used.
*/

class Solution {
  public int search(int[] nums, int target) {
      int left = 0; 
      int right = nums.length - 1;

      while (left <= right) {
          int mid = left + (right - left) / 2;

          // Check if the middle element is the target
          if (nums[mid] == target) { 
              return mid;
          }

          // Check if the left half is sorted (includes mid)
          if (nums[left] <= nums[mid]) {
              // If target is within the sorted left half
              if (nums[left] <= target && target < nums[mid]) { 
                  right = mid - 1; // Search in the left half
              } else {
                  left = mid + 1;  // Search in the right half
              }
          } else { // Right half is sorted (includes mid)
              // If target is within the sorted right half
              if (nums[mid] < target && target <= nums[right]) {
                  left = mid + 1; // Search in the right half
              } else {
                  right = mid - 1; // Search in the left half
              }
          }
      }
      return -1; // Target not found
  }
}
