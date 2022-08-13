/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2: 
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */

public class ListNode {
int val;
ListNode next;
ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Beginner Node
        ListNode result = new ListNode(0);
        //pointer to the beginning node
        ListNode current = result;
        //iterate through both pointers til 1 of the lists empties
        while(list1 != null && list2 != null){
            //if/else to sort through and assign the nodes in sorted order using the pointer/current node
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next; 
            }
            else{
                current.next = list2;
                list2 = list2.next;
            }
            //update current pointer
            current = current.next;
        }
        //if one list empties before the other, assign the rest of the list to the end of the result
        current.next=(list1!=null?list1:list2);
        
        return result.next;
    }
}

/*
So we start by creating a new linked list(result) and assigning a dummy pointer(current)
that will point to the head but will use that dummy node as a pointer to create the 
new list.
    We will then interate through both lists and use the dummy pointer to append the 
    lowest of the two node values to our new list. Resulting in a new list that is 
    ascending
We return the head of the new list(result)
*/