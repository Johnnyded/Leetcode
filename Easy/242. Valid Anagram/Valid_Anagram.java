class Solution {
    public boolean isAnagram(String s, String t) {
        //The boolean is immediately false if the lengths of the strings are different
        if (s.length() != t.length())
            return false;
        //declaring array to keep track of count of number of letters
        int[] count = new int[26];
        /* We go through the letters in each string using a single loop as the length
         *  of both strings should be the same. We subtract a to get the unique numerical value
         *   that the letter lies at e.g 'g'(103) - 'a'(97) = 6. Therefore the letter g would
         *    represent the 6th index in the array OR in simpler terms the 7th letter
         *     in the alphabet
         */
        for (int i=0; i < s.length(); i++)
        {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        /*
         * So if the strings ARE indeed anagrams, then the values of all the elements in the
         *  counter array should be 0 as we increment and decrement for each individual letter
         *   in the strings. Which makes sense because anagrams are identifiable because they
         *    contain the same number of letters in different arrangement.
         */
        for (int i : count)
            if (i != 0)
                return false;
        //The strings are anagrams if the counts are all 0 in the array
        return true;
    }
}