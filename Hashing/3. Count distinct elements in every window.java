/**
 * https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
 * 
 * https://www.youtube.com/watch?v=j48e8ac7r20&ab_channel=AnujBhaiya
 * 
 * 
* This method counts the distinct elements in every window of size k in the given array.
 * It uses a HashMap to store the elements and their counts, and an ArrayList to store the counts of distinct numbers in each window.
 *
 * @param arr The input array of integers.
 * @param n The size of the array.
 * @param k The size of the window.
 * @return An ArrayList of integers representing the counts of distinct numbers in each window.
 *
 * The method works as follows:
 * 1. A HashMap is created to store the elements of the array and their counts.
 * 2. An ArrayList is created to store the counts of distinct numbers in each window.
 * 3. The first window of size k is traversed and each element is added to the map.
 * 4. The count of distinct numbers in the first window is added to the ArrayList.
 * 5. The remaining array is traversed. For each window, the first element of the previous window is removed from the map and the new element is added to the map.
 * 6. The count of distinct numbers in each window is added to the ArrayList.
 * 7. Finally, the ArrayList is returned.
 *
 * This method efficiently counts the distinct elements in every window of size k by maintaining a sliding window and using the count of the previous window while sliding.
 * It uses a HashMap to keep track of the elements in the current window and their counts, and an ArrayList to store the results.
 */

 class Solution{
    ArrayList<Integer> countDistinct(int arr[], int n, int k){
         // Create a HashMap to store the elements and their counts
        Map<Integer, Integer> map = new HashMap<>();

        // Create an ArrayList to store the counts of distinct numbers in each window
        ArrayList<Integer> result = new ArrayList<>();

        // Traverse the first window and add elements to the map
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Add the count of distinct numbers in the first window to the result
        result.add(map.size());

        // Traverse the remaining array
        for (int i = k; i < n; i++) {
            // Remove the first element of the previous window
            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }

            // Add the element of the current window
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            // Add the count of distinct numbers in the current window to the result
            result.add(map.size());
        }

        // Return the result
        return result;
    }
}