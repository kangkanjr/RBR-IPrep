/*
https://www.geeksforgeeks.org/problems/circular-tour-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

Circular Tour - Finding a Starting Point for a Truck

Problem Description:
You have a circular route with gas stations. Each station is represented by two arrays:
    - `petrol`: An array containing the amount of petrol available at each station.
    - `distance`: An array containing the distance to the next station.

Determine if there exists a starting gas station from which you can travel around the entire circuit once, 
returning to the starting station. You cannot refill at any other station.

Algorithm Overview:

1. Initialization:
   - Initialize variables:
     - `start`: The current potential starting point (index) of the tour, initially set to 0.
     - `end`: The next gas station to visit, initially set to 1 (next index in a circular fashion).
     - `curr_petrol`: The current amount of petrol remaining in the truck, initially set to the difference between 
                        petrol at the starting station and the distance to the next station.
2. Iterate and Check Feasibility:
   - Iterate until we either find a valid starting point or exhaust all possibilities:
     - While the current petrol is negative AND we haven't checked all stations:
       - Remove the current starting point from consideration as it cannot complete the tour.
       - Update `curr_petrol` by subtracting the petrol and distance of the removed station.
       - Move `start` to the next index in a circular manner.
       - If `start` returns to 0 (we've checked all stations), there is no valid starting point, so return -1.
     - If the current petrol is non-negative, it means we can potentially complete the tour from the current starting point.
       - Add the petrol and distance of the next station (`end`) to `curr_petrol`.
       - Move `end` to the next index in a circular manner.

3. Return Result:
   - If we successfully reach the starting point again with a non-negative `curr_petrol`, 
      it means we've found a valid starting point. Return the `start` index.
   - Otherwise, no valid starting point exists, so return -1.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of gas stations. We iterate through the arrays once.
- Space Complexity: O(1) - We use only a constant amount of extra space for variables.
*/

public class CircularTour {
  public static int tour(int petrol[], int distance[]) {
      int n = petrol.length;
      int start = 0;
      int end = 1;
      int curr_petrol = petrol[start] - distance[start]; // Initial petrol 

      while (end != start || curr_petrol < 0) { // Continue until we return to the start with enough petrol

          // If we can't reach the next station from the current starting point,
          // remove the starting point and try the next one.
          while (curr_petrol < 0 && start != end) {
              curr_petrol -= petrol[start] - distance[start]; // Remove contribution of current start
              start = (start + 1) % n; // Move to next potential start in a circular way
              if (start == 0) {
                  return -1; // We've circled back to 0, meaning no solution is possible
              }
          }

          // If we have enough petrol to reach the next station, add it to the current petrol.
          curr_petrol += petrol[end] - distance[end]; 
          end = (end + 1) % n; // Move to the next station
      }

      return start; // We found a valid starting point
  }
}
