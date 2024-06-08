/*
https://leetcode.com/problems/reverse-string/description/

344. Reverse String - In-Place Array Modification

Problem Description:
Write a function that reverses a string in-place. The input string is given as an array of characters `s`.

Algorithm Overview (Two Pointers):

1. Initialize Pointers:
   - `left`: Pointer starting at the beginning of the array (index 0).
   - `right`: Pointer starting at the end of the array (index s.length - 1).

2. Swap Characters and Move Pointers:
   - While `left` is less than `right`:
     - Swap the characters at indices `left` and `right`.
     - Increment `left`.
     - Decrement `right`.

Time Complexity: O(N), where N is the length of the string. We iterate through half of the array.
Space Complexity: O(1) - Constant extra space is used.
*/

class Solution {
  public void reverseString(char[] s) {
      int left = 0;      // Pointer to the leftmost character
      int right = s.length - 1; // Pointer to the rightmost character

      while (left < right) { // Loop until the pointers meet in the middle
          // Swap characters at left and right indices
          char temp = s[left]; 
          s[left] = s[right];
          s[right] = temp;

          // Move pointers towards the center
          left++;  
          right--;
      }
  }
}
