class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        while(right >= left) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // When target is not found, 'left' points to the correct insertion index
        return left;
    }
}