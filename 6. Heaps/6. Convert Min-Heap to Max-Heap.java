/*
https://www.geeksforgeeks.org/problems/convert-min-heap-to-max-heap-1666385109/1

Convert Min-Heap to Max-Heap - In-Place Conversion

Problem Description:
Given an array representing a min-heap, convert it in-place to a max-heap.

Algorithm Overview:

1. Identify Non-Leaf Nodes:
   - In a heap, the non-leaf nodes are the first half of the array. 
      The last non-leaf node is at index floor((N - 1) / 2), where N is the size of the heap.

2. Heapify in Reverse Level Order:
   - Start from the last non-leaf node and iterate backward towards the root.
   - For each non-leaf node, call a max-heapify function to ensure that the current node is greater than or equal to its children. 
   - The `maxHeapify` function works by comparing the node with its children and swapping it with the largest child (if necessary) 
      until the max-heap property is satisfied.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of elements in the heap. Each node is heapified once, 
    and the number of operations per heapify is proportional to the height of the node (which is at most log N).
- Space Complexity: O(1) - The conversion is done in-place, requiring only constant extra space.
*/
import java.util.Arrays;

public class MinHeapToMaxHeap {

    public static void convertMinToMaxHeap(int N, int[] arr) {
        // Start from the last non-leaf node and heapify in reverse level order
        for (int i = (N - 1) / 2; i >= 0; i--) {
maxHeapify(arr, i, N);
        }
    }

    // Function to heapify a subtree at given index i in max-heap order
    private static void maxHeapify(int[] arr, int i, int n) {
        int largest = i;         // Initialize largest as root
        int left = 2 * i + 1;    // left child index
        int right = 2 * i + 2;   // right child index

        // Find the largest among node i and its children
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);   // Swap with the largest child
            maxHeapify(arr, largest, n); // Recursively heapify the affected subtree
        }
    }
    
    // Helper function to swap elements at indices i and j in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // Driver program to test the above functions
    public static void main(String[] args)
    {
        int arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        int n = arr.length;
 
        System.out.print("Min Heap array : ");
        System.out.println(Arrays.toString(arr));
 
        convertMinToMaxHeap(n, arr);
 
        System.out.print("Max Heap array : ");
        System.out.println(Arrays.toString(arr));
    }

}
