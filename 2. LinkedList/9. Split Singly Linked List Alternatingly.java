/**
 * https://www.geeksforgeeks.org/problems/split-singly-linked-list-alternatingly/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
 * 
 * The alternatingSplitList() method is used to split a given linked list into two halves.
 * The original list is split in such a way that one half contains nodes at even indexes,
 * and the other half contains nodes at odd indexes.
 *
 * @param head The head node of the original linked list.
 *
 * The method works as follows:
 * 1. It first initializes two pointers, GFG.a and GFG.b, to the first two nodes of the original list.
 * 2. It enters a loop that continues until all nodes in the original list have been visited.
 * 3. Inside the loop, it saves the next node in the original list in a temporary node.
 * 4. It then updates the next pointer of the current node to skip one node ahead. If the next node does not exist, it sets the next pointer to null.
 * 5. It then moves to the next node in the original list.
 */

 
/*
The structure of node class is:
class Node {
    int data;
    Node next;
    
    public Node(int head){
        this.data = head;
        this.next = null;
    }
}
*/

/*

class GFG {
    public static Node a; //store the head of first list in this
    public static Node b; //store the head of second list in this
}
*/


class Solution {
    public void alternatingSplitList(Node head){
       // Initialize pointers for the heads of the two resulting lists
        GFG.a = head;
        GFG.b = head.next;
    
        // Temporary node to keep track of the next node in the original list
        Node temp;
    
        // Iterate over the original list
        while (head != null) {
            // Save the next node in the original list
            temp = head.next;
    
            // If the next node exists, point the current node to the node after the next node
            // Otherwise, point the current node to null
            head.next = (temp != null) ? temp.next : null;
    
            // Move to the next node in the original list
            head = temp;
        }
    }
    
}