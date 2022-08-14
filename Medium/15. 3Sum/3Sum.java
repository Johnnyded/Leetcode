/*
 Given an integer array nums, return all the triplets [nums[i], 
 nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //two-pointer method only works with sorted lists
        Arrays.sort(nums);
        //create result list of list of integers
        List<List<Integer>> result = new LinkedList();
        /*
         * We will be iterating through the sorted array whilst skipping duplicates and
         * applying the 2 sum target search for the other 2 numbers
         */
        for(int i=0; i < nums.length - 2; i++){
            //execute our search on the number in the array on the condition that
            // the number is not a duplicate
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                //setting/updating the boundaries for the two-sum search
                int low = i+1;
                int high = nums.length-1;
                int sum = 0 - nums[i];
                
                //iterating through the array whilst ignoring any number we already searched for pairs for
                while(low < high){
                    //If answer is found, add it to the resultant list
                    if(nums[low] + nums[high] == sum){
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //skip over the duplicates(by going to the last duplicate) when                             
                        //adjusting the lower and upper pointers
                        while(low < high && nums[low] == nums[low+1]) 
                            low++;
                        while(low < high && nums[high] == nums[high-1])
                            high--;
                        //final increment to move on to the next valid pair
                        low++;
                        high--;
                    }
                    //Now for the case where the 2 numbers do NOT forma 3sum, we decide                         
                    //where to move the pointers based on the resultant numbers range from the                     target sum
                    else if(nums[low] + nums[high] > sum)
                        high--;
                    else low++;
                    
                }
            }
        }
               return result;
        
    }
}