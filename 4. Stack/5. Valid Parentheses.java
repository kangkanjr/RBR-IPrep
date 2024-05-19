/*
https://leetcode.com/problems/valid-parentheses/description/


Valid Parentheses - Checking for Balanced Brackets

Problem Description:
Given a string `s` containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same typeof brackets.
2. Open brackets must be closed in the correct order.

Algorithm - Stack-Based Approach:

1. Initialization:
   - Create an empty stack to store opening brackets.

2. Iterate Through the String:
   - For each character `c` in the string `s`:
      - If `c` is an opening bracket ('(', '{', or '['), push it onto the stack.
      - If `c` is a closing bracket:
         - If the stack is empty or the top element of the stack does not match the corresponding opening bracket, return false (invalid).
         - If the stack is not empty and the top element matches the corresponding opening bracket, pop the top element from the stack (successfully closed).

3. Final Check:
   - After processing all characters, if the stack is empty, return true (all brackets were properly closed).
   - Otherwise, return false (some opening brackets were not closed).

Time and Space Complexity:

- Time Complexity: O(n)
   - We iterate through the string once, and each character is pushed/popped from the stack at most once.

- Space Complexity: O(n) (Worst Case)
   - In the worst case, the string contains only opening brackets, and all of them would be pushed onto the stack.
*/

class Solution {
   public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();

       for (char c : s.toCharArray()) {
           // If the character is an opening bracket, push it onto the stack
           if (c == '(' || c == '{' || c == '[') {
               stack.push(c);
           } else { // The character is a closing bracket
               // If the stack is empty, there's no matching opening bracket, so it's invalid
               if (stack.isEmpty()) {
                   return false;
               }

               char top = stack.pop(); // Get the top element (potential opening bracket)
               // Check if the popped element is the matching opening bracket
               if (!isMatchingPair(top, c)) {
                   return false; // Mismatched brackets, invalid
               } 
               // If it's a match, the opening bracket is successfully closed, continue to the next character
           }
       }

       // If the stack is not empty after processing all characters, there are unclosed opening brackets
       return stack.isEmpty(); 
   }

   // Helper function to check if two characters are a matching pair of brackets
   private boolean isMatchingPair(char open, char close) {
       return (open == '(' && close == ')') ||
              (open == '{' && close == '}') ||
              (open == '[' && close == ']');
   }
}
