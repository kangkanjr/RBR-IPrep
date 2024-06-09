/*
Reference: https://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/

Find a Fixed Point in a Sorted Array (Distinct Integers)

Problem Description:
Given a sorted array of distinct integers `arr`, find a fixed point (an index `i` where `arr[i] == i`). 
If multiple fixed points exist, return any of them. If no fixed point is found, return -1.

Algorithm Overview (Modified Binary Search):

1. Base Case:
   - If the array is empty (`low > high`), no fixed point exists (return -1).

2. Midpoint Check:
   - Calculate the middle index `mid = (low + high) / 2`.
   - If `arr[mid]` equals `mid`, we've found a fixed point (return `mid`).

3. Recursive Search:
   - If `mid + 1` is less than or equal to `arr[high]` (the value at the highest index), 
      it means there *might* be a fixed point in the right half of the array. Recursively search the right half.
   - If the recursive search in the right half finds a fixed point, return that fixed point.
   - If the recursive search in the right half doesn't find a fixed point, check if `mid - 1` is greater than or    
      equal to `arr[low]`. If so, there *might* be a fixed point in the left half, so recursively search the left half.

Time Complexity: O(log N) in the average and best cases, where N is the size of the array. 
  In the worst case (when every element is a fixed point), the time complexity can be O(N).

Space Complexity: O(log N) in the worst case due to the recursion stack.
*/

public class FixedPoint {

  // Function to find the fixed point using binary search
  public static int binarySearch(int arr[], int low, int high) {
      if (high >= low) {
          int mid = low + (high - low) / 2;

          // Check if mid is a fixed point (arr[mid] == mid)
          if (mid == arr[mid]) {
              return mid;
          }

          int res = -1;

          // If mid+1 is less than or equal to the value at the highest index,
          // there might be a fixed point in the right half
          if (mid + 1 <= arr[high]) {
              res = binarySearch(arr, mid + 1, high);
          }

          // If a fixed point was found in the right half, return it
          if (res != -1) { 
              return res;
          }

          // If mid-1 is greater than or equal to the value at the lowest index,
          // there might be a fixed point in the left half
          if (mid - 1 >= arr[low]) { 
              return binarySearch(arr, low, mid - 1);
          }
      }

      // No fixed point found in this subarray
      return -1;
  }

  // Driver Code (Example usage)
  public static void main(String[] args) {
      int arr[] = { -10, -5, 0, 3, 7 };
      int n = arr.length;
      System.out.println("Fixed Point is " + binarySearch(arr, 0, n - 1));
  }
}
