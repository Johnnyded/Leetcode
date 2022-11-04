/*
 * This problem gives us an array as an input and asks us to instantiate it in a class
 * constructor. We will then call sumRange on the object with the inputted array in it.
 * The parameters of sumRange will be the indexes the at which the function must return 
 * a sum of all the numbers in between.
 * 
 * NumArray arr = new NumArray([3,4,1,7,9,12])
 * arr.sumRange(1,4)
 * 
 * returns 21; //4 + 1 + 7 + 9 = 21
 */

class Ranged_Sum_Query {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        for(int i=0; i < nums.length; i++)
            sum[i+1] = sum[i] + nums[i];
    }
    
    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */