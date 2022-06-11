class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Initializing pointers to the ends of each array
        //Finish when we hit the end of nums1 or m because nums1 is larger
        int tail1 = m - 1, tail2 = n - 1, finished = nums1.length - 1;
        while(tail1 >= 0 && tail2 >=0)
            nums1[finished--] = (nums1[tail1] > nums2[tail2] ? nums1[tail1--] : nums2[tail2--]);
        while(tail2 >=0 )
            nums1[finished--] = nums2[tail2--];
    }
}