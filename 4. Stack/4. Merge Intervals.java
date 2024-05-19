/*
https://leetcode.com/problems/merge-intervals/description/


Merge Intervals - Efficiently Combining Overlapping Ranges Using a Stack

Problem Description:
Given an array of intervals where `intervals[i] = [start_i, end_i]`, merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the ranges.

Algorithm Overview:

1. Sort Intervals:
   - Sort the intervals based on their starting points in ascending order.
   - This ensures that overlapping intervals are processed consecutively, making merging easier.

2. Initialize Stack:
   - Create a stack to hold intervals during the merging process.
   - Push the first interval onto the stack.

3. Iterate and Merge:
   - Loop through the remaining intervals (starting from the second).
   - For each interval:
      - Case 1: No Overlap
         - If the current interval's start time is greater than or equal to the end time of the interval on top of the stack, there is no overlap.
         - Push the current interval onto the stack. 
      - Case 2: Overlap
         - If the current interval's start time is less than the end time of the top interval, there is an overlap.
         - Merge the intervals by updating the end time of the top interval to be the maximum of its current end time and the current interval's end time.

4. Build Result:
   - After processing all intervals, the stack contains the merged intervals.
   - Create a result array and pop the intervals off the stack to populate it.
   - Reverse the result array to get the correct order.

Time and Space Complexity:

- Time Complexity: O(n log n)
   - Sorting the intervals takes O(n log n) time.
   - Iterating and merging takes O(n) time as we process each interval once.

- Space Complexity: O(n) (Worst Case)
   - In the worst case (no overlaps), the stack can hold all the original intervals.

Why Use a Stack:

- The stack helps maintain a "current" interval to compare against.
- It allows for efficient merging of overlapping intervals by simply updating the top element.
- The final result is readily available in the stack after processing all intervals.
*/

class Solution {
  public int[][] merge(int[][] intervals) {
      if (intervals.length <= 1) {
          return intervals; // No merging needed if only one or no intervals
      }

      // Sort intervals by start time
      Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

      Stack<int[]> stack = new Stack<>();
      stack.push(intervals[0]); // Push the first interval onto the stack

      // Iterate through the remaining intervals
      for (int i = 1; i < intervals.length; i++) {
          int[] top = stack.peek();
          // If there's no overlap, push the current interval onto the stack
          if (top[1] < intervals[i][0]) {
              stack.push(intervals[i]);
          } else { // Overlap: Merge by updating the top interval's end time
              top[1] = Math.max(top[1], intervals[i][1]);
          }
      }

      // Build the result array from the stack
      int[][] result = new int[stack.size()][2];
      for (int i = stack.size() - 1; i >= 0; i--) {
          result[i] = stack.pop();
      }
      return result;
  }
}
