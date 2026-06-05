class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max =  Integer.MIN_VALUE;
        int sum = 0;
        for(int num : weights){
            max = Math.max(max,num);
            sum += num;
        }

        int left = max;
        int right = sum;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int totalDaysToLoadWholeWeights = calculateDays(mid,weights);
            if(totalDaysToLoadWholeWeights<=days){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    private int calculateDays(int capacity, int[] weights){
        int totalDays = 0;
        int currCapacity = 0;
        for(int i=0;i<weights.length;i++){
            if(currCapacity+weights[i]>capacity){
                currCapacity = weights[i];
                totalDays++;
            }else{
                currCapacity += weights[i];
            }
        }
        return ++totalDays;
    }
}