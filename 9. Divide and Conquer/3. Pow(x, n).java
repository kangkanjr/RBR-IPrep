/*
https://leetcode.com/problems/powx-n/description/

50. Pow(x, n) - Calculate x Raised to the Power n (Recursive Binary Exponentiation with Edge Case Handling)

Problem Description:
Implement pow(x, n), which calculates `x` raised to the power `n` (x^n).

Algorithm Overview (Recursive Binary Exponentiation):

1. Base Cases:
   - If `n` is 0, return 1 (x^0 = 1 for any x).
   - If `x` is 0, return 0 (0^n = 0 for any n > 0).

2. Handle Negative Exponent:
   - If `n` is negative, make it positive and calculate the reciprocal (`1 / result`).

3. Recursive Calculation (Binary Exponentiation):
   - If `n` is even, calculate `x^(n/2)` recursively and square the result (`half * half`).
   - If `n` is odd, calculate `x^((n-1)/2)` recursively, square the result, and multiply it by `x`.

Time Complexity: O(log n). Each recursive call halves the exponent, leading to logarithmic time.
Space Complexity: O(log n) due to the recursion call stack.
*/

class Solution {
  public double myPow(double x, int n) {
      // Base case: n is 0, return 1
      if (n == 0) {
          return 1.0; 
      }
      // Base case: x is 0, return 0 (except when n == 0, handled above)
      if (x == 0) {
          return 0.0;
      }

      // Handle negative exponent
      long N = n;             // Use long to avoid integer overflow when negating Integer.MIN_VALUE
      if (N < 0) {
          x = 1 / x;         // Invert the base for negative exponents
          N = -N;            // Make the exponent positive
      }

      // Call recursive helper function to calculate x raised to the power N
      return power(x, N); 
  }

  private double power(double x, long n) {
      // Base case: n is 0
      if (n == 0) {
          return 1.0;
      }

      // Recursive step: calculate x^(n/2)
      double half = power(x, n / 2);

      // If n is even, return half * half
      if (n % 2 == 0) { 
          return half * half;
      } else {
          // If n is odd, return half * half * x
          return half * half * x; 
      }
  }
}
