/*
https://leetcode.com/problems/find-if-path-exists-in-graph/description/

https://www.youtube.com/watch?v=PApEamXn94I&ab_channel=CodingSimplified

1971. Find if Path Exists in Graph - DFS Solution

Problem Description:
Given a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive) and an array of edges, 
determine if there is a valid path from vertex source to vertex destination.

Algorithm Overview (Depth-First Search):

1. Build Adjacency List:
   - Create an adjacency list representation of the graph, where each vertex stores a list of its neighboring vertices.
   - Iterate through the edges array and add each edge to the adjacency list of both its vertices.

2. Initialize DFS:
   - Create a stack to manage the DFS traversal.
   - Create a visited array to track which vertices have been visited.
   - Push the starting vertex (source) onto the stack and mark it as visited.

3. Depth-First Search:
   - While the stack is not empty:
     - Pop a vertex from the top of the stack.
     - If the popped vertex is the destination, a path exists (return true).
     - Iterate through the neighbors of the popped vertex:
       - If a neighbor hasn't been visited, push it onto the stack and mark it as visited.

4. No Path Found:
   - If the stack is empty (all paths explored) and the destination vertex hasn't been reached, return false.

Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges. 
In the worst case, we might visit all vertices and edges.
Space Complexity: O(V), in the worst case, the visited array and the recursion stack can store up to V elements.
*/
import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        // 1. Build Adjacency List
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>()); // Initialize an empty list for each vertex
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]); // Add edge (u, v)
            graph.get(edge[1]).add(edge[0]); // Add reverse edge (v, u) since it's undirected
        }

        // 2. Initialize DFS
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        stack.push(start); // Push the starting vertex onto the stack
        visited[start] = true; // Mark the start vertex as visited

        // 3. Depth-First Search
        while (!stack.isEmpty()) {
            int node = stack.pop();  // Get the next vertex to explore
            if (node == end) {     // If we've reached the end, a path exists
                return true; 
            }

            // Explore all unvisited neighbors of the current node
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor); // Push the neighbor onto the stack
                    visited[neighbor] = true; // Mark the neighbor as visited to avoid cycles
                }
            }
        }

        // 4. If we reach here, no path exists
        return false; 
    }
}
