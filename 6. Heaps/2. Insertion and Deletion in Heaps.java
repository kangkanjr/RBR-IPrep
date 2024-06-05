/*
https://www.geeksforgeeks.org/insertion-and-deletion-in-heaps/

https://www.youtube.com/watch?v=ywx-Onrdx4U&ab_channel=AnujBhaiya

Insertion and Deletion in Heaps - Java Implementation

Heap Data Structure:
- A complete binary tree where each node satisfies the heap property:
    - Min Heap: Each parent node is smaller than or equal to its children.
    - Max Heap: Each parent node is greater than or equal to its children.
- Commonly implemented using an array for efficient storage and access.
- Supports efficient operations:
    - Insertion (O(log N))
    - Deletion of the root (O(log N))
    - Finding minimum/maximum (O(1))

Key Concepts:

- Heapify: A process to restore the heap property after an element is inserted or removed. 
  It compares a node with its children and swaps it with the smaller/larger child until the heap property is satisfied.
- Percolate Up: Used during insertion to move a newly added element up the heap until it finds its correct position.
- Percolate Down (Heapify): Used during deletion of the root to move the last element to the root position and restore the heap property.
*/

public class MinHeap { // You can change this to MaxHeap for maximum heap implementation

  private int[] heap; // Array to store heap elements
  private int size;   // Current size of the heap
  private int capacity; // Maximum capacity of the heap

  public MinHeap(int capacity) {
      this.heap = new int[capacity];
      this.size = 0;
      this.capacity = capacity;
  }

  // Function to insert a new element into the heap
  public void insert(int element) {
      if (size == capacity) {
          System.err.println("Heap is full. Cannot insert.");
          return;
      }

      // 1. Insert the new element at the end of the heap
      int i = size;
      heap[i] = element;
      size++;

      // 2. Percolate up to maintain the heap property
      while (i > 0 && heap[i] < heap[(i - 1) / 2]) { // Compare with parent
          swap(heap, i, (i - 1) / 2);
          i = (i - 1) / 2; // Move up to the parent's index
      }
  }

  // Function to delete the root element from the heap
  public int delete() {
      if (size == 0) {
          System.err.println("Heap is empty. Cannot delete.");
          return -1;
      }

      // 1. Store the root value
      int root = heap[0];

      // 2. Replace the root with the last element
      heap[0] = heap[size - 1];
      size--;

      // 3. Heapify the root to restore the heap property
      minHeapify(0);

      return root; // Return the deleted root value
  }

  // Function to heapify a subtree with the root at given index
  private void minHeapify(int i) {
      int left = 2 * i + 1; // Index of left child
      int right = 2 * i + 2; // Index of right child
      int smallest = i;      // Assume current node is smallest

      // Find the smallest among the current node and its children (if they exist)
      if (left < size && heap[left] < heap[smallest]) {
          smallest = left;
      }
      if (right < size && heap[right] < heap[smallest]) {
          smallest = right;
      }

      // If smallest is not the current node, swap and recursively heapify
      if (smallest != i) {
          swap(heap, i, smallest);
          minHeapify(smallest); 
      }
  }
  private void swap(int [] arr,int i, int j){
      int temp=arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }
}
