/*
572. Subtree of Another Tree - Recursive Solution

Problem Description:
Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure 
and node values of `subRoot`, and `false` otherwise.

A subtree of a binary tree `tree` is a tree that consists of a node in `tree` and all of this node's descendants. 
The tree `tree` could also be considered as a subtree of itself.

Algorithm Overview:

1. Check for Null Cases:
   - If either `root` or `subRoot` is null, handle the following cases:
     - If both are null, they are trivially considered the same subtree (return `true`).
     - If only one is null, they cannot be subtrees of each other (return `false`).

2. Check for Subtree Match:
   - If the root values match (`root.val == subRoot.val`), call a helper function (`isIdentical`) to check if 
    the entire subtree rooted at `root` is identical to the subtree rooted at `subRoot`.

3. Recursive Subtree Search:
   - If the subtree match fails, recursively check if `subRoot` is a subtree of the left child of `root` (`isSubtree(root.left, subRoot)`).
   - If that fails, recursively check if `subRoot` is a subtree of the right child of `root` (`isSubtree(root.right, subRoot)`).
   - Return `true` if either of the recursive calls finds a match, otherwise return `false`.

4. Helper Function `isIdentical`:
   - Base Case: If both nodes are null, they are identical (return `true`).
   - If only one node is null, they are not identical (return `false`).
   - If the node values are different, they are not identical (return `false`).
   - Recursive Case: Return `true` only if the left and right subtrees of both nodes are identical.

Time and Space Complexity:

- Time Complexity: O(N*M) in the worst case, where N is the number of nodes in `root` and M is the number of nodes in `subRoot`. 
  In each node of the `root` tree, we might potentially compare the entire `subRoot` tree.
- Space Complexity: O(N) in the worst case, due to the recursion stack (for a skewed tree).

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
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      // Base cases: handle null values
      if (subRoot == null) return true; // Empty subtree is always a subtree
      if (root == null) return false;   // Cannot find subtree in an empty tree

      // Check if the subtree rooted at the current node matches subRoot
      if (isIdentical(root, subRoot)) return true;

      // If the current node doesn't match, check the left and right subtrees recursively
      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); 
  }

  // Helper function to check if two trees are identical
  private boolean isIdentical(TreeNode node1, TreeNode node2) {
      // Base case: both nodes are null (identical subtrees)
      if (node1 == null && node2 == null) return true;

      // Base case: one node is null, the other isn't (not identical)
      if (node1 == null || node2 == null) return false;

      // If node values match, recursively check their left and right children
      return node1.val == node2.val 
          && isIdentical(node1.left, node2.left) 
          && isIdentical(node1.right, node2.right);
  }
}
