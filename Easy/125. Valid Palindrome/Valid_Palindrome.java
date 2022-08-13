/*
 * A phrase is a palindrome if, after converting all uppercase letters into 
 * lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */

 //String Manipulation Problem
 class Solution {
    public boolean isPalindrome(String s) {
        //Lets try the two pointer method
        int begin = 0, end = s.length() - 1;

        while (begin < end){
            //filtering the non-letter/digits out
            while (!Character.isLetterOrDigit(s.charAt(begin)))
                begin++;
            while (!Character.isLetterOrDigit(s.charAt(end)))
                end--;
            
            //check for letters on opposite ends match, return false if they do not match 
            //meaning that they are it is not a palindrome
            if (!Character.isLetterOrDigit(s.charAt(begin)) != !Character.isLetterOrDigit(s.charAt(end)))
                return false;
            //move onto the next set of letters/digits
            else{
                begin++;
                end--;
            }
            
        }
        //if the loop passes without returning false, then this string is a valid palindrome
        return true;
    }
}