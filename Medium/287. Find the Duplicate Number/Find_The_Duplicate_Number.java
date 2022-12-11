/*
 Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 */

/*
 * Very tricky given the constraints. THis approach involves using binary search as well as 
 * the PigeonHole Principle. Saying if you have 6 pigeons and 5 holes, then 1 hole will have to
 * contain 2 pigeons. In this case, the condition that we use is that the duplicate number, n, and 
 * all larger numbers will have n + 1 numbers that are less than or equal to it. 
 * For example,
 * in the array [3,1,3,4,2] numbers 3 and 4 have 4 and 5 numbers respectively that are equal
 * or smaller than itself. 3 has 1,2,3,3 which is 4 and 4 has the whole array. The trick is 
 * to use this knowledge to find the smalles number that satisfies this condition and that 
 * number will be our duplicate. In this case, that is 3 as the next lowest number, 2, only
 * has 2 numbers <= equal to itself
 */
class Solution {
    public int findDuplicate(int[] nums) {
        //We will be searching through the numbers [1,n] as this is our domain of answers
        //Initiate variables for binary search
        int high = nums.length - 1;
        int low = 1;    
        while(low< high){
            int middle = low + (high - low)/2;
            int count=0;
            //gets the count of numbers that fit the criteria of the pigeonhole principle
            for(int i=0; i < nums.length; i++){
                if(nums[i] <= middle)
                    count++;
            }
            
            //updating the binary search intervals
            if(count <= middle)
                low = middle + 1;
            else 
                high = middle;
        }
        return low;
    }
}