/*
https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

Bottom View of Binary Tree
O(n) approach also there

Problem Description:
Given a binary tree, find the bottom view of the tree. The bottom view consists of the bottommost nodes in each vertical line, 
as seen from the bottom of the tree.

Algorithm Overview (Level Order Traversal with Horizontal Distance):

1. Horizontal Distance (HD) Mapping:
   - Each node in the tree is associated with a horizontal distance (HD) from the root. The root has HD 0.
   - Nodes to the left of the root have negative HDs, and nodes to the right have positive HDs.
   - Use a map (`TreeMap`) to store the bottom-most node for each HD. The TreeMap ensures that keys (HDs) are sorted, 
      making it easy to retrieve nodes in the correct order for the bottom view.

2. Level Order Traversal:
   - Use a queue to perform a level order traversal of the tree.
   - For each node:
     - Calculate its HD based on its parent's HD (left child: HD - 1, right child: HD + 1).
     - Update the map with the current node for this HD. This overwrites any previous node at the same HD, ensuring we only keep the bottom-most node.

3. Collect Bottom View:
   - The map now contains the bottommost node for each HD, sorted by HD.
   - Iterate through the map's values (nodes) and add them to the result list.

Time Complexity: O(N log N)
   - O(N) for the level order traversal.
   - O(log N) per insertion into the TreeMap (due to its self-balancing nature).

Space Complexity: O(N)
   - The map can store up to N nodes in the worst case (a tree where all nodes are on different vertical lines).
   - The queue can also store up to O(N/2) nodes in the worst case (a perfect binary tree).
*/
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class Pair { // Helper class to store a node and its horizontal distance
    Node node;
    int hd; // horizontal distance

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Tree {
  public static ArrayList<Integer> bottomView(Node root) {
      ArrayList<Integer> res = new ArrayList<>();
      if (root == null) {
          return res; // Handle the case where the tree is empty
      }

      TreeMap<Integer, Integer> map = new TreeMap<>(); // Map to store (hd, node.data)

      // Queue to store nodes along with their horizontal distances
      Queue<Pair> q = new LinkedList<>(); 
      q.add(new Pair(root, 0)); // Start by adding the root node with HD 0

      while (!q.isEmpty()) { // Iterate through the tree level by level
          Pair curr = q.poll(); // Dequeue a node and its HD from the queue
          Node node = curr.node;
          int hd = curr.hd;

          // Since we are doing level order traversal, the last node processed for a particular 
          // horizontal distance will be the bottommost node. So, we always update the map.
          map.put(hd, node.data); 

          // Add the left child to the queue with its HD (hd - 1)
          if (node.left != null) {
              q.add(new Pair(node.left, hd - 1)); 
          }

          // Add the right child to the queue with its HD (hd + 1)
          if (node.right != null) {
              q.add(new Pair(node.right, hd + 1)); 
          }
      }

      // Iterate over the sorted map (by HD) and collect the values (node data)
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
          res.add(entry.getValue());
      }

      return res; // Return the list of nodes in the bottom view order
  }
}