/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * 
 * This function finds the intersection node of two singly-linked lists.
 *
 * @param headA The head node of the first linked list.
 * @param headB The head node of the second linked list.
 * @return The intersection node if it exists, otherwise null.
 *
 * The function first calculates the lengths of both linked lists using the helper function 'length'.
 * If the lengths are different, it moves the head pointer of the longer list forward by the difference in lengths.
 * This ensures that the remaining lengths from the current node to the end of both lists are the same.
 *
 * Then, it moves both pointers (one for each list) simultaneously until they meet, which will be the intersection node.
 * If there is no intersection, they will both eventually be null, and the function returns null.
*/

 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 public class Solution {
    private int length(ListNode node) {
            int length = 0;
            while (node != null) {
                node = node.next;
                length++;
            }
            return length;
    }  
  
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      // Calculate the length of both lists.
        int lenA = length(headA), lenB = length(headB);
        
        // Move head pointer of longer list lenA - lenB steps forward.
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        
        // Move both pointers until they meet.
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;  // Now headA and headB are both pointing to the intersection node or null.
    }  
  }
  