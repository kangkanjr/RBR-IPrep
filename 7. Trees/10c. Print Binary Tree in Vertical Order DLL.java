/*
Print Binary Tree in Vertical Order - Doubly Linked List Approach

Problem Description:
Given a binary tree, print its nodes in vertical order. Nodes in the same vertical line should be printed from top to bottom. Horizontal distances from the root are used to determine the vertical lines.

Algorithm Overview:

1. Find Horizontal Bounds:
    - Determine the minimum and maximum horizontal distances (HD) of nodes from the root.
2. Create Doubly Linked List of Vertical Lines:
    - Initialize a doubly linked list (`head` and `tail`) to represent vertical lines.
    - Each node in the list stores an HD value and a list of tree nodes at that HD.
3. Level Order Traversal with DLL Insertion:
    - Perform a level order traversal using a queue.
    - For each node, calculate its HD based on its parent's HD.
    - Insert the node into the DLL at the appropriate position based on its HD.
        - If a vertical line (DLL node) with the HD already exists, add the node to the end of its list.
        - Otherwise, create a new DLL node for the HD and insert it in the correct order.
4. Print Vertically Ordered Nodes:
    - Traverse the DLL and print the nodes in each vertical line from top to bottom.

Time Complexity: O(N), where N is the number of nodes in the tree.
Space Complexity: O(N), for storing nodes in the queue and doubly linked list.
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

class VerticalLineNode {
    int hd;
    List<Node> nodes = new ArrayList<>();
    VerticalLineNode prev, next;

    VerticalLineNode(int hd, Node node) {
        this.hd = hd;
        this.nodes.add(node);
    }
}

class BinaryTree {
    // Function to find min and max horizontal distances from the root
    private static void findMinMax(Node node, Values min, Values max, int hd) {
        if (node == null) return;
        if (hd < min.min) min.min = hd;
        if (hd > max.max) max.max = hd;
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }

   // Function to print binary tree in vertical order using a doubly linked list
   public static void verticalOrder(Node root) {
    if (root == null) return; // Handle empty tree

    // Find the minimum and maximum horizontal distances in the tree
    Values min = new Values(); 
    Values max = new Values();
    findMinMax(root, min, max, 0);

    // Initialize the doubly linked list to store vertical lines
    VerticalLineNode head = null, tail = null; 

    // Queue to store nodes along with their horizontal distances
    Queue<MyPair> queue = new LinkedList<>();

    // Enqueue the root node with horizontal distance 0
    queue.offer(new MyPair(root, 0));  

    // Process nodes level by level
    while (!queue.isEmpty()) {
        // Dequeue a node and its horizontal distance
        MyPair current = queue.poll();
        Node node = current.node;
        int hd = current.hd;

        // Create a new VerticalLineNode to store the current node
        VerticalLineNode newNode = new VerticalLineNode(hd, node);

        // Insert the new VerticalLineNode in the correct position in the doubly linked list
        if (head == null) {
            head = tail = newNode; // If the list is empty, set head and tail
        } else {
            if (hd < head.hd) {   // Insert at the beginning
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (hd > tail.hd) { // Insert at the end
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            } else {               // Insert in the middle
                VerticalLineNode temp = head;
                while (temp.hd < hd) {
                    temp = temp.next;
                }
                newNode.next = temp;
                newNode.prev = temp.prev;
                temp.prev.next = newNode;
                temp.prev = newNode;
            }
        }

        // Add the children of the current node to the queue with their horizontal distances
        if (node.left != null) {
            queue.offer(new Pair(node.left, hd - 1));
        }
        if (node.right != null) {
            queue.offer(new Pair(node.right, hd + 1));
        }
    }

    // Iterate over the doubly linked list and print nodes for each vertical line
    VerticalLineNode currentLine = head;
    while (currentLine != null) {
        for (Node node : currentLine.nodes) {
            System.out.print(node.data + " "); // Print nodes in the current vertical line
        }
        System.out.println(); // Move to the next line for the next vertical line
        currentLine = currentLine.next;
    }
}
}
