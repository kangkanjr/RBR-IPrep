/*
https://geeksforgeeks.org/problems/rat-in-a-maze-problem/1

Rat in a Maze Problem - I (Recursive Backtracking)

Problem Description:
A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., 
maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. 
A rat starts from source and has to reach the destination. The rat can moveonly in two directions: forward and down. 
Find all possible paths that the rat can take to reach from source to destination.

Algorithm Overview:

1. `findPath(int[][] m, int n)`:
    - Initializes an empty `ArrayList` to store the valid paths.
    - Creates a `visited` 2D boolean array to keep track of visited cells.
    - Starts the recursive `solveMaze` function from the starting position (0, 0).
    - Returns the list of valid paths.

2. `solveMaze(maze, n, x, y, path, result, visited)`: Recursive backtracking function.
    - Base Cases:
        - If the current position (`x`, `y`) is out of bounds or a wall (0), return.
        - If the destination (`x == n-1` and `y == n-1`) is reached, add the `path` to the `result` list and return.
    - Recursive Steps:
        - Mark the current cell as visited (`visited[x][y] = true`).
        - Explore all possible moves (Down, Left, Right, Up) by calling `solveMaze` recursively for each direction and 
          appending the direction character ('D', 'L', 'R', 'U') to the `path`.
        - Unmark the current cell after exploring (backtracking, `visited[x][y] = false`). This allows us to reuse this cell in other potential paths.
*/
import java.util.ArrayList;

class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> result = new ArrayList<>();    // List to store valid paths
        boolean[][] visited = new boolean[n][n];          // 2D array to track visited cells

        // Start the recursive search from the top-left corner (0, 0)
        solveMaze(m, n, 0, 0, "", result, visited);  
        return result;
    }

    // Recursive function to explore paths in the maze
    private static void solveMaze(int[][] maze, int n, int x, int y, String path, 
                                    ArrayList<String> result, boolean[][] visited) {
        // Check if the current position is valid
        if (x < 0 || x >= n || y < 0 || y >= n || maze[x][y] == 0 || visited[x][y]) { 
            return; // Out of bounds, wall, or already visited
        }

        // Check if we have reached the destination (bottom-right corner)
        if (x == n - 1 && y == n - 1) {
            result.add(path); // Found a valid path, add to the result list
            return;
        }

        // Mark the current cell as visited
        visited[x][y] = true;

        // Explore all possible moves (D, L, R, U)
        solveMaze(maze, n, x + 1, y, path + 'D', result, visited); // Down
        solveMaze(maze, n, x, y - 1, path + 'L', result, visited); // Left
        solveMaze(maze, n, x, y + 1, path + 'R', result, visited); // Right
        solveMaze(maze, n, x - 1, y, path + 'U', result, visited); // Up

        // Unmark the current cell (backtrack) for exploring other paths
        visited[x][y] = false; 
    }
}
