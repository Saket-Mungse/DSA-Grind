import java.util.ArrayList;
import java.util.List;

class Solution {
    public ArrayList<Integer> findSubarray(int nums[]) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        long sum = 0;
        ArrayList<Integer> currList = new ArrayList<>();
        ArrayList<Integer> maxList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                currList.clear();
                sum = 0;
            } else {
                sum += nums[i];
                currList.add(nums[i]);
    
                if(sum > max || (sum == max && currList.size() > maxList.size())) {
                    max = sum;
                    maxList = new ArrayList<>(currList);
                } 
            }
        }
        return maxList.isEmpty() ? new ArrayList<>(List.of(-1)) : maxList;
    }
}