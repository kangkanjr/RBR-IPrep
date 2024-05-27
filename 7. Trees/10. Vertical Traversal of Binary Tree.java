/*
https://www.geeksforgeeks.org/print-binary-tree-vertical-order/

Vertical Traversal of Binary Tree - GeeksforGeeks Approach

Problem Description:
Given a binary tree, print nodes in vertical order. Nodes in the same vertical line should be printed from top to bottom. Horizontal distances from the root are used to determine the vertical lines.

Algorithm Overview:

1. Find Horizontal Bounds:
   - Determine the minimum and maximum horizontal distances (HD) of nodes from the root using a recursive function `findMinMax`.
2. Vertical Iteration and Preorder Traversal:
   - Iterate through vertical lines (from minHD to maxHD).
   - For each line, perform a preorder traversal, collecting nodes with the current HD.
   - Use a TreeMap to store nodes by their HD, ensuring sorted output.

Time Complexity: O(NlogN), where N is the number of nodes (due to TreeMap insertion and sorting).
Space Complexity: O(N) for storing nodes in the TreeMap and recursion stack.
*/

import java.util.ArrayList;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    // Finds the minimum and maximum horizontal distances from the root
    private static void findMinMax(Node node, Values min, Values max, int hd) {
        if (node == null) return;
        if (hd < min.min) min.min = hd;
        if (hd > max.max) max.max = hd;
        findMinMax(node.left, min, max, hd - 1); // Left subtree, decrease HD
        findMinMax(node.right, min, max, hd + 1); // Right subtree, increase HD
    }

    // Function to get vertical order traversal of a binary tree
    public static ArrayList<Integer> verticalOrder(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;

        Values min = new Values(), max = new Values(); // Stores min and max HD
        findMinMax(node, min, max, 0);

        // Map to store nodes by their horizontal distance
        TreeMap<Integer, ArrayList<Node>> map = new TreeMap<>();

        for (int line_no = min.min; line_no <= max.max; line_no++) {
            ArrayList<Node> list = new ArrayList<>();
            preorder(node, line_no, 0, list); // Preorder traversal for the current line
            map.put(line_no, list);
        }

        // Collect the nodes from the map and store in result
        for (ArrayList<Node> list : map.values()) {
            for (Node n : list) {
                result.add(n.data);
            }
        }

        return result; // Return the vertically ordered node values
    }

    // Recursive preorder traversal to collect nodes on a specific vertical line
    private static void preorder(Node node, int line_no, int hd, ArrayList<Node> list) {
        if (node == null) return;
        if (hd == line_no) list.add(node);
        preorder(node.left, line_no, hd - 1, list);
        preorder(node.right, line_no, hd + 1, list);
    }

    // Helper class to store min and max horizontal distances
    static class Values {
        int min = 0, max = 0;
    }
}
