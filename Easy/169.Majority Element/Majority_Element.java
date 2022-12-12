import java.util.HashMap;
import java.util.Map;

class Majority_Element {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> mappy = new HashMap<>();
        int majority = 0;
        mappy.put(0, 0);
        for(int num : nums){
            //if element is not in table, append it
            if(!mappy.containsKey(num)){
                mappy.put(num, 1);
                // System.out.println("Added value: " + num);
            }
            else{
                mappy.put(num, mappy.get(num)+1);
                // System.out.printf("Just put key %d with value %d\n", num, mappy.get(num));
            }
            if(mappy.get(num) > mappy.get(majority))
                majority = num;
                // System.out.println("new majority is now: " + majority);
        }
        return majority;
    }

    public static void main(String[] args){
        int[] nums = {6, 5, 5};
        int solution = 0;
        solution = majorityElement(nums);
        System.out.println(solution);
    }
}

