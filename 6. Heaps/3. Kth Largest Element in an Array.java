/*
https://leetcode.com/problems/kth-largest-element-in-an-array/description/

215. Kth Largest Element in an Array - Min-Heap Solution

Problem Description:
Given an integer array `nums` and an integer `k`, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Algorithm Overview:

1. Build a Min-Heap:
    - Create a min-heap (priority queue) with a capacity of `k`.
    - Iterate through the first `k` elements of the `nums` array and add them to the min-heap.

2. Iterate and Maintain Heap:
    - Continue iterating through the remaining elements of the `nums` array (starting from index `k`).
    - For each element `num`:
       - If `num` is greater than the minimum element in the heap (top of the heap):
         - Remove the minimum element from the heap (poll).
         - Add `num` to the heap (offer).

3. Return Kth Largest:
    - After processing all elements, the top of the min-heap will be the kth largest element. Return it using `heap.peek()`.

Time and Space Complexity:

- Time Complexity: O(N log K), where N is the length of the array. The most time-consuming operations are adding and removing elements from the min-heap, which take O(log K) time.
- Space Complexity: O(K), as we maintain a min-heap of size K to store the K largest elements.
*/
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap (priority queue) with capacity 'k'
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add the first 'k' elements to the min-heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // Process the remaining elements
        for (int i = k; i < nums.length; i++) {
            // If the current element is larger than the min-heap's top, replace the top
            if (nums[i] > minHeap.peek()) {  
                minHeap.poll();         // Remove the smallest element
                minHeap.offer(nums[i]);  // Add the larger element
            }
        }

        // The top of the min-heap is now the kth largest element
        return minHeap.peek(); 
    }
}
