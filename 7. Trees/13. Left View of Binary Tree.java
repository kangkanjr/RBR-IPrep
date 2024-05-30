/*
https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1

Left View of Binary Tree

Problem Description:
Given a binary tree, return an ArrayList containing the values of the nodes that are visible when the tree is viewed from the left side.

Algorithm Overview (Level Order Traversal):

1. Queue Initialization:
   - Create a queue `queue` to hold nodes for level order traversal.
   - Enqueue the root node of the tree.

2. Level Order Traversal:
   - While the queue is not empty:
     - Get the number of nodes in the current level (`levelSize`).
     - Process each node in the current level:
       - Dequeue the first node from the queue.
       - If it's the first node of the current level, add its value to the `result` list (this is the leftmost node).
       - Enqueue the left and right children of the node (if they exist) for processing in the next level.

3. Return Result:
   - After processing all levels, return the `result` list containing the left view nodes.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of nodes in the tree. We visit each node exactly once.
- Space Complexity: O(W), where W is the maximum width of the tree. In the worst case (a perfect binary tree), the queue can hold up to N/2 nodes at any given time.
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Tree {
    // Function to return the left view of the binary tree
    public static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // Handle the case where the tree is empty
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // Add the root node to the queue

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll(); // Dequeue the next node from the queue

                // If it's the first node of the current level, it's part of the left view
                if (i == 0) {
                    result.add(current.data);
                }

                // Enqueue the left and right children for processing in the next level
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return result; // Return the ArrayList containing the left view nodes
    }
}
