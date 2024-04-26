// Definition for singly-linked list node.
class ListNode {
    int val;            // Value of the node
    ListNode next;      // Pointer to the next node
    ListNode(int x) {   // Constructor to initialize the node
        val = x;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode startNode = new ListNode(0);  // Initialize a start node
        startNode.next = head;                 // Point the next of start node to head
        ListNode first = startNode;            // Initialize first pointer as startNode
        ListNode second = startNode;           // Initialize second pointer as startNode

        // Move the first pointer n nodes ahead in the linked list
        for (int i = 1; i <= n + 1; i++) {
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

        // Remove the nth node from the end of the linked list
        Solution solution = new Solution();
        ListNode modifiedHead = solution.removeNthFromEnd(head, 2);

        // Print the modified linked list
        System.out.println("\nModified Linked List:");
        printList(modifiedHead);
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
