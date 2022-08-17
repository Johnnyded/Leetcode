/*
 Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


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
 * 
 * Explanation:
 *  Using the two pointers, we first start by creating a dummy node that points to the head node
 *  creating a new dummy head. This is for the case in which the first node is the node that needs to be
 * deleted. Afterward we initalize 2 pointers to point at the newly created dummy node.
 * By creating a gap between the 2 pointers of n size, we can get the second pointer to step all
 * the way to the node BEFORE the nth node from the end(as the problem asks). We then simply
 * readjust the node's pointer to skip OVER the nth node, and point to the next one, giving us a 
 * linked list with the nth node removed. Return the dummy's next which is the head, regardless 
 * if the old head has been deleted or not
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        
        //Move the first pointer until it is n nodes apart from the second pointer
        for(int i=0; i <= n; i++){
            first = first.next;
        }
        
        //move both pointers until first/leading pointer hits the null node that the last node points to
        while(first != null){
            first = first.next;
            second = second.next;
        }
        
        //now the second node will be at the node right before the node that needs to be removed so we simply adjust the ListNode object in the element that the second pointer is on to point to the ListNode AFTER the next one, effectively removing the nth node
        second.next = second.next.next;
        return dummy.next;
    }
}