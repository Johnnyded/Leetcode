/*
 Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"

Explanation:
A more advanced implementation of pointers. In this problem we start by making the string
digestable by converting it to an array of chars. then we use pointers to isolate the 
words and proceed to reverse them in place. By using 2 pointers, we keep track of where
spaces are and then determine a word exists between 2 spaces. Finally convert it back to 
String for the final answer.
 */
class Solution {
    public String reverseWords(String s) {
        int lastSpaceIndex = -1;
        //convert the string to an array of characters
        char[] chArray = s.toCharArray();
        int len = s.length();
        
        //iterate over the entire array of chars
        for(int strIndex = 0; strIndex <= len; strIndex++){
            //if we hit the end OR hit a space
            if(strIndex == len || chArray[strIndex] == ' '){
                //set the pointers to encapsulate the word
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;
                //two pointer swap
                while (startIndex < endIndex){
                    char temp = chArray[startIndex];
                    chArray[startIndex] = chArray[endIndex];
                    chArray[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                //update space index
                lastSpaceIndex = strIndex;
            }
            
        }
        return new String(chArray);
    }
}