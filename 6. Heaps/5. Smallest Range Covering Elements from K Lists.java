/*
https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/

632. Smallest Range Covering Elements from K Lists - Heap Approach

Problem Description:
You have k lists of sorted integers in non-decreasing order. 
Find the smallest range that includes at least one number from each of the k lists. 
We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

Algorithm Overview (Min-Heap):

1. Create a Min-Heap:
    - Create a min-heap `minHeap` to store elements from each list along with their list index and element index.
    - Initialize the heap with the first element from each list.
    - Keep track of the maximum value (`max`) among the elements in the heap.

2. Iterate and Shrink Range:
    - While the heap contains elements from all k lists:
        - Pop the minimum element (`minVal`) from the heap.
        - Update the `rangeStart` and `rangeEnd` if the current range (`max` - `minVal`) is smaller than the previous best range.
        - If the popped element has a next element in its list, add it to the heap and update `max` if needed.
        - If any list is exhausted (no more elements), break the loop since we can't cover all lists anymore.

3. Return Smallest Range:
    - Return the smallest range found (`[rangeStart, rangeEnd]`).

Time Complexity: O(N log K), where N is the total number of elements across all lists and K is the number of lists. 
We process each element once and perform log K operations for heap insertion/deletion.
Space Complexity: O(K), for the min-heap storing one element from each list.
*/

class Solution {
  public int[] smallestRange(List<List<Integer>> nums) {
      int k = nums.size(); // Number of lists
      PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // Min-heap based on element value

      int max = Integer.MIN_VALUE;
      int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

      // Initialize the heap with the first element from each list
      for (int i = 0; i < k; i++) {
          minHeap.offer(new int[] { nums.get(i).get(0), i, 0 }); 
          max = Math.max(max, nums.get(i).get(0)); // Update max if needed
      }

      while (minHeap.size() == k) { // Continue while all lists are represented in the heap
          int[] minEntry = minHeap.poll();
          int minVal = minEntry[0], row = minEntry[1], col = minEntry[2];

          // Check if we found a smaller range
          if (max - minVal < rangeEnd - rangeStart) {
              rangeStart = minVal;
              rangeEnd = max;
          }

          // If there are more elements in this list, add the next one to the heap
          if (col + 1 < nums.get(row).size()) { 
              minHeap.offer(new int[] { nums.get(row).get(col + 1), row, col + 1 });
              max = Math.max(max, nums.get(row).get(col + 1)); // Update max
          } else {
              break; // If a list is exhausted, we can't find a range covering all lists
          }
      }

      return new int[] { rangeStart, rangeEnd };
  }
}
