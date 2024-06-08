/*
https://www.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1

Maximum Occurring Character - Find the Most Frequent Character

Problem Description:
Given a string, find the character that occurs the most number of times in the string. If there are multiple characters with the same maximum frequency, 
return the lexicographically smallest one (the character that comes first alphabetically).

Algorithm Overview (Using a Frequency Array):

1. Create Frequency Array:
   - Create an array `freq` of size 256 (to cover all ASCII characters).
   - Initialize all elements of the array to 0.

2. Count Character Frequencies:
   - Iterate through each character `c` in the input string `line`.
   - Increment the frequency count of the corresponding ASCII value of `c` in the `freq` array.

3. Find Maximum Frequency and Character:
   - Initialize `maxCount` to 0 to track the highest frequency encountered so far.
   - Initialize `maxChar` to store the character with the maximum frequency.
   - Iterate through the `freq` array:
      - If the current frequency count is greater than `maxCount`, update `maxCount` and `maxChar`.
      - If the current frequency count is equal to `maxCount` and the current character is lexicographically smaller than `maxChar`, update `maxChar`.

4. Return Result:
   - Return the `maxChar`, which represents the maximum occurring character in the string.

Time Complexity: O(N), where N is the length of the string. We iterate through the string once to count frequencies and once more to find the max.
Space Complexity: O(1), as we use a fixed-size array of 256 elements.
*/

public class MaximumOccurringChar {
  public static char getMaxOccuringChar(String line) {
      int[] freq = new int[256]; // Array to store character frequencies

      // Count character frequencies
      for (char c : line.toCharArray()) {
          freq[c]++; // Increment the count for the ASCII value of the character
      }

      int maxCount = 0;      // Track the highest frequency encountered so far
      char maxChar = ' ';    // Store the character with the maximum frequency

      // Find the character with the maximum frequency (and lexicographically smallest if there are ties)
      for (int i = 0; i < 256; i++) {
          if (freq[i] > maxCount) { // If this character has a higher frequency
              maxCount = freq[i];   // Update maxCount
              maxChar = (char) i;   // Update maxChar
          } else if (freq[i] == maxCount && i < maxChar) { // If same frequency but lexicographically smaller
              maxChar = (char) i; // Update maxChar
          }
      }

      return maxChar; // Return the character with the maximum frequency
  }

  public static void main(String[] args) {
      String line = "sample string";
      char maxChar = getMaxOccuringChar(line);
      System.out.println("Max occurring character: " + maxChar);
  }
}
