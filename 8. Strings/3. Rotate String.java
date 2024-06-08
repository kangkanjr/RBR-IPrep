/*
https://leetcode.com/problems/rotate-string/description/

796. Rotate String - String Manipulation Approach

Problem Description:
Given two strings `s` and `goal`, return `true` if and only if `s` can become `goal` after some number of shifts on `s`.

A shift on `s` consists of moving the leftmost character of `s` to the rightmost position.

Algorithm Overview:

1. Check for Equal Length:
   - If `s` and `goal` have different lengths, it's impossible for them to be rotations of each other, so return `false`.

2. Concatenate s with Itself:
   - Create a new string `s2` by concatenating `s` with itself (`s + s`).
   - This new string `s2` contains all possible rotations of the original string `s`.

3. Check for Substring:
   - If `goal` is a substring of `s2`, then `goal` is a rotation of `s`. Return `true`.
   - Otherwise, return `false`.

Time and Space Complexity:

- Time Complexity: O(N^2), where N is the length of the string `s`. The string concatenation and substring search operations can take up to quadratic time in the worst case.
- Space Complexity: O(N), due to the creation of the concatenated string `s2`.

Key Insight:
- By concatenating `s` with itself, we create a string that encompasses all possible rotations of `s`.  
- Then, a simple substring check determines if `goal` is one of those rotations.
*/

class Solution {
  public boolean rotateString(String s, String goal) {
      if (s.length() != goal.length()) {
          return false; // Different lengths, cannot be rotations
      }

      String s2 = s + s; // Concatenate s with itself to get all possible rotations

      return s2.contains(goal); // Check if goal is a substring of s2
  }
}
