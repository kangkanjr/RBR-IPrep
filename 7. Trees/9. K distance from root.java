/*

https://www.geeksforgeeks.org/problems/k-distance-from-root/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

K distance from root - Finding Nodes at a Specific Level

Problem Description:
Given the root of a binary tree and a positive integer 'k', return an ArrayList containing all nodes that are distance 'k' away from the root node. The root node is considered to be at distance 0 from itself.

Algorithm Overview (Recursive Depth-First Search):

1. Base Case:
   - If the current node is null or if 'k' becomes negative, return an empty ArrayList (no nodes found at the given distance).

2. Recursive Case:
   - If 'k' is 0, it means we've reached the desired distance from the root. Add the current node's data to the result ArrayList.
   - Otherwise, recursively traverse the left and right subtrees, decreasing 'k' by 1 with each level of recursion.
   - Combine the results from the left and right subtrees.

Time and Space Complexity:

- Time Complexity: O(N), where N is the number of nodes in the tree. We visit each node at most once.
- Space Complexity: O(N) in the worst case, due to the recursion stack (for a skewed tree).

Key Idea:
- We use depth-first search to explore the tree, decrementing 'k' at each level to keep track of the distance from the root.
- When 'k' becomes 0, we've found nodes at the desired distance.
*/
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Tree {
    // Function to find nodes at distance k from the root
    public static ArrayList<Integer> Kdistance(Node root, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null || k < 0) {
            return result; // Base case: no nodes found at the given distance
        }

        if (k == 0) {
            result.add(root.data);
            return result;
        }

        // Recursively search in the left and right subtrees, decrementing k
        result.addAll(Kdistance(root.left, k - 1)); 
        result.addAll(Kdistance(root.right, k - 1));

        return result; // Return the combined list of nodes at distance k
    }
}
