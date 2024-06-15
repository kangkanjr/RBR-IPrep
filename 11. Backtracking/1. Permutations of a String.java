/*
https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1

Permutations of a String with Duplicates - Backtracking and HashSet Approach

Problem Description:
Given a string `S`, this code finds all unique permutations of the string, even if it contains duplicate characters. The permutations are returned in lexicographically sorted order.

Algorithm Overview:

1. `find_permutation(String S)`: Main Function
   - Initializes a list `permutations` to store the unique permutations.
   - Converts the input string `S` to a character array `chars`.
   - Calls the `permute` helper function with the character array and an initial index of 0 to start the recursive process.
   - After generating permutations, sorts them in lexicographic (dictionary) order.
   - Returns the sorted list of unique permutations.

2. `permute(char[] chars, int index, List<String> permutations)`: Recursive Helper Function
    - Base Case:
        - If `index` is at the last character (`chars.length - 1`), we've found a permutation. 
        - Create a new string from the `chars` array and add it to the `permutations` list.
        - Return to the previous level of recursion.
    - Recursive Case:
        - Create a HashSet `seen` to keep track of characters already used at the current level of recursion.
        - Iterate through the remaining characters (starting from `index`).
        - If the current character has not been seen at this level:
            - Add the current character to `seen` to mark it as used.
            - Swap the current character with the character at position `index`.
            - Recursively call `permute` to find permutations with the remaining characters (from index + 1).
            - Swap back the characters to restore the original order (backtracking). 

3. `swap(char[] chars, int i, int j)`: Helper Function
   - Swaps two characters in the given `chars` array at positions `i` and `j`.
*/
import java.util.*;

class Solution {
     // Function to find all permutations of the given string
     public static List<String> find_permutation(String str) {
        List<String> permutations = new ArrayList<>(); // List to store all permutations
        permute(str.toCharArray(), 0, permutations);  // Start permutation from index 0
        Collections.sort(permutations);  // Sort the permutations to get them in lexicographical order
        return permutations;
    }

    // Recursive helper function to generate permutations
    private static void permute(char[] chars, int index, List<String> permutations) {
        // Base case: if we've reached the last index, add the current permutation to the list
        if (index == chars.length - 1) {
            permutations.add(new String(chars)); // Convert char array to string and add to list
            return;
        }

        Set<Character> seen = new HashSet<>(); // Set to track characters that have been used at this index
        for (int i = index; i < chars.length; i++) {
            // If the character at position i has not been used at the current position
            if (seen.add(chars[i])) { // Add to set and check if it was already added
                swap(chars, index, i); // Swap characters at positions index and i
                permute(chars, index + 1, permutations); // Recursively permute the remaining characters
                swap(chars, index, i); // Backtrack: swap back to restore the original array
            }
        }
    }

    // Function to swap two characters in the array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
