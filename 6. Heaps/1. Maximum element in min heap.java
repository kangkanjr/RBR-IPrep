/*
Find Maximum Element in a Min-Heap

https://www.geeksforgeeks.org/maximum-element-in-min-heap/ for reference only

Problem Description:
Given a min-heap (a complete binary tree where each node is smaller than or equal to its children), 
efficiently find the maximum element.

Algorithm Overview:

1. Build Min-Heap (Optional):
   - If the input array isn't already a min-heap, build it using the `buildMinHeap` function. 
      This function uses the `minHeapify` procedure to ensure the min-heap property is satisfied at each node.

2. Locate Leaf Nodes:
   - The maximum element in a min-heap must be one of the leaf nodes. This is due to the min-heap property where 
      parent nodes are always smaller than or equal to their children.
   - Start iterating through the array from the index representing the first leaf node, calculated as `(size / 2)`.

3. Find Maximum:
   - Initialize a variable `max` to store the maximum element found (initially set to `Integer.MIN_VALUE`).
   - Traverse the leaf nodes and update `max` if a larger element is found.

Time and Space Complexity:

- Time Complexity: O(N/2) (effectively O(N)), as we examine only the leaf nodes, which are roughly half of the total nodes in the heap.
- Space Complexity: O(1) (Constant) since we are not using any additional data structures.
*/

public class MaxInMinHeap {

  // Function to swap two elements in an array
  private static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }

  // Function to maintain the min-heap property at a given index
  private static void minHeapify(int[] arr, int i, int size) {
      int left = 2 * i + 1;   // Index of the left child
      int right = 2 * i + 2;  // Index of the right child
      int smallest = i;       // Assume the current node is the smallest

      // Find the smallest among the current node and its children (if they exist)
      if (left < size && arr[left] < arr[smallest]) {
          smallest = left;
      }
      if (right < size && arr[right] < arr[smallest]) {
          smallest = right;
      }

      // If the smallest is not the current node, swap and recursively heapify
      if (smallest != i) {
          swap(arr, i, smallest);
          minHeapify(arr, smallest, size);
      }
  }

  // Function to build a min-heap from an array
  private static void buildMinHeap(int[] arr, int size) {
      // Start from the last non-leaf node and heapify each node in reverse order
      for (int i = size / 2 - 1; i >= 0; i--) {
          minHeapify(arr, i, size);
      }
  }

  // Function to find the maximum element in the min-heap
  public static int findMaxElement(int[] arr, int size) {
      int max = Integer.MIN_VALUE; // Initialize to the smallest possible integer

      // Iterate through the leaf nodes
      for (int i = size / 2; i < size; i++) {
          if (arr[i] > max) {
              max = arr[i]; // Update max if a larger element is found
          }
      }

      return max;
  }
  
  // Driver code
  public static void main(String[] args) {
      int[] arr = {4, 5, 1, 7, 9, 3, 6};
      int size = arr.length;

      buildMinHeap(arr, size); // Optional: Build min-heap if not already done
      int maxElement = findMaxElement(arr, size);
      System.out.println("Maximum element in the min-heap: " + maxElement); 
  }

}
