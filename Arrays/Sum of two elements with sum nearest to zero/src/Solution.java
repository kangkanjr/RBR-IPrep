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
