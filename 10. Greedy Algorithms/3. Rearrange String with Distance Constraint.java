/*
Refference: https://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-atleast-d-distance-away/

Rearrange String with Distance Constraint - Hashing and Greedy Approach

Problem Description:
Given a string `s` and an integer `d`, rearrange the characters of `s` such that any two adjacent characters are not the same, and any two occurrences 
of the same character are at least `d` distance apart. If such a rearrangement is not possible, return an empty string "".

Algorithm Overview:

1. Count Frequencies:
   - Create a HashMap `freq` to store the frequency of each character in the string `s`.

2. Max Heap:
   - Create a max-heap (PriorityQueue) `maxHeap` to store characters based on their frequency. 
      The character with the highest frequency will be at the top of the heap.

3. Build Result String:
   - Initialize an empty string `result` to build the rearranged string.
   - While the max-heap is not empty:
     - Pop the character with the highest frequency (`currentChar`) from the max-heap.
     - If there are not enough positions left to satisfy the distance constraint, return an empty string.
     - Append the `currentChar` to `result`.
     - Decrement the frequency of `currentChar` in the `freq` map.
     - If the frequency is still greater than 0, create a temporary pair (`[currentChar, frequency - 1]`) and add it to a waiting queue `waitingQueue`.
     - If the `waitingQueue` is not empty and the distance constraint is satisfied for the front element, dequeue it and add it back to the max-heap.

Time Complexity: O(N log A), where N is the length of the string and A is the size of the alphabet (26 for lowercase English letters). 
We insert each character into the max-heap once, and each insertion takes O(log A) time. 
Additionally, we iterate through the string and the waiting queue, which takes O(N) time.

Space Complexity: O(A), for storing the frequency map and the waiting queue.
*/
import java.util.*;

public class RearrangeString {

    public String rearrangeString(String s, int d) {
        Map<Character, Integer> freq = new HashMap<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]); // Max-heap by frequency
        Queue<int[]> waitingQueue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        // Count character frequencies
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Add characters to max-heap based on frequency
        for (char c : freq.keySet()) {
            maxHeap.offer(new int[]{c, freq.get(c)});
        }

        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll(); // Get the most frequent char and its count
            char currentChar = (char) top[0];
            int currentFreq = top[1];

            // Check if enough positions are available for the remaining occurrences of currentChar
            if (result.length() > 0 && result.charAt(result.length() - 1) == currentChar && result.length() % d != 0) {
                return ""; // Not enough positions to satisfy the distance constraint
            }

            result.append(currentChar); // Append the character to the result string

            // Decrement frequency and add to waitingQueue if not exhausted
            if (--currentFreq > 0) {
                waitingQueue.offer(new int[]{currentChar, currentFreq});
            }

            // Check if elements in waitingQueue can be moved back to maxHeap
            if (!waitingQueue.isEmpty()) {
                int[] front = waitingQueue.peek();
                if (result.length() - front[2] >= d) { // Check distance constraint
                    maxHeap.offer(waitingQueue.poll());
                }
            }
        }

        return result.toString(); // Return the rearranged string
    }
}
