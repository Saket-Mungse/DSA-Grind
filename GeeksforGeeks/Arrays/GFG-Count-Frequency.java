class Solution {
    int countFreq(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ans = -1;
        
        // Find rightmost occurrence
        while(right >= left) {
            int mid = left + (right - left) / 2;
            if(target < nums[mid]) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }

        if(ans == -1 || nums[ans] != target) {
            return 0;
        }
        
        // Find leftmost occurrence
        int i = ans;
        while(i > -1 && nums[i] == nums[ans]) {
            i--;
        }
        return ans - i;
    }
}