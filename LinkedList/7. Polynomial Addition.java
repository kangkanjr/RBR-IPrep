    /**
     * https://www.geeksforgeeks.org/problems/polynomial-addition/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
     * 
     * https://www.youtube.com/watch?v=cFHZ-a87Vp4&ab_channel=NesoAcademy
     * 
     * This function, addPolynomials, is designed to add two polynomials which are represented as linked lists.
     * Each node in the linked list represents a term in the polynomial. The 'coefficient' field of the node stores the coefficient of the term,
     * and the 'pow' field stores the power of the term. The 'next' field points to the next term in the polynomial.
     *
     * The function takes two parameters, p1 and p2, which are the head nodes of the linked lists representing the two polynomials to be added.
     *
     * The function works by iterating through the nodes of the two polynomials simultaneously. For each pair of nodes, it compares the powers of the terms.
     * If the powers are equal, it creates a new node with the same power and the sum of the coefficients, and appends this node to the result list.
     * If the power of the term in the first polynomial is greater, it appends this node to the result list and moves to the next node in the first polynomial.
     * If the power of the term in the second polynomial is greater, it appends this node to the result list and moves to the next node in the second polynomial.
     *
     * If all nodes of one polynomial have been processed but there are remaining nodes in the other polynomial, these remaining nodes are appended to the result list.
     *
     * The function returns the head node of the resulting polynomial after addition. The result is also a linked list, where each node represents a term in the result polynomial.
    */

 
/*class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}*/

//Print the polynomial formed by adding both LL in the function itself.
class Solution{
    public static Node addPolynomial(Node p1,Node p2){

        // Initialize nodes for the two polynomials and the result polynomial
        Node poly1 = p1, poly2 = p2, resultHead = new Node(0, 0), 
             res = resultHead; 
    
        // Loop until we've processed all nodes of both polynomials
        while (poly1 != null || poly2 != null) { 
    
            // If we've processed all nodes of the first polynomial, append remaining nodes of the second polynomial
            if (poly1 == null) { 
                res.next = poly2; 
                break; 
            } 
            // If we've processed all nodes of the second polynomial, append remaining nodes of the first polynomial
            else if (poly2 == null) { 
                res.next = poly1; 
                break; 
            } 
    
            // If powers are equal, add coefficients and move to next nodes in both polynomials
            else if (poly1.pow == poly2.pow) { 
                res.next = new Node(poly1.coeff + poly2.coeff, poly1.pow); 
    
                poly1 = poly1.next; 
                poly2 = poly2.next; 
            } 
    
            // If power of first polynomial is greater, append this node to the result and move to next node in the first polynomial
            else if (poly1.pow > poly2.pow) { 
                res.next = new Node(poly1.coeff, poly1.pow); 
    
                poly1 = poly1.next; 
            } 
    
            // If power of second polynomial is greater, append this node to the result and move to next node in the second polynomial
            else if (poly1.pow < poly2.pow) { 
                res.next = new Node(poly2.coeff, poly2.pow); 
    
                poly2 = poly2.next; 
            } 
    
            // Move to the next node in the result polynomial
            res = res.next; 
        } 
    
        // Return the result polynomial, skipping the initial dummy node
        return resultHead.next; 
    }
}