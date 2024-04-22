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
