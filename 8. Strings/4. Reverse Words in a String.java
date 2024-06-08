/*
151. Reverse Words in a String

Problem Description:
Given an input string `s`, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space.

Returna string of the words in reverse order concatenated by a single space.

Note that `s` may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. Do not include any extra spaces.

Algorithm Overview:

1. Trim and Split:
   - Trim leading and trailing spaces from the input string `s`.
   - Split the trimmed string into an array of words using spaces as delimiters.

2. Reverse Words:
   - Iterate through the array of words in reverse order.
   - Append each word to a `StringBuilder`, followed by a space (except for the last word).

3. Return Result:
   - Trim any trailing space from the StringBuilder and return the resulting string.

Time Complexity: O(N), where N is the length of the string. We iterate through the string a few times, but each operation is linear.
Space Complexity: O(N), to store the array of words and the StringBuilder.
*/
import java.util.*;

class Solution {
    public String reverseWords(String s) {
        
        // Step 1: Trim leading and trailing spaces and split into words
        String[] words = s.trim().split("\\s+");  // Split on one or more spaces

        // Step 2: Reverse the order of words using a StringBuilder
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) { // Add a space after each word except the last one
                reversed.append(" "); 
            }
        }

        // Step 3: Trim any potential trailing space and return the reversed string
        return reversed.toString().trim(); 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "  the sky is blue  ";
        String reversedString = solution.reverseWords(s);
        System.out.println(reversedString); // Output: "blue is sky the"
    }
}
