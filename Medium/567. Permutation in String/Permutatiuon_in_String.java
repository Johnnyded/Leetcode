/*
 Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
 
Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.

Explanation:
    Using the sliding window technique, we create a window the size of s1 as that is the 
    expected permutation length. We keep track of the frequency of letters and return true 
    if at any point of the sliding window do the frequencies of the 2 frequency maps we create
    match. We simply iterate along the second string and update the frequency list for the 
    second string by adding the next letter's frequency and removing the previous numbers frequency
    hence the sliding window.
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        
        //declare the 2 frequency maps
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        //Create the window
        for(int i=0; i < s1.length(); i++){
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        
        //main loop to shift window over 1
        for(int i=0; i < s2.length() - s1.length(); i++){
            //if they match then return true
            if(matches(map1, map2))
                return true;
            
            //shift window over 1 whilst dropping previous letter from map2
            map2[s2.charAt(i + s1.length()) - 'a']++;
            map2[s2.charAt(i) - 'a']--;
        }
        return matches(map1, map2);
    }
    
    //array match function
    public boolean matches(int[] map1, int[] map2){
        for(int j=0; j < 26; j++)
                if(map1[j] != map2[j]) 
                    return false;
            return true;
    }
    
}