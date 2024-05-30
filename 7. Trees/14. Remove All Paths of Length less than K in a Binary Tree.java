/*
Remove All Paths of Length < K in a Binary Tree

Problem Description:
Given a binary tree and a positive integer 'k', the task is to remove all nodes from the tree that lie on a root-to-leaf path of length less than k.  This means we need to keep only the nodes that are part of paths with length k or greater.

Algorithm Overview (Post-Order Traversal with Node Removal):

1. Base Case:
   - If the node is null (empty subtree), return null (no nodes to remove).

2. Recursive Case:
   - Recursively call the `removeShortPaths` function on the left and right subtrees of the current node, decrementing the `level` (path length) by 1.
   - Update the node's left and right children with the results of the recursive calls.
   - If the node is a leaf node (both children are null) AND the level is less than k, it means this node is part of a short path. Remove it by returning null.
   - Otherwise, the node is either part of a longer path or has children that are, so return the node itself.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of nodes in the tree. We visit each node exactly once.
- Space Complexity: O(h), where h is the height of the tree. In the worst case (skewed tree), the recursion depth equals the height, using space on the call stack.
*/

class Node {
  int data;
  Node left, right;

  Node(int item) {
      data = item;
      left = right = null;
  }
}

class BinaryTree {

  // Function to remove nodes on paths shorter than 'k'
  public Node removeShortPaths(Node node, int level, int k) {
      // Base case: if node is null, return null (nothing to remove)
      if (node == null) { 
          return null;
      }

      // Recursively call for left and right subtrees, decrementing the level
      node.left = removeShortPaths(node.left, level + 1, k);
      node.right = removeShortPaths(node.right, level + 1, k);

      // If the node is a leaf and its level is less than k, remove it
      if (node.left == null && node.right == null && level < k) {
          return null; // Node removed
      }
      
      // Otherwise, return the node (either it's part of a valid path or has valid children)
      return node; 
  }

  // Driver Code (Example usage)
  public static void main(String args[]) {
      BinaryTree tree = new BinaryTree();
      tree.root = new Node(1);
      tree.root.left = new Node(2);
      tree.root.right = new Node(3);
      tree.root.left.left = new Node(4);
      tree.root.left.right = new Node(5);
      tree.root.left.left.left = new Node(7);
      tree.root.right.right = new Node(6);
      tree.root.right.right.left = new Node(8);
      int k = 4;

      System.out.println("The inorder traversal of original tree is : ");
      tree.inorder(tree.root);
      Node newRoot = tree.removeShortPaths(tree.root, 1, k);
      System.out.println("\nThe inorder traversal of modified tree is : ");
      tree.inorder(newRoot);
  }
  void inorder(Node node)
  {
      if (node == null)
          return;
      inorder(node.left);
      System.out.print(node.data + " ");
      inorder(node.right);
  }
}
