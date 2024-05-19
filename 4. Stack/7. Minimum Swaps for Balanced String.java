/*
https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/submissions/1262495427/

Minimum Swaps for Balanced String - Stack-Based Solution

Algorithm Overview:

1. Stack Initialization:
   - Create an empty stack to store unmatched opening brackets.

2. Iterate Through the String:
   - For each character `c` in the string `s`:
      - If `c` is an opening bracket '[', push it onto the stack.
      - If `c` is a closing bracket ']':
         - If the stack is not empty (meaning there's a matching open bracket), 
            pop the top element from the stack (they form a balanced pair).
         - If the stack is empty (meaning there's no open bracket to match), it indicates an unbalanced situation, 
            so increment the swap counter.

3. Calculate Swaps:
   - After processing all characters, the remaining elements in the stack are unmatched open brackets.
   - Since each swap can close two unmatched open brackets (one from the start and one from the end), 
        the minimum swaps required is half the stack size, rounded up.

Time and Space Complexity:

- Time Complexity: O(n) - Single iteration through the string.
- Space Complexity: O(n/2) in the worst case, when all characters are '['.
*/

class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int swaps = 0; // Counter for swaps

        for (char c : s.toCharArray()) {
            if (c == '[') { // Push open bracket onto the stack
                stack.push(c);
            } else { // Closing bracket
                if (!stack.isEmpty()) {
                    stack.pop(); // Pop matching open bracket if available
                } else {
                    swaps++;     // Unmatched closing bracket, needs a swap
                }
            }
        }

        // Remaining elements in the stack are unmatched open brackets
        return (stack.size() + 1) / 2; // Calculate swaps needed
    }
}
