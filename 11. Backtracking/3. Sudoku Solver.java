/*
https://leetcode.com/problems/sudoku-solver/

37. Sudoku Solver - Backtracking Solution

Problem Description:

Write a program to solve a Sudoku puzzle by filling the empty cells. A Sudoku puzzle is a 9x9 grid where each cell can contain a digit from 1 to 9. 
The puzzle is considered solved when every row, column, and 3x3 sub-box contains each digit from 1 to 9 exactly once.

Algorithm Overview (Backtracking):

1. Find an Empty Cell:
    - Iterate through the Sudoku board to find an empty cell (represented by '.').

2. Try Valid Numbers:
    - For each empty cell, iterate through the numbers from 1 to 9.
    - Check if placing the current number in the cell is valid (using `isValid` function).

3. Recurse and Backtrack:
    - If the number is valid, place it in the cell and recursively call `solve` to attempt to fill the rest of the board.
    - If the recursive call returns true, it means a solution was found, so return true.
    - If the recursive call returns false, it means the number is not valid, so reset the cell to '.' (empty) and try the next number.
    - If no valid number can be placed in the current cell, return false to trigger backtracking.

4. Success/Failure:
    - If all cells are filled (the recursive base case), return true (solution found).
    - If no valid number can be placed in any empty cell, return false (no solution).

Time Complexity: O(9^(N^2)) In the worst case, for each of the empty cells, we have 9 possible numbers to try.
Space Complexity: O(N^2) The board itself takes N^2 space, and the recursive stack in the worst case can also have a depth of N^2.
*/

class Solution {
  // Main function to solve the Sudoku puzzle
  public void solveSudoku(char[][] board) {
      solve(board);
  }

  // Recursive backtracking function to solve Sudoku
  private boolean solve(char[][] board) {
      // Iterate over all cells
      for (int row = 0; row < 9; row++) {
          for (int col = 0; col < 9; col++) {

              // If the cell is empty ('.')
              if (board[row][col] == '.') {
                  // Try placing each number from '1' to '9'
                  for (char num = '1'; num <= '9'; num++) {
                      if (isValid(board, row, col, num)) {  // Check if it's valid to place 'num'
                          board[row][col] = num;           // Place the number

                          if (solve(board)) {           // Recursively try to solve the rest of the board
                              return true;                 // If successful, propagate true up the recursion
                          } else {
                              board[row][col] = '.';  // Backtrack - remove the number if it doesn't lead to a solution
                          }
                      }
                  }

                  return false; // No valid number found for this cell, trigger backtracking
              }
          }
      }

      return true; // If all cells filled, solution found
  }

  // Function to check if a number placement is valid
  private boolean isValid(char[][] board, int row, int col, char num) {
      // Check if 'num' exists in the current row
      for (int x = 0; x < 9; x++) {
          if (board[row][x] == num) {
              return false;
          }
      }

      // Check if 'num' exists in the current column
      for (int x = 0; x < 9; x++) {
          if (board[x][col] == num) {
              return false;
          }
      }

      // Check if 'num' exists in the 3x3 sub-box
      int startRow = row - row % 3; // Starting row index of the sub-box
      int startCol = col - col % 3; // Starting col index of the sub-box
      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
              if (board[i + startRow][j + startCol] == num) {
                  return false;
              }
          }
      }

      return true; // Number placement is valid
  }
}
