/**
 * The 'middleNode' method finds the middle node of a given linked list.
 * It uses two pointers, 'slow' and 'fast', both initialized at the head of the list.
 * In a loop, 'slow' moves one step at a time, while 'fast' moves two steps.
 * When 'fast' reaches the end of the list, 'slow' will be at the middle.
 * The method then returns the 'slow' pointer, which points to the middle node.
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

        // Find the middle of the linked list
        Solution solution = new Solution();
        ListNode middleNode = solution.middleNode(head);

        // Print the middle node of the linked list
        System.out.println("\nMiddle Node of the Linked List:");
        System.out.println(middleNode.val);
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
