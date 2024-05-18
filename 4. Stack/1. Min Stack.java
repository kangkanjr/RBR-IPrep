/**
 * https://leetcode.com/problems/min-stack/
 * 
 * The `MinStack` class implements a stack that supports the following operations:
 * - `push(x)`: Pushes an element `x` onto the stack.
 * - `pop()`: Removes the element on top of the stack.
 * - `top()`: Gets the top element of the stack.
 * - `getMin()`: Retrieves the minimum element in the stack.
 *
 * Approach:
 * - We use two stacks: `st` (main stack) and `mn` (minimum stack).
 * - When pushing an element, we compare it with the current minimum value (top of `mn` stack).
 *   - If `x` is less than or equal to the current minimum, we update `mn` by pushing `x` onto it.
 *   - Otherwise, we only push `x` onto the main stack (`st`).
 * - When popping an element, we check if it's the current minimum:
 *   - If it is, we also pop from `mn` to maintain the correct minimum value.
 *   - Always pop from the main stack (`st`).
 * - The top of `st` will always give us the top element, and the top of `mn` will give us the minimum element.
 *
 * Time Complexity:
 * - All operations (`push`, `pop`, `top`, and `getMin`) run in constant time (O(1)).
 *
 * Space Complexity:
 * - The space required for the two stacks (`st` and `mn`) is proportional to the number of elements in the stack.
 * - Therefore, the space complexity is O(n), where n is the number of elements in the stack.
 */


class MinStack {
  // Main stack to store elements
  Stack<Integer> st = new Stack<>();
  // Stack to keep track of minimum values
  Stack<Integer> mn = new Stack<>();

  /**
   * Pushes an element onto the stack.
   * When pushing, we compare the element with the current minimum value and
   * update `mn` accordingly.
   *
   * @param x The element to be pushed
   */
  public void push(int x) {
    // If the stack is empty or `x` is less than or equal to the current minimum,
    // update `mn`
    if (st.empty() || x <= mn.peek()) {
      mn.push(x);
    }
    // Always push `x` onto the main stack
    st.push(x);
  }

  /**
   * Removes the element on top of the stack.
   * When popping, we check if the element being removed is the current minimum
   * and adjust `mn`.
   */
  public void pop() {
    // If the top element of `st` is the current minimum, pop from `mn`
    if (st.peek().equals(mn.peek())) {
      mn.pop();
    }
    // Always pop from the main stack
    st.pop();
  }

  /**
   * Gets the top element of the stack.
   *
   * @return The top element from the main stack
   */
  public int top() {
    return st.peek();
  }