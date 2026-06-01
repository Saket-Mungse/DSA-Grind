class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int ans = -1;
        while(right>=left){
            int mid = left + (right-left)/2;
            if(target<nums[mid]){
                right = mid-1;
            }else{
                ans = mid;
                left = mid+1;
            }
        }

        if(ans==-1){
            return new int[]{-1,-1};
        }
        if(nums[ans]!=target){
            return new int[]{-1,-1};
        }
        int i = ans;
        while(i>-1 && nums[i]==nums[ans]){
            i--;
        }
        return new int[]{i+1,ans};
    }
}