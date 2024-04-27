public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/description/
     * 
     * This method checks if a given linked list has a cycle in it and returns the node where the cycle begins.
     * It uses Floyd's cycle detection algorithm, also known as the "tortoise and the hare" algorithm.
     * 
     * The algorithm works as follows:
     * 1. Two pointers, 'slow' and 'fast', are initialized at the head of the list.
     * 2. Both pointers move forward, 'slow' moves one step at a time, and 'fast' moves two steps at a time.
     * 3. If there is a cycle in the list, 'fast' will eventually catch up to 'slow', indicating a cycle.
     * 4. To find the start of the cycle, we reset 'slow' to the head of the list and move both 'slow' and 'fast' one step at a time.
     * 5. The point where 'slow' and 'fast' meet again is the start of the cycle.
     * 6. If 'fast' reaches the end of the list, it means there is no cycle, and we return null.
     * 
     * The reason this algorithm works is that 'fast' moves at twice the speed of 'slow'. If there is a cycle,
     * 'fast' will enter the cycle first, and 'slow' will enter after. Inside the cycle, 'fast' will continue
     * to gain on 'slow' until they eventually meet, proving the existence of a cycle. The meeting point is not
     * necessarily the start of the cycle. By resetting 'slow' to the head of the list and moving both pointers
     * at the same speed, they will meet again at the start of the cycle.
     * 
     * @param head The head node of the linked list.
     * @return The node where the cycle begins. If there is no cycle, return null.
     */
    public ListNode detectCycle(ListNode head) {
        // Initialize two pointers, slow and fast. Slow moves one step at a time while fast moves two steps at a time.
        ListNode slow = head, fast = head;
        
        // Traverse the list with slow and fast pointers.
        while (fast != null && fast.next != null) {
            slow = slow.next;  // Move slow pointer one step
            fast = fast.next.next;  // Move fast pointer two steps
            
            // If slow and fast meet at some point then there is a cycle
            if (slow == fast) {
                break;
            }
        }
        
        // If no cycle is detected, return null
        if (fast == null || fast.next == null) {
            return null;
        }
        
        // Reset slow to the head of the list and move both slow and fast one step at a time.
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // The point where slow and fast meet again is the start of the cycle
        return slow;
    }
}
