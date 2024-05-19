/**
 * https://www.geeksforgeeks.org/problems/reverse-a-stack/1
 * 
 * 
  Stack Reversal using Recursion and "Insert at Bottom" Technique

  This Java class (`Solution`) provides a solution for reversing the elements within a stack using a recursive approach. The core idea involves two key functions:

  1. `insertAtBottom(Stack<Integer> stack, int x)`:
    - Purpose: Inserts the element `x` at the very bottom of the stack.
    - Mechanism:
      - Base Case: If the stack is empty, simply push `x`.
      - Recursive Case:
        - Pop the top element and hold it temporarily.
        - Recursively call `insertAtBottom` to insert `x` below the current level.
        - Push the previously popped element back on top.

  2. `reverse(Stack<Integer> stack)`:
    - Purpose: Reverses the order of elements in the stack.
    - Mechanism:
      - Base Case: If the stack is empty, return (nothing to reverse).
      - Recursive Case:
        - Pop the top element and hold it temporarily.
        - Recursively call `reverse` on the remaining stack to reverse it.
        - Use `insertAtBottom` to place the popped element at the bottom of the now-reversed stack.

  How It Works:

  The `reverse` function systematically dismantles the stack by popping elements. Each popped element is held in temporary storage while the rest of the stack is recursively reversed. Once the base case (empty stack) is reached, `insertAtBottom` starts placing the elements back in the stack, but in reverse order. This reversal happens at each level of the recursion, ultimately resulting in a fully reversed stack.

  Time and Space Complexity:

  - Time Complexity: O(n^2) due to nested recursion in `insertAtBottom`. Each element is popped and then inserted at the bottom, leading to quadratic time.
  - Space Complexity: O(n) due to the recursion depth. In the worst case, the recursion can go as deep as the number of elements in the stack, consuming space on the call stack.

 */


 class Solution{
    
  // Inserts the element 'x' at the bottom of the stack
  public static void insertAtBottom(Stack<Integer> stack, int x) {
      if (stack.isEmpty()) {
          stack.push(x); // Base case: empty stack, just push
          return;
      }

      // Remove top element and hold it
      int temp = stack.pop();

      // Recursively insert 'x' at the bottom
      insertAtBottom(stack, x);

      // Push the removed element back on top
      stack.push(temp);
  }
  
   // Recursive function to reverse the stack
  static void reverse(Stack<Integer> stack){
      if (stack.isEmpty()) {
          return; // Base case: empty stack, nothing to reverse
      }

      // Remove top element and hold it temporarily
      int temp = stack.pop();

      // Recursively reverse the remaining stack
      reverse(stack);

      // Insert the removed element at the bottom
      insertAtBottom(stack, temp);
  }
}