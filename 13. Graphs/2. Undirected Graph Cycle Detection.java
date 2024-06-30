/*
https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

Undirected Graph Cycle Detection - DFS (Depth-First Search) Approach

Problem Description:
Given an undirected graph represented as an adjacency list `adj`, determine if the graph contains a cycle.

Algorithm Overview:

1. `isCycle(int V, ArrayList<ArrayList<Integer>> adj)`: Main Function
   - `V`: Number of vertices in the graph.
   - `adj`: Adjacency list representation of the graph.
   - Initializes a `visited` array to keep track of visited vertices.
   - Iterates through all vertices (0 to V-1):
     - If a vertex hasn't been visited, it starts a DFS traversal from that vertex using the `dfs` helper function.
     - If the `dfs` function finds a cycle during the traversal, the `isCycle` function returns `true`.
   - If no cycle is found after exploring all components of the graph, it returns `false`.

2. `dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited)`: Recursive DFS Helper Function
   - `start`: The current vertex being explored.
   - `adj`: The adjacency list of the graph.
   - `visited`: Array to track visited vertices.
   - `stack`: A stack to manage the DFS traversal (stores pairs of node and its parent).
   - Pushes the initial vertex (`start`) and its parent (set to -1, indicating no parent) onto the stack.
   - Marks the `start` vertex as visited.
   - While the stack is not empty:
     - Pops a pair from the stack (current node and its parent).
     - Iterates through the neighbors of the current node:
       - If the neighbor hasn't been visited:
         - Marks it as visited.
         - Pushes the neighbor and its parent (the current node) onto the stack.
       - If the neighbor has been visited and it's not the parent of the current node, it means we've found a back edge, indicating a cycle (return `true`).
   - If the DFS completes without finding a back edge, return `false` (no cycle found).

Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
Space Complexity: O(V) in the worst case, for the `visited` array and the recursion stack.

Key Insight:
- We use DFS to explore the graph and keep track of the parent of each node to avoid revisiting it.
- A cycle is detected if we encounter a visited node that is not the parent of the current node (a back edge).
*/
import java.util.*;

class Solution {
    // Inner class to store a node and its parent in the DFS traversal
    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    
    // Main function to check if a cycle exists in the undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];  // Array to track visited nodes

        // Iterate through all vertices in the graph
        for (int i = 0; i < V; i++) { 
            // If a vertex hasn't been visited, start DFS from it
            if (!visited[i]) { 
                if (dfs(i, adj, visited)) {
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found in any component
    }

    // Depth-first search function to detect cycles
    private boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(start, -1)); // Push the initial node and its parent (-1 indicates no parent)
        visited[start] = true;          // Mark the node as visited

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();  // Pop the top node and its parent
            int node = pair.node;
            int parent = pair.parent;
            
            // Explore all neighbors of the current node
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;   // Mark the neighbor as visited
                    stack.push(new Pair(neighbor, node)); // Push the neighbor and its parent
                } else if (neighbor != parent) {
                    return true; // Cycle detected (found a back edge)
                }
            }
        }
        return false; // No cycle found in this DFS traversal
    }
}

