/*
https://leetcode.com/problems/n-queens/description/

https://www.youtube.com/watch?v=MHXR4PCY8c0&ab_channel=AnujBhaiya

51. N-Queens - Finding Valid Queen Placements on a Chessboard

Problem Description:
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens threaten each other. 
Given an integer n, return all distinct solutions to the n-queens puzzle.

Algorithm Overview (Backtracking):

1. `solveNQueens(int n)`: Main Function
   - Initializes `solutions` to store the valid configurations (lists of strings representing the chessboard).
   - Initializes `queens` to track column positions of queens in each row.
   - Calls `solve` to start the recursive backtracking process.

2. `solve(solutions, queens, row, n)`: Recursive Backtracking
   - Base Case: If `row == n`, all queens have been placed successfully. Construct the chessboard representation and add it to `solutions`.
   - Recursive Case:
      - Iterate over each column (`col`) in the current row (`row`).
      - Check if placing a queen at (`row`, `col`) is valid using `isValid`.
      - If valid, place the queen (`queens[row] = col`) and recursively solve for the next row.
      - Implicitly backtrack: Since we overwrite `queens[row]` in the next iteration, the queen is effectively "unplaced."

3. `isValid(queens, row, col)`: Validity Check
   - Checks if placing a queen at (`row`, `col`) is safe:
      - No queen exists in the same column (`queens[i] == col`).
      - No queen exists in the same diagonal (absolute difference of row and column indices is equal for diagonals).

4. `constructBoard(queens, n)`: Chessboard Construction
   - Creates a list of strings representing the chessboard configuration.
   - Places a 'Q' in positions indicated by the `queens` array, and '.' in empty spaces.

Time Complexity: O(N!), where N is the size of the chessboard. In the worst case, we might explore all N! permutations of queen placements.
Space Complexity: O(N) to store the `queens` array and the recursion stack. The `solutions` list can grow up to N! in the worst case.
*/
import java.util.*;

public class NQueens {

    // Main function to find all solutions
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n]; // Array to store column positions of queens for each row
        solve(solutions, queens, 0, n); // Start backtracking from row 0
        return solutions;
    }

    // Recursive backtracking function to solve the N-Queens problem
    private void solve(List<List<String>> solutions, int[] queens, int row, int n) {
        // Base case: If we've placed queens in all rows, add the solution
        if (row == n) {
            solutions.add(constructBoard(queens, n));
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) { // Check if placement is valid
                queens[row] = col;       // Place the queen
                solve(solutions, queens, row + 1, n); // Recur for the next row
                // Implicit backtracking: The queen is removed by overwriting it in the next iteration
            }
        }
    }

    // Function to check if a queen placement is valid
    private boolean isValid(int[] queens, int row, int col) {
        // Check all previously placed queens
        for (int i = 0; i < row; i++) {
            // Check if the queen is in the same column or diagonal
            if (queens[i] == col || Math.abs(queens[i] - col) == row - i) { 
                return false;
            }
        }
        return true; // Valid placement
    }

    // Function to construct the chessboard representation from queen positions
    private List<String> constructBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.'); // Fill with empty spaces
            row[queens[i]] = 'Q';   // Place the queen at the calculated column
            board.add(new String(row));
        }
        return board;
    }
}
