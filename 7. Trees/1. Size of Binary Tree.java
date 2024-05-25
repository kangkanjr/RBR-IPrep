/*
https://www.geeksforgeeks.org/problems/size-of-binary-tree/1

Size of Binary Tree - Calculating Node Count

Problem Description:
Given a binary tree, find the total number of nodes in it. The size of a tree is defined as the number of nodes present in the tree.

Algorithm Overview (Recursive):

1. Base Case:
   - If the node is null (empty tree or reached a leaf node's child), return 0 (no nodes).

2. Recursive Case:
   - Recursively calculate the size of the left subtree.
   - Recursively calculate the size of the right subtree.
   - Add the sizes of both subtrees and 1 (for the current node itself) to get the total size.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of nodes in the tree. We visit each node exactly once.
- Space Complexity: O(h), where h is the height of the tree. In the worst case (skewed tree), the recursion depth equals the height.

Key Idea:
- The recursive approach breaks down the problem into smaller subproblems (the size of left and right subtrees), making it easy to solve and understand.
*/

class Node {
  int data;
  Node left, right;

  public Node(int item) {
      data = item;
      left = right = null;
  }
}

class BinaryTree {
  // Function to find the size of the binary tree
  static int size(Node node) {
      if (node == null) {
          return 0; // Base case: empty tree or null node
      }

      // Recursive case: calculate size of left and right subtrees
      int leftSize = size(node.left);    
      int rightSize = size(node.right);

      // Return total size (left size + right size + 1 for current node)
      return leftSize + rightSize + 1;
  }

  // Driver Code (Example usage)
  public static void main(String[] args) {
      /*create a tree*/
      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.left.right = new Node(5);

      System.out.println("The size of binary tree is : " + size(root));
  }
}
