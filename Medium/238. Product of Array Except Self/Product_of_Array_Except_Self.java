/*
 Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

This aproach involves using a temporary variable to keep track of past products as we iterate through the array 
from the left AND the right for a total of 2 scans giving a complexity of O(2n) which is just O(n)
We first fill our resultant array with the products of the preceding numbers meaning on the left
Then we go reverse through the array and use the same method but this time whilst multiplying the "preceding" or
right handed products with their left-sided products to get the right product for that num[i]
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i=0, tmp=1; i < nums.length; i++){
            result[i] = tmp;
            tmp *= nums[i];
        }
        for (int i=nums.length-1, tmp=1; i >=0; i--){
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }   
}