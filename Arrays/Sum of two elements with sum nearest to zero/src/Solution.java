/**
 * The 'closestToZero' method finds a pair of elements in the array whose sum is closest to zero.
 * It first sorts the array in ascending order.
 * It then initializes two pointers at the start and end of the array, and a variable 'min_sum' to keep track of the minimum sum.
 * In a loop, it calculates the current sum by adding the values at the two pointers.
 * If the absolute value of the current sum is less than the absolute value of 'min_sum', it updates 'min_sum' with the current sum.
 * If the absolute values are equal but the current sum is positive, it also updates 'min_sum' with the current sum.
 * Depending on whether the current sum is less than or greater than zero, it moves the left pointer to the right or the right pointer to the left to get closer to zero.
 * This process continues until the two pointers meet.
 * At this point, 'min_sum' is the sum of the pair of elements that is closest to zero.
 * The method finally returns 'min_sum'.
 * This method effectively finds the pair of elements whose sum is closest to zero in O(n log n) time complexity due to sorting, and O(1) space complexity.
 */

import java.util.Arrays;

public class Solution {
    public static int closestToZero (int arr[], int n) {
        // Variables to keep track of the pair with minimum sum
        int left = 0, right = n-1;
        int min_sum = Integer.MAX_VALUE, sum = 0;
        // int min_left = left, min_right = n-1;

        // Sort the array
        Arrays.sort(arr);

        while(left < right) {
            sum = arr[left] + arr[right];

            // Update the pointers and minimum sum if the current sum is closer to zero
            if(Math.abs(sum) < Math.abs(min_sum)) {
                min_sum = sum;
                // min_left = left;
                // min_right = right;
            }
            else if(Math.abs(sum) == Math.abs(min_sum)) { // for the positive sum if values equal
                if(sum > min_sum) {
                    min_sum = sum;
                    // min_left = left;
                    // min_right = right;
                }
            }

            if(sum < 0) { // so that we move to a bigger number and sum get closer to 0
                left++;
            } else { // so that we move to a smaller number and sum get closer to 0
                right--;
            }
        }

        return min_sum;
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Define an array of integers
        int[] arr = {1, 60, -10, 70, -80, 85};

        // Call the closestToZero method
        int result = closestToZero(arr, arr.length);

        // Print the result
        System.out.println("The sum of two elements closest to zero is: " + result);
    }
}
