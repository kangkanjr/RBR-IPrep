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
     * https://leetcode.com/problems/middle-of-the-linked-list/description/
     * 
     * The 'middleNode' method finds the middle node of a given linked list.
     * It uses two pointers, 'slow' and 'fast', both initialized at the head of the list.
     * In a loop, 'slow' moves one step at a time, while 'fast' moves two steps.
     * When 'fast' reaches the end of the list, 'slow' will be at the middle.
     * The method then returns the 'slow' pointer, which points to the middle node.
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;  // Initialize slow pointer as head
        ListNode fast = head;  // Initialize fast pointer as head

        // Iterate through the linked list until we reach the end
        while (fast != null && fast.next != null) {
            slow = slow.next;  // Move slow pointer one step forward
            fast = fast.next.next;  // Move fast pointer two steps forward
        }

        // When the fast pointer reaches the end, the slow pointer will be at the middle
        return slow;
    }
}