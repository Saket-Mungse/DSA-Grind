class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = -1;
        for(int num : nums){
            max = Math.max(max,num);
        }
        int left = 1;
        int right = max;
        int ans = 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(divideAndCheckSumLessThanThreshold(mid,nums,threshold)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    private boolean divideAndCheckSumLessThanThreshold(int divisor, int[] nums, int threshold){
        int sum = 0;
        for(int num : nums){
            sum+= (num+divisor-1)/divisor;
        }
        return sum<=threshold;
    }
}