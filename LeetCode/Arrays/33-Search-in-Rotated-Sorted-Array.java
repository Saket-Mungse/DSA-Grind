class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left1, right1, left2, right2;
        
        // Split array into two sorted subarrays based on the rotation point
        if(nums[0] > nums[n-1]) {
            int start = 1;
            while(start < n && nums[start] > nums[start-1]) {
                start++;
            }
            left1 = 0;
            right1 = start - 1;
            left2 = start;
            right2 = n - 1;
        } else {
            left1 = 0;
            right1 = n - 1;
            left2 = 0;
            right2 = -1; // No second part
        }

        // Search in first part
        while(right1 >= left1) {
            int mid1 = left1 + (right1 - left1) / 2;
            if(nums[mid1] == target) return mid1;
            else if(target < nums[mid1]) right1 = mid1 - 1;
            else left1 = mid1 + 1;
        }

        // Search in second part
        while(right2 >= left2) {
            int mid2 = left2 + (right2 - left2) / 2;
            if(nums[mid2] == target) return mid2;
            else if(target < nums[mid2]) right2 = mid2 - 1;
            else left2 = mid2 + 1;
        }
        return -1;
    }
}