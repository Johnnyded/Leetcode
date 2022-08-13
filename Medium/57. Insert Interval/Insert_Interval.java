/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

/*
 * The approach is a little tricky as it involves a little intuition. We start by creating
 * a result array list because then we can append the correct answer to it as java 
 * arrays are immutable. 
 *  Then we iterate through the intervals and first check if the new Interval fits 
 *  anywhere without overlapping
 * In the case that the new interval does overlap, we update its values with with the
 * overlapped interval(s)'s min and max and append it to the result, giving a perfectly merged array
 *  Once the merged new interval is updated, it will be added as it will fall into one
 *  of the if statements and all subsequent intervals will be added by default with the
 *  clever if statements
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<int[]>();
        
        //Iterate through every interval using enhanced for loop
        for(int[] subInt : intervals){
            //For the case that the newinterval is smaller than the first interval
            if(newInterval[1] < subInt[0]){
                result.add(newInterval);
                newInterval = subInt;
            }
            
            //If new interval is greater than the current interval, skip over it by adding                  it to the result arraylist
            else if(subInt[1] < newInterval[0])
                result.add(subInt);
            
            //Handling overlap by squishing together overlapping arrays which will fall into               the loop above
            else{
                newInterval[0] = Math.min(newInterval[0], subInt[0]); 
                newInterval[1] = Math.max(newInterval[1], subInt[1]); 
            }
        }
        //append last newInterval to the list            
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}