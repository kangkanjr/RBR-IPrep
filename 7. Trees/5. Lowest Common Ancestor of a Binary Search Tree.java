/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

235. Lowest Common Ancestor of a Binary Search Tree - Iterative Solution

Problem Description:
Given a binary search tree (BST) and two nodes `p` and `q`, find the lowest common ancestor (LCA) node of both `p` and `q` in the BST.

The LCA of two nodes in a BST is the lowest (deepest) node that has both nodes as descendants (where we allow a node to be a descendant of itself).

Algorithm Overview (Iterative):

1. Start at the Root:
   - Initialize a `node` variable to the root of the BST.

2. Iterate While a Valid Ancestor is Not Found:
   - While the current `node` is not null:
     - If both `p.val` and `q.val` are less than `node.val`: 
        - Move to the left child (`node = node.left`).
     - If both `p.val` and `q.val` are greater than `node.val`:
        - Move to the right child (`node = node.right`).
     - Otherwise (either `p` or `q` is equal to `node`, or `p` and `q` lie on different sides of `node`):
        - The current `node` is the LCA, return `node`.

Time and Space Complexity:

- Time Complexity: O(H), where H is the height of the BST. In the worst case (skewed tree), we traverse a path from the root to a leaf.
- Space Complexity: O(1) - We use only constant extra space.

* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      TreeNode node = root; // Start at the root of the tree

      while (node != null) {
          // If both p and q are smaller than the current node, LCA is in the left subtree
          if (p.val < node.val && q.val < node.val) {
              node = node.left;
          } 
          // If both p and q are larger than the current node, LCA is in the right subtree
          else if (p.val > node.val && q.val > node.val) {
              node = node.right;
          } 
          // If one node is smaller and the other is larger, or if either is equal to the current node,
          // then the current node is the LCA
          else {
              return node;
          }
      }
      
      // This should never happen in a valid BST with p and q present
      return null; 
  }
}
