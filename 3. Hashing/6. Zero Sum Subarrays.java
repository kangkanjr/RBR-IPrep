/**
 * https://www.geeksforgeeks.org/problems/zero-sum-subarrays1825/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
 * 
 * https://www.youtube.com/watch?v=HJWiQP5Kl-Q&ab_channel=CuriousChahar
 * 
 * This function counts the number of subarrays with a sum equal to 0.
 *
 * Algorithm:
 * 1. Initialize a HashMap called prefixSumCount to store prefix sums and their counts.
 * 2. Set the initial sum to 0 and the initial count to 0.
 * 3. Put an entry in prefixSumCount with key 0 and value 1 (to handle subarrays starting from index 0).
 * 4. Traverse through the input array:
 *    a. Add the current element to the sum.
 *    b. Check if the current sum exists in the HashMap:
 *       - If it does, increment the count by the value associated with that sum.
 *    c. Insert the current sum into the HashMap (or update its count).
 * 5. Return the total count of zero-sum subarrays.
 */


 class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) {
         // Initialize a HashMap to store prefix sum and its count
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int sum = 0; // Variable to keep track of the sum of prefix elements
        int count = 0; // Total count of zero-sum subarrays

        // Initialize the prefix sum with 0 (to handle subarrays starting from index 0)
        prefixSumCount.put(0, 1);

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            // Add the element to the sum
            sum += arr[i];

            // Check if the current sum exists in the HashMap
            if (prefixSumCount.containsKey(sum)) {
                // Increment the count by the value associated with that sum
                count += prefixSumCount.get(sum);
            }

            // Insert the current sum into the HashMap
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        // Return the total count
        return count;
    }
}