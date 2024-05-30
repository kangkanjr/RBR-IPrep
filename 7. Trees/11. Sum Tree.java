/*
https://www.geeksforgeeks.org/problems/sum-tree/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

Sum Tree Verification - Recursive Approach with Leaf Node Optimization

Problem Description:
A SumTree is a Binary Tree where the value of every node (except leaf nodes) is equal to the sum of its left and right child nodes. This code determines if a given binary tree is a SumTree.

Algorithm Overview:

1. Base Cases:
   - Null Node: If the node is null, it is considered a valid SumTree (return true).
   - Leaf Node: If the node is a leaf node (has no children), it is also a valid SumTree (return true).

2. Recursive Case (Non-Leaf Node):
   - Recursively check if the left and right subtrees are SumTrees.
   - Error Handling:
     - If either subtree is not a SumTree, return false immediately (the entire tree is invalid).
   - Sum Calculation:
     - Calculate the sum of the left subtree. If the left child is a leaf, use its data directly; otherwise, double its data (since it's a valid SumTree).
     - Calculate the sum of the right subtree similarly.
   - SumTree Check:
     - If the current node's data equals the sum of the left and right subtrees, return true.
     - Otherwise, return false.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of nodes in the tree. We visit each node exactly once.
- Space Complexity: O(h), where h is the height of the tree. In the worst case (skewed tree), the recursion depth equals the height, using space on the call stack.
*/

class Node {
  int data;
  Node left, right;

  Node(int data) {
      this.data = data;
      left = right = null;
  }
}

class Solution {

  // Helper function to check if a node is a leaf (has no children)
  boolean isLeaf(Node node) {
      if (node == null)
          return false; // Null node is not a leaf
      if (node.left == null && node.right == null)
          return true;
      return false;
  }

  // Function to check if a tree rooted at 'node' is a SumTree
  boolean isSumTree(Node node) {
      // Base case: null node or leaf node are considered valid SumTrees
      if (node == null || isLeaf(node)) {
          return true; 
      }

      // Recursively check if left and right subtrees are SumTrees
      if (isSumTree(node.left) && isSumTree(node.right)) {
          // Calculate the sum of the left subtree
          int ls = (node.left == null) ? 0 : (isLeaf(node.left) ? node.left.data : 2 * node.left.data);

          // Calculate the sum of the right subtree
          int rs = (node.right == null) ? 0 : (isLeaf(node.right) ? node.right.data : 2 * node.right.data);

          // If the node's value equals the sum of its children, it's a SumTree node
          return (node.data == ls + rs); 
      }

      return false; // Either a subtree is not a SumTree or the node's value doesn't match the sum
  }
}
