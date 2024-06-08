/*
https://geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1

Nuts and Bolts Problem - Matching and Sorting Using QuickSort and Predefined Order

Problem Description:
Given arrays `nuts` and `bolts` of equal length, where each element represents a nut and bolt of a unique size, 
match the nuts and bolts together. You can only compare a nut with a bolt to see if they match. 
The goal is to sort both arrays according to a predefined order specified in the `ORDER` string.

Algorithm Overview (QuickSort-like with Predefined Order):

1. Predefined Order:
   - A string `ORDER` defines the desired sorting order of the nuts and bolts.
   - A `HashMap` `ORDER_MAP` is created to quickly look up the order index of a character.

2. `matchPairs`:
   - Calls `quickSort` to sort both `nuts` and `bolts` arrays simultaneously.

3. `quickSort`:
   - Recursive function, similar to QuickSort:
     - Base Case: If the subarray has 0 or 1 elements, it's already sorted.
     - Choose Pivot: The last element of the `bolts` array is chosen as the pivot.
     - Partition Nuts: Partition the `nuts` array around the pivot bolt using the `partition` function.
     - Partition Bolts: Partition the `bolts` array around the matched nut from the previous step.
     - Recursion: Recursively sort the left and right subarrays of both `nuts` and `bolts`.

4. `partition`:
   - Similar to the partition function in QuickSort:
     - Uses the `ORDER_MAP` to determine the relative order of characters (instead of direct comparison).
     - Places elements smaller than the pivot before it, and elements larger than the pivot after it.
     - If an element equals the pivot, it is moved to the end to avoid incorrect placement.

Time Complexity: O(N log N) on average (similar to QuickSort).
Space Complexity: O(N) - due to the HashMap for storing the order and the recursion stack in the worst case. 
*/
import java.util.*;

class Solution {
    // Predefined order for sorting nuts and bolts
    private static final String ORDER = "!#$%&*?@^";

    // HashMap for quick lookup of character's order index
    private static final Map<Character, Integer> ORDER_MAP = new HashMap<>();

    // Static initializer to populate the ORDER_MAP
    static {
        for (int i = 0; i < ORDER.length(); i++) {
            ORDER_MAP.put(ORDER.charAt(i), i);
        }
    }
    
    // Main function to match pairs and sort nuts and bolts according to the predefined order
    void matchPairs(int n, char nuts[], char bolts[]) {
        quickSort(nuts, bolts, 0, n - 1);
    }

    // Recursive function to sort nuts and bolts using a modified QuickSort
    private void quickSort(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            // Partition nuts around the last bolt as pivot
            int pivotIndex = partition(nuts, low, high, bolts[high]);

            // Partition bolts around the corresponding nut as pivot
            partition(bolts, low, high, nuts[pivotIndex]);

            // Recursively sort the subarrays to the left and right of the pivot
            quickSort(nuts, bolts, low, pivotIndex - 1);
            quickSort(nuts, bolts, pivotIndex + 1, high);
        }
    }

    // Partition function using the predefined order
    private int partition(char[] arr, int low, int high, char pivot) {
        int i = low; // Smaller element index
        for (int j = low; j < high; j++) {
            if (ORDER_MAP.get(arr[j]) < ORDER_MAP.get(pivot)) { // Compare based on ORDER
                swap(arr, i, j); // Swap if smaller
                i++;
            } else if (ORDER_MAP.get(arr[j]) == ORDER_MAP.get(pivot)) { // Handle equal elements
                swap(arr, j, high); // Move pivot to end temporarily
                j--; // Decrement to re-evaluate swapped element
            } // No action for larger elements
        }
        swap(arr, i, high); // Place pivot in its final position
        return i; // Return the pivot index
    }

    // Simple swap function
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
