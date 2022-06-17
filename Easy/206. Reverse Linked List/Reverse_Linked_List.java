
 //Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null, nextHead;
        while (head != null)
        {
            nextHead = head.next;
            head.next = newHead;
            newHead = head;
            head = nextHead;
        }
        return newHead;
    }
}