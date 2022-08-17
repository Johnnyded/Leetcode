/*
 Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Very simple two pointer problem, just close pointers in as we swap the front and ends

 */
class Solution {
    public void reverseString(char[] s) {
        //initiate two-pointers
        int front=0, end=s.length-1;
        while(front < end ){
            char temp = s[front];
            s[front] = s[end];
            s[end] = temp;
            front++;
            end--;
        }
    }
}