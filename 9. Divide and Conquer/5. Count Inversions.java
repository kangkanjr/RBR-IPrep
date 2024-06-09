/*
https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

Count Inversions - Using Merge Sort

Problem Description:
Given an array of integers `arr`, count the number of inversions. 
An inversion is a pair of indices (i, j) where i < j and arr[i] > arr[j].

Algorithm Overview (Modified Merge Sort):

1. Divide:
   - Recursively divide the input array into two halves until each half contains only one element (or is empty).

2. Conquer (Merge and Count):
   - Merge the sorted halves back together in ascending order.
   - During the merging process, if an element from the right subarray is placed before an element from the left subarray, 
      it indicates an inversion. Count these inversions.

3. Combine:
   - Sum the inversion counts from the left and right subarrays, along with the inversions found during the merge step. 
      Return the total count.

Time Complexity: O(N log N) due to the recursive nature of merge sort. 
Each level of recursion splits the array in half, and there are log N levels. Each merge step takes linear time.
Space Complexity: O(N) due to the temporary arrays created during the merge process.
*/

import java.util.*;

class Solution {

    // Main function to count inversions
    static long inversionCount(long arr[], long N) {
        // Start the recursive merge sort and counting process
        return mergeSortAndCount(arr, 0, (int) N - 1); 
    }

    // Recursive function for merge sort and inversion counting
    private static long mergeSortAndCount(long[] arr, int left, int right) {
        long count = 0; // Initialize inversion count

        // Base case: array is already sorted or empty
        if (left < right) { 
            int mid = left + (right - left) / 2; // Calculate the middle index

            // Recursively count inversions in left and right subarrays
            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);

            // Merge the sorted subarrays and count inversions during merging
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    // Function to merge two sorted subarrays and count inversions
    private static long mergeAndCount(long[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // Size of left subarray
        int n2 = right - mid;    // Size of right subarray

        // Create temporary arrays to store the left and right subarrays
        long[] leftArr = new long[n1]; 
        long[] rightArr = new long[n2];

        // Copy data to temporary arrays
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left; // Indices for leftArr, rightArr, and original arr
        long swaps = 0; // Count of inversions during this merge

        // Merge the temporary arrays back into the original array in ascending order
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                // An inversion occurs here (right element is smaller than left element)
                arr[k++] = rightArr[j++]; 
                swaps += (n1 - i); // Count the remaining elements in the left subarray
            }
        }

        // Copy the remaining elements of leftArr, if any
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Copy the remaining elements of rightArr, if any
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }

        return swaps; // Return the inversion count for this merge
    }
}
