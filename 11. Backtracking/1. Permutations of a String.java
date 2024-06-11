/*
Permutations of a String - Backtracking Approach

Problem Description:
Given a string `S`, find all permutations (unique rearrangements of characters) of the string.

Algorithm Overview (Recursive Backtracking):

1. Base Case:
   - If the `index` reaches the end of the string (`S.length() - 1`), we've generated a permutation. Add it to the `result` list.

2. Recursive Case:
   - Iterate over characters from `index` to the end of the string.
   - For each character:
      - Swap it with the character at `index`.
      - Recursively call `permute` to generate permutations for the rest of the string.
      - Swap back (backtrack) to restore the original order for the next iteration.

Time Complexity: O(N! * N), where N is the length of the string.
   - There are N! permutations.
   - Generating each permutation takes O(N) time (due to swapping and creating a new string in the worst case).

Space Complexity: O(N!), due to storing the permutations in the result list. The recursion depth is also N in the worst case. 
*/
import java.util.*;


class Solution {
    public List<String> find_permutation(String S) {
        List<String> result = new ArrayList<>();
        permute(S.toCharArray(), 0, result); // Start backtracking with index 0
        return result;
    }

    private void permute(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars)); // Found a permutation, add to result
            return;
        }

        // Fix the current character and permute the rest
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);           // Swap the characters at indices index and i
            permute(chars, index + 1, result); // Recursively permute the rest of the string
            swap(chars, index, i);           // Backtrack: swap back to restore the original order
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

