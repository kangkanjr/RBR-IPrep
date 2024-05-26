/*
https://leetcode.com/problems/diameter-of-binary-tree/description/

https://www.youtube.com/watch?v=bkxqA8Rfv04&ab_channel=NeetCode

543. Diameter of Binary Tree - Finding the Longest Path

Problem Description:
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root. 

Note: The length of a path between two nodes is represented by the number of edges between them.

Algorithm Overview (Depth-First Search with Post-Order Traversal):

1. Helper Function `calculateDepth`:
   - Purpose: Calculates the maximum depth (height) of a subtree rooted at a given node.
   - Base Case: If the node is null, the depth is 0.
   - Recursive Case:
      - Recursively calculate the depth of the left subtree.
      - Recursively calculate the depth of the right subtree.
      - Return the maximum of the two depths, plus 1 (for the current level).

2. `diameterOfBinaryTree`:
   - Initialize `diameter` to 0 to track the maximum diameter found so far.
   - Call the helper function `calculateDepth(root)` to initiate the traversal.
     - Within `calculateDepth`:
        - Update `diameter` if the current path (left depth + right depth) is longer.
        - Return the maximum depth of the subtree for the parent node.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of nodes in the tree. We visit each node exactly once.
- Space Complexity: O(N) in the worst case (skewed tree), due to the recursion stack.

Key Insight:
- The diameter of a tree is the maximum of the following three values:
    - The diameter of the left subtree.
    - The diameter of the right subtree.
    - The longest path passing through the root (left subtree height + right subtree height + 1).
- We use post-order traversal (left, right, root) to ensure that the diameter is calculated after processing both subtrees.

 * Definition for a binary tree node.
 * public class TreeNode {
 *  int val;
 *  TreeNode left;
 *  TreeNode right;
 *  TreeNode() {}
 *  TreeNode(int val) { this.val = val; }
 *  TreeNode(int val, TreeNode left, TreeNode right) {
 *    this.val = val;
 *    this.left = left;
 *    this.right = right;
 *  }
 * }

*/

class Solution {
  int diameter = 0; // Class-level variable to track the maximum diameter

  public int diameterOfBinaryTree(TreeNode root) {
      calculateDepth(root);
      return diameter;
  }

  // Helper function to calculate the depth of a subtree and update the diameter
  private int calculateDepth(TreeNode node) {
      if (node == null) {
          return 0; // Base case: depth of an empty tree is 0
      }

      // Recursively calculate the depths of left and right subtrees
      int leftDepth = calculateDepth(node.left);
      int rightDepth = calculateDepth(node.right);

      // Update the diameter if the current path is longer
      diameter = Math.max(diameter, leftDepth + rightDepth);

      // Return the depth of this subtree (1 + max of left and right depths)
      return Math.max(leftDepth, rightDepth) + 1; 
  }
}
