import java.util.ArrayList;

class Solution {
    static ArrayList<Integer> leaders(int nums[]) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        
        // Traverse from right to left
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] >= max) {
                list.addFirst(nums[i]);
                max = nums[i];
            }
        }
        return list;
    }
}