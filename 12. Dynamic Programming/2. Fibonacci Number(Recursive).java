/*
https://leetcode.com/problems/fibonacci-number/

509. Fibonacci Number - Recursive with Memoization (Top-Down DP)

Problem Description:
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1F(N) = F(N - 1) + F(N - 2), for N > 1.

Given N, calculate F(N).

Algorithm Overview:

1. Base Cases:
   - If N is 0 or 1, return N directly.
2. Memoization:
   - Create a `memo` array to store already calculated Fibonacci numbers.
3. Recursive Calculation:
   - If `F(N)` is already calculated and stored in `memo[N]`, return it.
   - Otherwise, recursively calculate `F(N - 1)` and `F(N - 2)`.
   - Store the result in `memo[N]` and return it.

Time Complexity: O(N). Each number is calculated only once due to memoization.
Space Complexity: O(N) for the memoization array.
*/

class Solution {
  public int fib(int n) {
      int[] memo = new int[n + 1]; // Array to store calculated Fibonacci numbers
      Arrays.fill(memo, -1); // Initialize memo values to -1 (not calculated yet)

      return fibHelper(n, memo); 
  }

  private int fibHelper(int n, int[] memo) {
      // Base cases: F(0) = 0, F(1) = 1
      if (n == 0 || n == 1) {
          return n;
      }

      // If F(n) is already calculated, return it from memo
      if (memo[n] != -1) {
          return memo[n];
      }

      // Calculate and store F(n) in memo
      memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
      return memo[n];
  }
}
