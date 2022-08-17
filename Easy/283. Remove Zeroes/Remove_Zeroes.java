/*
 Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Explanation: For this problem, I created a swap function and decided to go from right to left.
Everytime a zero was encountered, it would be swapped with the element to the right until it 
hits the end. This is severely inefficient and could be better implemented. For example, we could stop
swapping when we hit another 0 however it goes all the way until the end. There is also another
implementation that goes left to right involving a snowballing variable that minimizes the number 
of swaps
 */
class Solution {
    public void swap(int[] nums, int num1, int num2){
        int temp = 0;
        temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        //iterate right to left skipping the rightmost number if it is a 0
        for(int i=len - 1; i >= 0; i--){
            if(nums[i] == 0 && i != len-1){
                int temp = i;
                //when a 0 is encountered, move it all the way to the right using repetitive swaps
                while(temp != len-1){
                    swap(nums, temp, temp+1);
                        temp++;
                }
            }
        }
    }
}