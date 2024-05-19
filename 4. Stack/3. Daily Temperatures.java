/**
 * https://leetcode.com/problems/daily-temperatures/
 * 
 * 
  Daily Temperatures - Finding Warmer Days Ahead

  Problem Description:
  Given an array of daily temperatures, determine how many days you have to wait after each day until a warmer temperature occurs. If no future day is warmer, the answer is 0.

  Algorithm - Monotonic Decreasing Stack:

  1. Initialization:
    - Create an array `result` to store the number of days to wait for each day. Initialize it with zeros.
    - Create a stack `stack` to hold indices of days. 
        - The stack will maintain a decreasing order of temperatures.
        - Each element in the stack represents a day that is potentially waiting for a warmer day.

  2. Iterate Backwards:
    - Start from the last day and move towards the first day. This ensures that we always look ahead for warmer days.

  3. Process Each Day:
    - While the stack is not empty AND the temperature on the top of the stack is less than or equal to the current day's temperature:
        - Pop the top element. This means we've found a warmer day for the day that was at the top of the stack.
    - If the stack is empty after popping, there are no warmer days ahead for the current day, so set `result[i]` to 0.
    - If the stack is not empty, the index at the top now represents the closest future day that is warmer. 
        - Calculate the distance (index difference) and store it in `result[i]`.
    - Push the current day's index onto the stack, as it might be a warmer day for future days.

  Why Monotonic Stack Works:

  - The stack maintains a decreasing order of temperatures.
  - Each element in the stack represents a day waiting for a warmer day.
  - When a warmer day is found, it resolves the waiting for all days on the stack that have lower or equal temperatures.

  Time and Space Complexity:

  - Time Complexity: O(n)
    - Each element is pushed onto the stack at most once and popped at most once, leading to linear time.

  - Space Complexity: O(n) (Worst Case)
    - In the worst case (strictly decreasing temperatures), all indices might be pushed onto the stack.

  Example:
  temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
  result        = [ 1,  1,  4,  2,  1,  1,  0,  0] 

 */


 class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n]; // Initialize result array with zeros
    Stack<Integer> stack = new Stack<>(); // Stack to store indices

    for (int i = n - 1; i >= 0; i--) { // Iterate from right to left
      int currentTemp = temperatures[i];

      // Pop elements from the stack until a warmer day is found
      while (!stack.isEmpty() && temperatures[stack.peek()] <= currentTemp) {
        stack.pop();
      }

      // Calculate days to wait (or 0 if no warmer day ahead)
      result[i] = stack.isEmpty() ? 0 : stack.peek() - i;

      // Push current index onto the stack for future comparisons
      stack.push(i);
    }

    return result;
  }
}