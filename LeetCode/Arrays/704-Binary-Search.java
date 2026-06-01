class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        while(right >= left) {
            // Using this formula to prevent potential integer overflow
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}