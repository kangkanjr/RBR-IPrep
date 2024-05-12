/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * This method creates a deep copy of a linked list where each node has two pointers: 'next' and 'random'.
 * The 'next' pointer points to the next node in the list and the 'random' pointer points to a random node in the list or null.
 *
 * The algorithm is divided into three parts:
 * 1. First pass: We make a copy of each node and link them together side-by-side in a single list.
 * 2. Second pass: We assign the random pointers for the copy nodes.
 * 3. Third pass: We restore the original list and extract the copy list.
 *
 * In this method, we don't need any extra space. The idea is to associate the original node with its copy node in a single linked list.
 * In this way, we don't need extra space to keep track of the new nodes.
 *
 * This solution has a time complexity of O(N) where N is the number of nodes because we process each node exactly once.
 * The space complexity is O(1) as we don't use any additional data structure for the processing.
 * This is an efficient solution as it doesn't use any extra space and it only makes a single pass over the original linked list.
 */

 
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
      if (head == null) {
        return null;
      }
  
      // First pass: make copy of each node,
      // and link them together side-by-side in a single list.
      Node ptr = head;
  
      while (ptr != null) {
  
        // Cloned node
        Node newNode = new Node(ptr.val);
  
        // Inserting the cloned node just next to the original node.
        // If A->B->C is the original linked list,
        // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
        newNode.next = ptr.next;
        ptr.next = newNode;
        ptr = newNode.next;
      }
  
      // Second pass: assign random pointers for the copy nodes.
      ptr = head;
  
      while (ptr != null) {
        if (ptr.random != null) {
          ptr.next.random = ptr.random.next;
        }
        ptr = ptr.next.next;
      }
  
      // Third pass: restore the original list, and extract the copy list.
      Node ptr_old_list = head; // A->B->C
      Node ptr_new_list = head.next; // A'->B'->C'
      Node head_old = head; // head of original list
      Node head_new = head.next; // head of new list
  
      while (ptr_old_list != null) {
        ptr_old_list.next = ptr_old_list.next.next;
        ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : ptr_new_list.next;
        ptr_old_list = ptr_old_list.next;
        ptr_new_list = ptr_new_list.next;
      }
      
      return head_new;
    }
  }