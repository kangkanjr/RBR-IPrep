/*
https://leetcode.com/problems/online-stock-span/description/

https://www.youtube.com/watch?v=slYh0ZNEqSw&ab_channel=NeetCode


Online Stock Span - Tracking Consecutive Lower/Equal Stock Prices

Problem Description:

Write a class `StockSpanner` which collects daily price quotes for some stock, 
and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) 
for which the price of the stock was less than or equal to today's price.

Algorithm - Monotonic Decreasing Stack:

1. Data Structures:
   - `prices`:  A stack to store the prices of stocks in a decreasing order.
   - `spans`: A stack to store the corresponding spans (number of consecutive days of lower/equal prices) 
                for the stocks in the `prices` stack.

2. `StockSpanner()`: Constructor
   - Initializes both stacks to be empty.

3. `next(int price)`:
   - Calculates the span for the current `price`.
   - Initializes a variable `span` to 1 (representing the current day itself).
   - While the `prices` stack is not empty AND the top price on the stack is less than or equal to the current `price`:
      - Pop the top price and its corresponding span from the stacks.
      - Add the popped span to the current `span`. This accumulates the spans of all previous days where the price was lower or equal.
   - Push the current `price` and its calculated `span` onto the stacks.
   - Return the final `span`.

Time and Space Complexity:

- Time Complexity: Amortized O(1) per `next()` call.  Each price is pushed and popped at most once.
- Space Complexity: O(N), where N is the maximum number of calls to `next()`.  In the worst case, all prices are in increasing order, 
and the stacks store all prices and spans.

Example:

StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2 (70 >= 60)
stockSpanner.next(60);  // return 1 (60 < 70)
stockSpanner.next(75);  // return 4 (75 >= 70, 60, 80, 100)
stockSpanner.next(85);  // return 6 (85 >= 80, 75, 60, 70, 60, 100)
*/


class StockSpanner {
    private Stack<Integer> prices;
    private Stack<Integer> spans;

    public StockSpanner() {
        prices = new Stack<>();
        spans = new Stack<>();
    }

    public int next(int price) {
        int span = 1;  // Initialize span for the current day

        // Find previous days with lower or equal prices and accumulate their spans
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            span += spans.pop();
        }

        prices.push(price); // Push the current price onto the stack
        spans.push(span);   // Push the calculated span onto the stack

        return span; // Return the span for the current day
    }
}
