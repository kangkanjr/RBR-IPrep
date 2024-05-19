/*
https://www.geeksforgeeks.org/problems/count-the-reversals0401/1

Count the Reversals: Minimum Reversals for Balanced Expression (Stack-Based)

Problem Description:
Given a string `s` consisting of only opening and closing curly brackets '{' and '}', find out the minimum number 
    of reversals ('{' to '}' or vice-versa) required to convert the string into a balanced expression.

Algorithm:
1. Check for Odd Length:
   - If the length of the input string `s` is odd, it's impossible to balance, so return -1.
2. Stack Initialization:
   - Create an empty stack to keep track of unmatched opening brackets.
3. Iterate and Process:
   - For each character in the string `s`:
     - If the character is an opening bracket '{', push it onto the stack.
     - If the character is a closing bracket '}':
        - If the stack is not empty and the top element is a matching '{', pop the top element (they form a balanced pair).
        - Otherwise, this closing bracket is unmatched:
            - Increment the `reversals` counter (one reversal is needed for this bracket).
            - Push an opening bracket '{' onto the stack. This simulates reversing the unmatched closing bracket to an open bracket, 
                potentially allowing it to be balanced later.
4. Calculate Final Reversals:
   - After processing all characters, the stack contains any remaining unmatched opening brackets.
   - Each remaining opening bracket needs to be reversed to a closing bracket, so add the stack size to the `reversals` count.
   - Additionally, for every two remaining open brackets, one additional reversal is needed to form a balanced pair. 
    Therefore, add half the stack size (integer division to round down) to the `reversals` count.
5. Return Result:
   - The final value of `reversals` is the minimum number of reversals needed to balance the string `s`.

Time & Space Complexity:
- Time: O(n) - Single pass through the string.
- Space: O(n) worst case - If the input is all opening brackets, the stack will grow to the size of the input.
*/
public static int countMinReversals(String s) {
    if (s.length() % 2 != 0) {
        return -1; // Odd length cannot be balanced
    }

    Stack<Character> stack = new Stack<>();
    int reversals = 0;

    for (char ch : s.toCharArray()) {
        if (ch == '{') {
            stack.push(ch); 
        } else { // Closing bracket
            if (!stack.isEmpty() && stack.peek() == '{') {
                stack.pop(); // Found matching pair, remove from stack
            } else {
                reversals++;     // Unmatched closing bracket
                stack.push('{'); // Simulate reversal to potentially match later
            }
        }
    }

    // Calculate final reversals (one per unmatched '{' and one per pair of '{')
    reversals += stack.size() / 2;

    return reversals;
}
