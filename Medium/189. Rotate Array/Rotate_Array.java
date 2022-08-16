/*
 Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Explanation: Here if we observe the examples, we can devise a strategy where we flip 
the entire array and then break apart the 2 at a specified point(k) which will result an array 
that has been rotated/pushed a certain amount of steps
We will simply make the abstract version into another funciton and use that to drive our
simple flipping logic
 */
class Solution {
    //function to flip the array from a start to end
    public void flip(int[] arr, int start, int end){
        while(start < end){
            if(arr.length <= 1) break; //not sure if this is useful but fck it
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
    
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        flip(nums, 0, nums.length-1);
        flip(nums, 0, k-1);
        flip(nums, k, nums.length - 1);
    }
}