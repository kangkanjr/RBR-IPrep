/*
https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

Minimum Cost of Ropes - Greedy Approach with Priority Queue

Problem Description:
There are given N ropes of different lengths, we need to connect these ropes into one rope. 
The cost to connect two ropes is equal to the sum of their lengths. The task is to connect the ropes with minimum cost.

Algorithm Overview (Greedy Approach with Min-Heap):

1. Create a Min-Heap (Priority Queue):
   - Initialize a `PriorityQueue` to store the lengths of the ropes. 
   - The priority queue will automatically maintain the elements in ascending order.

2. Add All Ropes:
   - Iterate through the `arr` array containing the lengths of the ropes.
   - Add each rope's length to the priority queue.

3. Repeatedly Combine and Add:
   - Initialize `totalCost` to 0.
   - While there are more than one rope left in the queue:
     - Poll (remove and retrieve) the two smallest ropes from the priority queue.
     - Calculate their combined length.
     - Add this combined length back to the priority queue.
     - Add the combined length to `totalCost`.

4. Return Total Cost:
   - After all ropes have been combined, the `totalCost` will represent the minimum cost of connecting all the ropes. Return it.

Time Complexity: O(N log N), where N is the number of ropes. 
    Each rope is added to the priority queue once, and each merge operation takes O(log N) time.
Space Complexity: O(N), as the priority queue can store up to N elements in the worst case.
*/
import java.util.PriorityQueue;

class Solution {
    public long minCost(long arr[], int n) {
        // Create a priority queue to store rope lengths in ascending order
        PriorityQueue<Long> pq = new PriorityQueue<>(); 

        // Add all rope lengths to the priority queue
        for (long rope : arr) { 
            pq.add(rope);
        }

        long totalCost = 0; // Total cost of connecting all ropes

        // Iterate until only one rope is left in the queue
        while (pq.size() > 1) { 
            // Get the two shortest ropes and remove them from the queue
            long first = pq.poll(); 
            long second = pq.poll();

            // Calculate the cost of combining these ropes and add it to the total cost
            long combined = first + second; 
            totalCost += combined;

            // Add the combined rope back to the priority queue
            pq.add(combined);
        }

        return totalCost; 
    }
}
