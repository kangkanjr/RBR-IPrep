/**
 * https://www.geeksforgeeks.org/problems/majority-element-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
 * 
 * Finds the majority element in an array (an element that appears more than n/2 times).
 *
 * This solution utilizes the Boyer-Moore Voting Algorithm. It efficiently identifies a majority
 * element by maintaining a candidate element and a counter.
 *
 * Algorithm:
 * 1. Candidate Selection and Voting:
 *    - Iterate through the array, maintaining a `candidate` element and a `count`.
 *    - If `count` is 0, set the current element as the new `candidate`.
 *    - If the current element matches the `candidate`, increment `count`.
 *    - If the current element doesn't match, decrement `count`.
 *    - After this phase, `candidate` potentially holds the majority element.
 *
 * 2. Candidate Verification:
 *    - Iterate through the array again, counting the occurrences of `candidate`.
 *    - If the count exceeds half the array size (n/2), `candidate` is confirmed as the majority element.
 *    - Otherwise, there's no majority element, return -1.
 *
 * Time Complexity: O(n) - Two linear passes over the array.
 * Space Complexity: O(1) - Constant extra space used.
 *
 * @param a     the array of integers
 * @param size  the size of the array (not used in this implementation)
 * @return the majority element if it exists, otherwise -1
 */
static int majorityElement(int a[], int size) {
  int candidate = 0;  // Potential majority element
  int count = 0;      // Vote counter for the candidate

  // Boyer-Moore Voting Algorithm - First Pass
  for (int i = 0; i < a.length; i++) { 
      int num = a[i];

      if (count == 0) {
          candidate = num;  // Set new candidate when votes are tied
      }

      if (num == candidate) {
          count++;         // Increment vote for matching candidate
      } else {
          count--;         // Decrement vote for different element
      }
  }

  // Second Pass - Verify if the candidate is indeed the majority
  count = 0;
  for (int num : a) {
      if (num == candidate) {
          count++;
      }
  }

  return (count > a.length / 2) ? candidate : -1; // Check if count > n/2
}
