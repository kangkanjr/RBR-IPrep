/*
https://leetcode.com/problems/invert-binary-tree/description/

226. Invert Binary Tree - Flipping the Tree's Structure

Problem Description:
Given the root of a binary tree, invert the tree, and return its root.

Inverting a binary tree means swapping the left and right children of each node recursively.

Algorithm Overview (Recursive):

1. Base Case:
   - If the current node is null (empty tree or we've reached the end of a branch), return null.

2. Recursive Case:
   - Recursively invert the left subtree.
   - Recursively invert the right subtree.
   - Swap the left and right children of the current node.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of nodes in the tree. We visit each node exactly once.
- Space Complexity: O(H), where H is the height of the tree. In the worst case (skewed tree), the recursion depth equals the height, using space on the call stack.
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
  public TreeNode invertTree(TreeNode root) {
      // Base case: empty tree or null node
      if (root == null) {
          return null;
      }

      // Recursively invert the left subtree
      TreeNode left = invertTree(root.left);
      
      // Recursively invert the right subtree
      TreeNode right = invertTree(root.right);

      // Swap the left and right children of the current node
      root.left = right; 
      root.right = left;

      return root; // Return the modified root after inversion
  }
}
