/*
https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

Vertical Order Traversal of Binary Tree - HashMap Approach

Problem Description:
Given a binary tree, return a list of its nodes in vertical order. Nodes within the same vertical line should be ordered from top to bottom. 
Vertical order is determined by the horizontal distance of each node from the root. 
The root has a horizontal distance of 0, nodes to the left have negative distances, 
and nodes to the right have positive distances.

Algorithm Overview:

1. Level Order Traversal with Horizontal Distance (HD) Tracking:
    - Use a queue to perform a level order traversal of the tree.
    - For each node, store it in a HashMap along with its horizontal distance (`hd`). 
    - The HashMap stores the nodes in order of their encounter during traversal.

2. Sorting and Output:
    - Extract the keys (HDs) from the HashMap and sort them.
    - Iterate through the sorted HDs:
        - Retrieve the list of nodes at each HD.
        - For each node in the list, add its data to the result list.

Time Complexity: O(N log N) due to the use of HashMap for sorting nodes based on HD.
Space Complexity: O(N) in the worst case, for storing nodes in the queue and map.
*/
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

// Helper class to store node and its horizontal distance
class MyPair {
    Node node;
    int hd;

    public MyPair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class BinaryTree {
    // Function to find the vertical order traversal of the Binary Tree
    static ArrayList<Integer> verticalOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res; // Base case: If the tree is empty, return an empty list

        // Queue for Level Order Traversal: Stores nodes and their HDs
        Queue<MyPair> queue = new LinkedList<>();

        // TreeMap to Store Nodes by Horizontal Distance: Keys are HDs, values are lists of nodes at that HD
        // TreeMap automatically sorts by keys, ensuring vertical order
        Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();

        queue.offer(new MyPair(root, 0)); // Enqueue the root with HD 0
        while (!queue.isEmpty()) {
            MyPair curr = queue.poll(); // Dequeue the next node and its HD
            Node tempNode = curr.node;
            int hd = curr.hd;

            // Add the node's data to the list for its horizontal distance
            // If the list doesn't exist, create a new one
            mp.putIfAbsent(hd, new ArrayList<>()); 
            mp.get(hd).add(tempNode.data); // Add the node's value to the list

            // Enqueue the left child (if it exists) with its HD (hd - 1)
            if (tempNode.left != null) { 
                queue.offer(new MyPair(tempNode.left, hd - 1));
            }

            // Enqueue the right child (if it exists) with its HD (hd + 1)
            if (tempNode.right != null) {
                queue.offer(new MyPair(tempNode.right, hd + 1));
            }
        }

        // Iterate over the sorted map (by HD) to collect nodes in vertical order
        for (Map.Entry<Integer, ArrayList<Integer>> entry : mp.entrySet()) {
            res.addAll(entry.getValue()); // Add all nodes at the current HD to the result
        }

        return res; // Return the vertically ordered nodes as a list
    }
}