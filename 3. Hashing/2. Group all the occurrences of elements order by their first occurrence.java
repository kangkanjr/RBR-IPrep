/**
 * Given an array of integers, write a function in Java that groups all the occurrences of elements in the array, ordered by their first occurrence. The function should print the elements of the array in the order of their grouping.
 * 
 * 
 * This method groups all the occurrences of elements in the given array, ordered by their first occurrence.
 * It uses a LinkedHashMap to maintain the order of elements as it was in the input array.
 *
 * @param arr The input array of integers.
 *
 * The method works as follows:
 * 1. A LinkedHashMap is created to store the elements of the array and their counts. 
 *    The LinkedHashMap maintains the insertion order, which ensures that the elements are grouped by their first occurrence.
 * 2. The array is traversed and each element is added to the map. If the element is already present in the map, its count is incremented.
 * 3. Finally, the map is traversed and each element is printed as many times as its count, resulting in the elements being grouped by their first occurrence.
 */

 public class Main {
    // Function to group all the occurrences of elements
    public static void groupElements(int arr[]) {
        // Create a LinkedHashMap to maintain the order of elements
        Map<Integer, Integer> map = new LinkedHashMap<>();

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            // If the element is present in the map, increment its count
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            // If the element is not present in the map, add it to the map with count 1
            else {
                map.put(arr[i], 1);
            }
        }

        // Traverse through the map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // Print the element as many times as its count
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};
        groupElements(arr);
    }
}