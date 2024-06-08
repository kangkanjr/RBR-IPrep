/*
https://leetcode.com/problems/first-unique-character-in-a-string/description/

387. First Unique Character in a String

Problem Description:
Given a string `s`, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Algorithm Overview (Using a Frequency Array):

1. Create Frequency Array:
   - Create an integer array `charFrequency` of size 26 (to store the frequency of each lowercase English letter).
   - Initialize all elements of the array to 0.

2. Count Character Frequencies:
   - Iterate through each character `c` in the input string `s`.
   - Increment the count in `charFrequency` at the index corresponding to the character (e.g., 'a' -> 0, 'b' -> 1, etc.).

3. Find First Unique Character:
   - Iterate through the string `s` again.
   - For each character `c`, check its frequency in the `charFrequency` array.
   - If the frequency is 1, return the index of the character.

4. Return -1:
   - If no unique character is found after iterating through the entire string, return -1.

Time Complexity: O(N), where N is the length of the string. We traverse the string twice, but each traversal is linear.
Space Complexity: O(1), as we use a fixed-size array of 26 to store character frequencies.
*/

class Solution {
  public int firstUniqChar(String s) {
      int[] charFrequency = new int[26]; // Array to count frequencies (26 for lowercase letters)

      // Count character frequencies
      for (int i = 0; i < s.length(); i++) {
          charFrequency[s.charAt(i) - 'a']++;
      }

      // Find the first unique character
      for (int i = 0; i < s.length(); i++) {
          if (charFrequency[s.charAt(i) - 'a'] == 1) { // If frequency is 1, it's unique
              return i; // Return the index of the first unique character
          }
      }
      return -1; // No unique character found
  }
}
