/*
 * Given a non-empty array of integers nums, every element appears twice except for one. 
 * Find that single one.
 * 
 * The idea here is to use Bit Manipulation to rule out the one single number
 * XOR will return 0 when two of the same bit are compared 
 * XOR will return the bit if it is compared with 0
 * The logic is that we want the XOR to essentially get rid of all duplicates and have the
 * final bit equal to the one that is alone
 */

class Solution {
    public int singleNumber(int[] nums) {
        int a=0;
        for(int i : nums){
            a ^= i;
        }
        return a;
    }
}