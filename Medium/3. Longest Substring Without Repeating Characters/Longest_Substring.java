/*
 Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.


 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for(int i=0, j=0; i < s.length(); i++){
            //If the character has already been discovered then move the j pointer to the right of that last found letter
            if(map.containsKey(s.charAt(i)))
                //calculating variable j 
                j = Math.max(j, map.get(s.charAt(i))+1);
            //insert/update the letter's count into the map
            map.put(s.charAt(i), i);
            //max is calculated 
            max = Math.max(max, i-j+1);
        }
        return max;
        
    }
}