/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 * 
 * https://www.youtube.com/watch?v=-OTlqdrxrVI&ab_channel=NeetCodeIO
 * 
 * This method splits a linked list into 'k' consecutive linked list parts.
     * The length of each part will be as equal as possible: no two parts should have a size differing by more than one. 
     * Parts if size less than one will be in the form of null.
     *
     * The method works by first calculating the total length of the linked list.
     * It then calculates the minimum size of each part (minSize) and the number of parts that need to be one node larger (numLarger).
     * This is done to distribute the nodes as evenly as possible across the 'k' parts.
     *
     * The method then iterates over the linked list, creating each part.
     * For each part, it sets the start of the part to the current node, then moves the node pointer to the end of the part.
     * The size of the part is determined by whether the part index is less than numLarger (in which case it is minSize + 1) or not (in which case it is minSize).
     * After determining the end of the part, it disconnects the part from the rest of the list by setting the next of the last node in the part to null.
     *
     * @param head The head node of the linked list.
     * @param k The number of parts to split the linked list into.
     * @return An array of linked list nodes representing the 'k' parts.
 */

 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


 class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int len = 0;
        ListNode node = head;
        // Calculate the length of the linked list
        while (node != null) {
            len++;
            node = node.next;
        }
        
        // Calculate the minimum size of each part and the number of larger parts
        int minSize = len / k;
        int numLarger = len % k;
        
        node = head;
        for (int i = 0; i < k && node != null; i++) {
            result[i] = node;
            
            // Determine the size of the current part
            int partSize = i < numLarger ? minSize + 1 : minSize;
            
            // Move the node pointer to the end of the current part
            for (int j = 0; j < partSize - 1; j++) {
                node = node.next;
            }
            
            // Disconnect the current part from the rest of the list
            ListNode next = node.next;
            node.next = null;
            node = next;
        }
        
        return result;
    }
}