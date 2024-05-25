/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

236. Lowest Common Ancestor of a Binary Tree - Recursive Solution

Problem Description:

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

The LCA of two nodes p and q in a binary tree T is the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).

Algorithm Overview (Recursive):

1. Base Cases:
   - If the current node (`root`) is null or equals `p` or `q`, return `root`. This is because the current node itself could be the LCA.

2. Recursive Calls:
   - Recursively find the LCA in the left subtree (`left`).
   - Recursively find the LCA in the right subtree (`right`).

3. Analyze Results:
   - If both `left` and `right` are not null, it means that `p` and `q` exist in different subtrees, making the current node the LCA. Return `root`.
   - If only `left` is not null, it means that both `p` and `q` exist in the left subtree. Return `left`.
   - If only `right` is not null, it means that both `p` and `q` exist in the right subtree. Return `right`.
   - If both `left` and `right` are null, it means that neither `p` nor `q` exist in the subtree rooted at the current node. Return `null`.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of nodes in the tree. In the worst case, we might visit all nodes.
- Space Complexity: O(N) in the worst case, due to the recursion stack (for a skewed tree).

Key Idea:

The algorithm recursively traverses the tree, checking if each node is a common ancestor of both `p` and `q`. If a node has `p` in its left subtree and `q` in its right subtree (or vice versa), that node is the LCA.

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
      // Base case: if root is null or either p or q is found, return root
      if (root == null || root == p || root == q) { 
          return root;
      }

      // Recursively find LCA in the left and right subtrees
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      // If both left and right are not null, the current node is the LCA
      if (left != null && right != null) {
          return root;
      }
      
      // If only left is not null, LCA is in the left subtree
      if (left != null) { 
          return left; 
      }
      
      // If only right is not null, LCA is in the right subtree
      // If both are null, it means neither p nor q are in this subtree
      return right; 
  }
}
