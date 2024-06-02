/*
https://leetcode.com/problems/binary-tree-level-order-traversal/description/

Binary Tree Level Order Traversal - Iterative Queue-Based Solution

Problem Description:
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Algorithm Overview (Breadth-First Search):

1. Initialization:
   - Create a `result` list to store the level order traversal result.
   - Create a queue `queue` to hold nodes for breadth-first traversal.

2. Handling Empty Tree:
   - If the root is null (empty tree), return the empty `result` list.

3. Level-Wise Traversal:
   - Enqueue the root node into the `queue`.
   - While the queue is not empty:
     - Initialize a `levelList` to store nodes at the current level.
     - Get the number of nodes in the current level (`levelSize`).
     - Process each node in the current level:
       - Dequeue a node from the `queue`.
       - Add its value to the `levelList`.
       - If the node has a left child, enqueue it.
       - If the node has a right child, enqueue it.
     - Add the `levelList` to the `result` list.

4. Return Result:
   - Return the `result` list containing the level order traversal.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of nodes in the tree. We visit each node exactly once.
- Space Complexity: O(N) in the worst case, when the tree is a perfect binary tree (all levels are completely filled).  The queue can hold up to N/2 nodes at any given time.

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list to store values at each level
        if (root == null) {
            return result; // If the tree is empty, return the empty list
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Queue to store nodes for level-order traversal
        queue.offer(root); // Add the root node to the queue to start the traversal

        while (!queue.isEmpty()) {  // Continue until all levels are processed
            int levelSize = queue.size();  // Number of nodes at the current level
            List<Integer> levelList = new ArrayList<>();  // List to store node values for the current level

            // Process all nodes in the current level
            for (int i = 0; i < levelSize; i++) { 
                TreeNode currentNode = queue.poll(); // Dequeue the node from the front of the queue

                // Store the node's value in the list for the current level
                levelList.add(currentNode.val); 

                // If the node has a left child, enqueue it for processing in the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // If the node has a right child, enqueue it for processing in the next level
                if (currentNode.right != null) { 
                    queue.offer(currentNode.right); 
                }
            }

            // Add the completed list for the current level to the result list
            result.add(levelList); 
        }

        return result; // Return the nested list containing node values at each level
    }
}
