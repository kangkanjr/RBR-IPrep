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
     * https://leetcode.com/problems/linked-list-cycle/description/
     * 
     * This method checks if a given linked list has a cycle in it.
     * It uses Floyd's cycle detection algorithm, also known as the "tortoise and the hare" algorithm.
     * 
     * The algorithm works as follows:
     * 1. Two pointers, 'slow' and 'fast', are initialized at the head of the list.
     * 2. Both pointers move forward, 'slow' moves one step at a time, and 'fast' moves two steps at a time.
     * 3. If there is a cycle in the list, 'fast' will eventually catch up to 'slow', and we return true.
     * 4. If 'fast' reaches the end of the list, it means there is no cycle, and we return false.
     * 
     * The reason this algorithm works is that 'fast' moves at twice the speed of 'slow'. If there is a cycle,
     * 'fast' will enter the cycle first, and 'slow' will enter after. Inside the cycle, 'fast' will continue
     * to gain on 'slow' until they eventually meet, proving the existence of a cycle.
     * 
     * @param head The head node of the linked list.
     * @return true if there is a cycle in the list, false otherwise.
     */
    public boolean hasCycle(ListNode head) {
        // Initialize two pointers, slow and fast. Slow moves one step at a time while fast moves two steps at a time.
        ListNode slow = head, fast = head;
        
        // Traverse the list with slow and fast pointers.
        while (fast != null && fast.next != null) {
            slow = slow.next;  // Move slow pointer one step
            fast = fast.next.next;  // Move fast pointer two steps
            
            // If slow and fast meet at some point then there is a cycle
            if (slow == fast) {
                return true;
            }
        }
        
        // If we reach here then there is no cycle in the list
        return false;
    }
}
