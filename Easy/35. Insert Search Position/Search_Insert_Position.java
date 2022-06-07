/**
 * Search Insert Position is a Binary Search Problem that returns the index of a target number within an array. If target DNE, then return the index that it would be placed in order.
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while(left <= right)
        {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            else if (nums[pivot] > target) right = pivot - 1;
            else left = pivot + 1;
        }
        return left;
    }
}