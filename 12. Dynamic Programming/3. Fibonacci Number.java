/*
509. Fibonacci Number - Iterative (Bottom-Up DP)

Problem Description:
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1F(N) = F(N - 1) + F(N - 2), for N > 1.

Given N, calculate F(N).

Algorithm Overview:

1. Handle Base Cases:
   - If N is 0, return 0.
   - If N is 1, return 1.

2. Initialize Variables:
   - `prev`: Stores the Fibonacci number at index N - 2 (initially 0).
   - `curr`: Stores the Fibonacci number at index N - 1 (initially 1).

3. Iterate and Calculate:
   - For i from 2 to N:
     - Calculate `next` as the sum of `prev` and `curr`.
     - Update `prev` to `curr`.
     - Update `curr` to `next`.

4. Return Result:
   - Return `curr`, which now holds the Fibonacci number at index N.

Time Complexity: O(N) - Single loop from 2 to N.
Space Complexity: O(1) - Constant space is used.
*/

class Solution {
  public int fib(int n) {
      if (n == 0) {
          return 0;
      }
      if (n == 1) {
          return 1;
      }

      int prev = 0;
      int curr = 1;
      for (int i = 2; i <= n; i++) {
          int next = prev + curr; // Calculate the next Fibonacci number
          prev = curr;           // Update prev for the next iteration
          curr = next;           // Update curr for the next iteration
      }

      return curr; // Return the nth Fibonacci number
  }
}
