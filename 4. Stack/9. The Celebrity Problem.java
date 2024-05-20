/*
https://www.geeksforgeeks.org/problems/the-celebrity-problem/1

https://www.youtube.com/watch?v=bIvK_2OEzk0&ab_channel=PhysicsMania-MohitGupta%5BIITBHU%5D

The Celebrity Problem - Finding the Popular Person

Problem Description:
In a party of N people, only one person is known to everyone. This person is the "celebrity." The celebrity doesn't know anyone at the party. 
We can only ask questions like "Does person A know person B?". 
Find the celebrity (if there is one) in the minimum number of questions.

Algorithm Overview (Stack-Based):

1. Stack Initialization:
   - Push all people (represented by their indices 0 to N-1) onto a stack.

2. Potential Celebrity Elimination:
   - Repeatedly pop two people (A and B) from the stack.
   - Ask if A knows B:
     - If A knows B, A cannot be the celebrity (since the celebrity knows no one). Discard A.
     - If A doesn't know B, B cannot be the celebrity (since everyone knows the celebrity). Discard B.
   - Push the remaining person (either A or B) back onto the stack.

3. Final Check:
   - After the elimination process, only one person (potential celebrity) should be left on the stack.
   - Verify if this person is indeed the celebrity by checking if:
     - Everyone else knows this person.
     - This person knows no one else.

Time and Space Complexity:

- Time Complexity: O(N) - Each person is pushed and popped from the stack at most once.
- Space Complexity: O(N) - In the worst case, the stack can hold all N people.
*/

public class CelebrityProblem {
  // Adjacency matrix M represents relationships: M[i][j] = 1 if i knows j
  public int findCelebrity(int[][] M) {
      int n = M.length;
      Stack<Integer> stack = new Stack<>();

      // Push all people onto the stack
      for (int i = 0; i < n; i++) {
          stack.push(i);
      }

      // Eliminate potential celebrities
      while (stack.size() > 1) {
          int a = stack.pop();
          int b = stack.pop();
          if (knows(M, a, b)) {
              stack.push(b); // A knows B, discard A
          } else {
              stack.push(a); // A doesn't know B, discard B
          }
      }

      // Check if the remaining person is indeed the celebrity
      int potentialCelebrity = stack.pop();
      for (int i = 0; i < n; i++) {
          if (i != potentialCelebrity && 
              (knows(M, potentialCelebrity, i) || !knows(M, i, potentialCelebrity))) {
              return -1; // Not a celebrity
          }
      }
      return potentialCelebrity;
  }

  // Helper function to check if person 'a' knows person 'b' (based on the matrix M)
  private boolean knows(int[][] M, int a, int b) {
      return M[a][b] == 1;
  }
}
