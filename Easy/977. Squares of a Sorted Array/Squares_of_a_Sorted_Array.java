
class Squares_of_a_Sorted_Array {
    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length -1;
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--)
        {
            if (Math.abs(nums[left]) > Math.abs(nums[right]))
            {
                res[i] = nums[left] * nums[left];
                left++;
            }
            else
            {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

    public static void print(int[] arr)
    {
        for (int i=0; i <  arr.length; i++)
        System.out.print(arr[i] + " ");
    }

    public static void main(String[] args)
    {
        int[] array = {-4,-1,0,3,10};
        print(sortedSquares(array));
    }
}