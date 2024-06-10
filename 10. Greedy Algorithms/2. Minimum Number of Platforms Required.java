/*
For refference: https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

Minimum Number of Platforms Required for a Railway Station

Problem Description:
Given the arrival and departure times of all trains that reach a railway station, 
find the minimum number of platforms required for the station so that no train waits.  

Algorithm Overview (Sorting and Greedy Approach):

1. Sort Arrival and Departure Times:
    - Sort the `arrivals` and `departures` arrays in ascending order. 
    - This is the crucial step, as it allows us to process the events in chronological order, which simplifies the logic for tracking platform usage.

2. Initialize Variables:
    - `platformsNeeded`: Tracks the number of platforms currently in use (starts at 1 for the first train).
    - `maxPlatforms`: Stores the maximum number of platforms needed at any time (starts at 1).
    - `i`: Index for iterating through `arrivals`.
    - `j`: Index for iterating through `departures`.

3. Process Events in Order:
    - Iterate through both arrays using the `i` and `j` indices.
    - Compare the arrival time of the next train (`arrivals[i]`) with the departure time of the current train (`departures[j]`).
      - If the arrival happens before or at the same time as the departure, we need an additional platform (`platformsNeeded++`).
      - If the arrival happens after the departure, it means a platform has become free (`platformsNeeded--`).
    - Update `maxPlatforms` if we need more platforms than we've seen so far.

4. Return Result:
   - After processing all events, the `maxPlatforms` variable holds the minimum number of platforms required. Return it.

Time Complexity: O(N log N), where N is the number of trains. The sorting steps dominate the time complexity.
Space Complexity: O(1) - We use only a constant amount of extra space.
*/
import java.util.Arrays;

class Solution {

    static int findPlatform(int[] arrivals, int[] departures, int n) {
        // Sort arrival and departure times in ascending order
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int platformsNeeded = 1;     // Initially, one platform is needed for the first train
        int maxPlatforms = 1;         // Maximum platforms needed so far
        int i = 1, j = 0;             // Pointers for arrival and departure arrays

        // Process all events (arrivals and departures) in sorted order
        while (i < n && j < n) { 
            // If next event is arrival, increment count of platforms needed
            if (arrivals[i] <= departures[j]) { 
                platformsNeeded++;
                i++;
            } else { // Next event is departure, decrement count of platforms needed
                platformsNeeded--;
                j++;
            }

            // Update maxPlatforms if needed
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded); 
        }

        return maxPlatforms; // Return the maximum number of platforms needed at any time
    }
}
