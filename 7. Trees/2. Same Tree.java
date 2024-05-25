/*
https://leetcode.com/problems/same-tree/description/

100. Same Tree - Determining Structural and Value Equality of Binary Trees

Problem Description:
Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Algorithm Overview (Recursive):

1. Base Cases:
   - If both `p` and `q` are null, the trees are identical (return true).
   - If either `p` or `q` is null (but not both), the trees are different (return false).
   - If the values of `p` and `q` are different, the trees are different (return false).

2. Recursive Case:
   - Check if the left subtrees of `p` and `q` are the same by recursively calling `isSameTree(p.left, q.left)`.
   - Check if the right subtrees of `p` and `q` are the same by recursively calling `isSameTree(p.right, q.right)`.
   - If both the left and right subtrees are the same, return true. Otherwise, return false.

Time and Space Complexity:

- Time Complexity: O(N), where N is the minimum number of nodes in either tree. We potentially visit every node once.
- Space Complexity: O(H), where H is the height of the taller tree. In the worst case (skewed tree), the recursion stack takes up space proportional to the height.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
      // Base case: both trees are null
      if (p == null && q == null) {
          return true; 
      }
      
      // Base case: one tree is null, the other is not
      if (p == null || q == null) {
          return false;
      }
      
      // Base case: node values are different
      if (p.val != q.val) {
          return false;
      }

      // Recursive case: check left and right subtrees
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
