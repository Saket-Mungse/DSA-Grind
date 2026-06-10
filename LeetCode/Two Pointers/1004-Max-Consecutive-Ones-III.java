class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int max = 0;
        int count = 0;
        while(right<n){
            if(nums[right]==0){
                if(count<k){
                    count++;
                }else{
                    max = Math.max(max,right-left);
                    while(nums[left]!=0){
                        left++;
                    }
                    left++;
                }
            }
            right++;
        }
        max = Math.max(max,right-left);
        return max;
    }
}