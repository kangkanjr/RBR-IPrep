/*
https://www.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1

Remove Duplicates from a String

Problem Description:
Given a string `str`, the task is to remove all duplicate characters from the string and return a new string with unique characters 
  in the same order as the original string.

Algorithm Overview (Using LinkedHashSet):

1. Create LinkedHashSet:
   - A LinkedHashSet is used to store characters while maintaining their insertion order.

2. Iterate Through String:
   - For each character `c` in the input string `str`:
     - Add `c` to the `set`. Since sets don't allow duplicates, each character will be added only once.

3. Build Result String:
   - Create an empty StringBuilder `sb` to build the result string efficiently.
   - Iterate over the `set`:
     - Append each character from the set to the `sb`.

4. Return Result:
   - Convert the StringBuilder `sb` to a String and return it.

Time Complexity: O(N), where N is the length of the string. We iterate through the string twice 
  (once for adding to the set, once for building the result string).
Space Complexity: O(N) in the worst case, if all characters in the string are unique. 
  The LinkedHashSet and StringBuilder will store all the characters.
*/

import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        // Create a LinkedHashSet to store unique characters while maintaining order
        LinkedHashSet<Character> set = new LinkedHashSet<>(); 

        // Iterate through the string and add each character to the set
        for (char c : str.toCharArray()) {
            set.add(c); 
        }

        // Create a StringBuilder to build the result string efficiently
        StringBuilder sb = new StringBuilder(); 

        // Iterate through the set (which now contains unique characters)
        for (Character c : set) {
            sb.append(c); // Append each unique character to the StringBuilder
        }

        return sb.toString(); // Convert the StringBuilder to a String and return it
    }
}
