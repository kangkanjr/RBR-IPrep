// Definition for singly-linked list node.
class ListNode {
    int val;            // Value of the node
    ListNode next;      // Pointer to the next node
    ListNode(int x) {   // Constructor to initialize the node
        val = x;
    }
}

class Solution {
    /**
     * https://leetcode.com/problems/reverse-linked-list/description/
     * 
     * The 'reverseList' method reverses a given linked list.
     * It uses three pointers: 'prev', 'curr', and 'nextTemp'.
     * 'prev' is initialized as null, 'curr' is initialized at the head of the list, and 'nextTemp' is initialized as null.
     * In a loop, 'nextTemp' stores the next node of 'curr', the 'next' pointer of 'curr' is reversed to point to 'prev',
     * and then 'prev' and 'curr' are moved one step forward.
     * This process continues until 'curr' reaches the end of the list.
     * At this point, 'prev' points to the last node of the original list, which is the head of the reversed list.
     * The method finally returns 'prev', which is the head of the reversed list.
     */

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;     // Initialize previous node as null
        ListNode curr = head;     // Initialize current node as head
        ListNode nextTemp = null; // Initialize next node as null

        // Iterate through the linked list until we reach the end
        while (curr != null) {
            nextTemp = curr.next;  // Store the next node
            curr.next = prev;      // Reverse the link
            prev = curr;           // Move prev and curr one step forward
            curr = nextTemp;
        }

        // Return the reversed list
        return prev;
    }
}
