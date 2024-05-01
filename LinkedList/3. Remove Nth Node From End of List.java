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
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
     * 
     * The 'removeNthFromEnd' method removes the nth node from the end of a given linked list.
     * It uses two pointers, 'first' and 'second', both initialized at a dummy start node.
     * The start node's next pointer is pointed to the head of the list.
     * The 'first' pointer is moved n nodes ahead in the list.
     * Then, both 'first' and 'second' pointers are moved at the same pace until 'first' reaches the end.
     * At this point, 'second' points to the node before the node to be removed.
     * The 'next' pointer of the 'second' node is then skipped to the node after the node to be removed, effectively removing it.
     * The method finally returns the next node of the start node, which is the head of the modified list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode startNode = new ListNode(0);  // Initialize a start node
        startNode.next = head;                 // Point the next of start node to head
        ListNode first = startNode;            // Initialize first pointer as startNode
        ListNode second = startNode;           // Initialize second pointer as startNode

        // Move the first pointer n nodes ahead in the linked list
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }

        // Move the first and second pointers at the same pace
        // until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // The second pointer now points to the node before the node to be removed
        second.next = second.next.next;  // Remove the nth node from the end

        // Return the head of the modified list
        return startNode.next;
    }
}

