/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * 
 * https://www.youtube.com/watch?v=wgFPrzTjm7s&ab_channel=NeetCode
 * 
 * This function adds two numbers that are represented as linked lists.
 * Each node in the linked list represents a single digit, and the digits are stored in reverse order.
 * The function returns a new linked list representing the sum of the input numbers.
 *
 * The digits of the numbers are stored in reverse order in the linked lists.
 * The function returns a new linked list representing the sum of the input numbers.
 * The sum is also represented as a linked list in reverse order.
 *
 * The function handles carryover from one digit to the next and creates new nodes as necessary to represent the sum.
 * If there is a carryover after adding the last digits, a new node is created with the carryover value.
 *
 * The function uses a dummy head for the result list for simplicity.
 * The actual result list starts from the next node of the dummy head.
 *
 * The time complexity of the function is O(max(m, n)), where m and n are the lengths of the two input linked lists.
 * The space complexity is also O(max(m, n)) because a new list is created to store the result.
 *
 * The function does not modify the input linked lists. It creates a new list for the result.
 * The function is robust and can handle input linked lists of different lengths.
 * It treats missing nodes in the shorter list as zeros.
 *
 *
 * @param l1 The first linked list representing a number.
 * @param l2 The second linked list representing a number.
 * @return A new linked list representing the sum of the numbers represented by l1 and l2.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
        ListNode dummyHead = new ListNode(0); // Create a dummy head for the result list
        ListNode first = l1, second = l2, curr = dummyHead; // Initialize pointers for l1, l2 and the result list
        int carry = 0; // Initialize carry
        
        // Loop through lists l1 and l2 until you reach both ends.
        while (first != null || second != null) {
            // Get the current value, if the node exists, else 0
            int x = (first != null) ? first.val : 0;
            int y = (second != null) ? second.val : 0;
            int sum = carry + x + y; // Calculate the sum
            carry = sum / 10; // Update carry
        
            // Create a new node with the digit value of sum and set it to the current node's next
            curr.next = new ListNode(sum % 10);
            curr = curr.next; // Move the current node to next
        
            // Move to next nodes of l1 and l2
            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }
        
        // If there is still a carry after going through both lists, add a new node with carry value
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        return dummyHead.next; // Return the result list, dummyHead's next node is the start of the listl̥
    }
  }
