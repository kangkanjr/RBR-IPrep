/**
 * The 'find3Numbers_set' method finds a triplet in the array that adds up to a given sum.
 * It uses a set data structure to store the elements of the array.
 * For each element in the array, it calculates the current sum by subtracting the current element from the given sum.
 * It then iterates over the array starting from the next element.
 * For each subsequent element, it calculates the result by subtracting the current element from the current sum.
 * If the result is present in the set, it means we have found a triplet that adds up to the given sum, so it returns true.
 * If no triplet is found after checking all elements, it returns false.
 * This method effectively finds a triplet in the array that adds up to a given sum in O(n^2) time complexity and O(n) space complexity.
 */

/**
 * The 'find3Numbers_sort' method finds a triplet in the array that adds up to a given sum.
 * It first sorts the array in ascending order.
 * Then, for each element in the array, it initializes two pointers at the next element and the last element.
 * It calculates the current sum by adding the values at the current element and the two pointers.
 * If the current sum is equal to the given sum, it means we have found a triplet that adds up to the given sum, so it returns true.
 * If the current sum is less than the given sum, it moves the left pointer to the right to increase the current sum.
 * If the current sum is greater than the given sum, it moves the right pointer to the left to decrease the current sum.
 * It continues this process until the two pointers meet.
 * If no triplet is found after checking all elements, it returns false.
 * This method effectively finds a triplet in the array that adds up to a given sum in O(n^2) time complexity and O(1) space complexity.
 */

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    // Function to find a triplet using set
    public static boolean find3Numbers_set(int arr[], int n, int x) {

        for(int i=0;i<n-2;i++){
            // Create a new set to store the elements
            HashSet<Integer> set = new HashSet<>();
            // Calculate the current sum by subtracting the current element from the given sum
            int curr_sum = x - arr[i];
            // Iterate over the array starting from the next element
            for(int j=i+1;j<n;j++){
                // Calculate the result by subtracting the current element from the current sum
                int res = curr_sum - arr[j];
                // If the result is present in the set, return true
                if(set.contains(res))
                    return true;
                // Add the current element to the set
                set.add(arr[j]);
            }
        }
        // If no triplet is found, return false
        return false;
    }

    // Function to find a triplet using sorting and two pointers
    public static boolean find3Numbers_sort(int arr[], int n, int x) {
        // Sort the array
        Arrays.sort(arr);

        for(int i=0; i<n-2; i++){
            // Initialize two pointers
            int left = i+1;
            int right = n-1;
            // While there are elements between the two pointers
            while(left < right){
                // Calculate the current sum
                int curr_sum = arr[i] + arr[left] + arr[right];
                // If the current sum is equal to the given sum, return true
                if(curr_sum == x)
                    return true;
                    // If the current sum is less than the given sum, move the left pointer to the right
                else if(curr_sum < x)
                    left++;
                    // If the current sum is greater than the given sum, move the right pointer to the left
                else
                    right--;
            }
        }
        // If no triplet is found, return false
        return false;
    }

    public static void main(String[] args) {
        // Define the array and the sum
        int arr[] = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        int arr_size = arr.length;

        // Call the function using set
        boolean result_set = find3Numbers_set(arr, arr_size, sum);
        // Print the result
        if (result_set)
            System.out.println("Array has three elements with given sum (using set)");
        else
            System.out.println("Array doesn't have three elements with given sum (using set)");

        // Call the function using sorting and two pointers
        boolean result_sort = find3Numbers_sort(arr, arr_size, sum);
        // Print the result
        if (result_sort)
            System.out.println("Array has three elements with given sum (using sorting and two pointers)");
        else
            System.out.println("Array doesn't have three elements with given sum (using sorting and two pointers)");
    }
}
