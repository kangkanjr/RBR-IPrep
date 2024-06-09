/*
Reference: https://www.geeksforgeeks.org/shuffle-2n-integers-format-a1-b1-a2-b2-a3-b3-bn-without-using-extra-space/

Shuffle Array In-Place (Divide and Conquer)

Problem Description:
This function shuffles an array of size 2n in-place, where the first n elements represent "x" values and the second n elements represent "y" values. 
The shuffled array should have the form [x1,y1,x2,y2,...,xn,yn].

Algorithm Overview:

1. Base Case:
   - If the subarray being shuffled has only 2 elements or less, it's already shuffled (or trivial to shuffle), so we return.

2. Divide:
   - Calculate the middle index (`mid`) of the subarray.
   - Recursively call `shuffleArray` on the left half (`start` to `mid`).
   - Recursively call `shuffleArray` on the right half (`mid + 1` to `end`).

3. Conquer (Interleave):
   - Interleave the elements of the shuffled left and right halves.
   - This is done by swapping elements from the middle of the left half with elements from the start of the right half, 
      gradually extending outward in both directions.

Time Complexity: O(n) - We process each element once during the merging phase.
Space Complexity: O(log n) - Due to the recursive calls, the space complexity is proportional to the depth of the recursion tree, 
    which is logarithmic in the size of the array.
*/

public class ShuffleArray {

  public static void shuffleArray(int[] arr, int start, int end) {
      // Base Case: If the subarray has 1 or 2 elements, it's already shuffled
      if (end - start <= 1) { 
          return;
      }

      // Find the middle index of the subarray
      int mid = (start + end) / 2;

      // Calculate the middle of the left half 
      int leftMid = (start + mid) / 2;

      // Interleave the elements
      int rightStart = mid + 1; // Starting index of the right half
      for (int i = leftMid + 1; i <= mid; i++) {
          swap(arr, i, rightStart++); // Swap elements between the halves
      }

      // Recursively shuffle the left and right halves
      shuffleArray(arr, start, mid);   // Shuffle the left half
      shuffleArray(arr, mid + 1, end); // Shuffle the right half
  }

  // Helper function to swap elements at indices i and j in the array
  private static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }

  // Driver Code (Example usage)
  public static void main(String[] args) {
      int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};

      shuffleArray(arr, 0, arr.length - 1); // Shuffle the entire array

      System.out.println(Arrays.toString(arr)); 
  }
}
