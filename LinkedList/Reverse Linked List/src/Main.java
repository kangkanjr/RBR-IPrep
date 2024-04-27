/**
 * The 'reverseList' method reverses a given linked list.
 * It uses three pointers: 'prev', 'curr', and 'nextTemp'.
 * 'prev' is initialized as null, 'curr' is initialized at the head of the list, and 'nextTemp' is initialized as null.
 * In a loop, 'nextTemp' stores the next node of 'curr', the 'next' pointer of 'curr' is reversed to point to 'prev',
 * and then 'prev' and 'curr' are moved one step forward.
 * This process continues until 'curr' reaches the end of the list.
 * At this point, 'prev' points to the last node of the original list, which is the head of the reversed list.
 * The method finally returns 'prev', which is the head of the reversed list.
 */

// Definition for singly-linked list node.
class ListNode {
    int val;            // Value of the node
    ListNode next;      // Pointer to the next node
    ListNode(int x) {   // Constructor to initialize the node
        val = x;
    }
}

class Solution {
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

public class Main {
    public static void main(String[] args) {
        // Create a linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original linked list
        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseList(head);

        // Print the reversed linked list
        System.out.println("\nReversed Linked List:");
        printList(reversedHead);
    }

    // Function to print a linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
