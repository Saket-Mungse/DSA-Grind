class Solution {
    public int findFloor(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ans = -1;
        
        while(right >= left) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) {
                return mid; // Target found, this is the floor
            } else if(target < nums[mid]) {
                // Potential floor must be on the left
                right = mid - 1;
            } else {
                // nums[mid] is a candidate for floor, 
                // but look for a larger candidate on the right
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
}