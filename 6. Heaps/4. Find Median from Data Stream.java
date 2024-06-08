/*
https://leetcode.com/problems/find-median-from-data-stream/description/

295. Find Median from Data Stream - Two Heaps Solution

Problem Description:
Design a data structure that supports the following two operations:

1. void addNum(int num): Adds an integer number from the data stream to the data structure.
2. double findMedian(): Returns the median of all elements so far. The median is the middle value in an ordered integer list. 
  If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.

Algorithm Overview:

1. Data Structures:
   - `maxHeap`: A max-heap to store the smaller half of the numbers.
   - `minHeap`: A min-heap to store the larger half of the numbers.

2. `addNum(int num)`:
   - If the heaps are empty or `num` is smaller than or equal to the top of `maxHeap`, add it to `maxHeap`.
   - Otherwise, add it to `minHeap`.
   - Rebalance the heaps:
     - If `maxHeap` has more than one extra element than `minHeap`, remove the top of `maxHeap` and add it to `minHeap`.
     - If `minHeap` has more elements than `maxHeap`, remove the top of `minHeap` and add it to `maxHeap`.
   - This ensures that the heaps always have roughly the same size.

3. `findMedian()`:
   - If the heaps have the same size, the median is the average of the tops of both heaps.
   - Otherwise, the median is the top of the heap with more elements.

Time and Space Complexity:

- Time Complexity:
   - `addNum(int num)`: O(log N) for inserting into a heap and potentially removing/inserting again for rebalancing.
   - `findMedian()`: O(1), as we only need to peek at the top elements of the heaps.

- Space Complexity: O(N), to store all the numbers in the two heaps.
*/
import java.util.PriorityQueue;
import java.util.Collections;


class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Smaller half of numbers
    private PriorityQueue<Integer> minHeap; // Larger half of numbers

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap with reverse order
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Add to the max-heap if it's empty or smaller than the maxHeap's top
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num); // Otherwise, add to the min-heap
        }

        // Rebalance the heaps (keep size difference at most 1)
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); // Move from maxHeap to minHeap
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll()); // Move from minHeap to maxHeap
        }
    }

    public double findMedian() {
        // If heaps have equal size, median is the average of their tops
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2.0; 
        } else {
            // If maxHeap is larger, its top is the median (since it has the middle element)
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();  
        }
    }
}
