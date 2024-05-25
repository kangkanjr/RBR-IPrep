/*
https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1

Binary Tree to DLL - In-Place Conversion

Problem Description:
Given a binary tree, convert it to a doubly linked list (DLL) in-place. The left and right pointers in the nodes should be used as previous and next pointers, respectively, in the converted DLL. The order of nodes in the DLL must be the same as the inorder traversal of the binary tree.

Algorithm Overview (Recursive Inorder Traversal):

1. Initialization:
   - `prev`: A reference to the previously processed node (initially null).
   - `head`: A reference to the head of the resulting DLL (initially null).

2. Recursive Conversion:
   - `bToDLL(Node node)`:
      - Base Case: If `node` is null, return (nothing to convert).
      - Recursive Case:
        - Traverse the left subtree recursively: `bToDLL(node.left)`.
        - Process the current node:
           - If `prev` is null, it means this is the first node (head of the DLL), so set `head = node`.
           - Otherwise, connect the previous node to the current node: 
             - `prev.right = node` (set the previous node's next to the current node)
             - `node.left = prev` (set the current node's previous to the previous node)
        - Update `prev` to the current node.
        - Traverse the right subtree recursively: `bToDLL(node.right)`.

3. Return Head:
   - After the entire tree is processed, return the `head` of the DLL.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of nodes in the tree. We visit each node exactly once.
- Space Complexity: O(H), where H is the height of the tree. In the worst case (skewed tree), the recursion depth equals the height.
*/

class Node {
  int data;
  Node left, right;

  Node(int data) {
      this.data = data;
  }
}

class BinaryTree {
  Node head; // Head of the DLL
  Node prev = null; // Pointer to the previously processed node

  // Function to convert binary tree to DLL in-place
  Node bToDLL(Node node) {
      if (node == null) {
          return null; // Base case: nothing to convert
      }

      // Recursively convert the left subtree
      bToDLL(node.left);

      // Process the current node
      if (prev == null) {
          head = node; // First node becomes the head of the DLL
      } else {
          prev.right = node; 
          node.left = prev; 
      }
      prev = node; // Update prev for the next node

      // Recursively convert the right subtree
      bToDLL(node.right);

      return head; // Return the head of the DLL
  }
}
