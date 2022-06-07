/**
 * Binary search uses a left, right, and pivot pointer to search an array for if a certain element EXISTS in O(log n) time complexity, taking advantage of the fact that the array is already sorted
 */
class Binary_Search {
    public static int search(int[] nums, int target) {
        //declare variables pivot point and left and right pointers
        int pivot, left = 0, right = nums.length - 1; 
        //Sets the pivot to the middle of the left and right pointers and checks if the pivot is the target number
        //Depending on the <> of the pivot number compared to the target, it will discard one half of the array and focus
        //on the other half
        while (left <= right)
        {
            pivot = left + (right - left) / 2; // This method of averaging is to prevent integer overflow but is equivalent to (right + left)/2

            if (nums[pivot] == target) return pivot; //Answer line: returns the pivot/position if the pivot number is the target number

            /*
            Depending on the size of the target relative to the current value in the pivot position, we will shift our left/right pointers to the
            other half of the array. Effectively discarding the other half where the target surely is not
            */
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1; // returns -1 to indicate that the element does not exist
    }

    public static void main(String[] args)
{   
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    // int res = ;
    System.out.println(search(arr, 7));
}
}

