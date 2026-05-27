import java.util.HashMap;

class Solution {
    int maxLength(int nums[]) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            currSum += nums[i];
            
            if(currSum == 0) {
                max = i + 1;
            } else if(map.containsKey(currSum)) {
                max = Math.max(max, i - map.get(currSum));
            } else {
                map.put(currSum, i);
            }
        }
        return max;
    }
}