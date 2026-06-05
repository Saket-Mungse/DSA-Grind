class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = -1;
        for(int i=0;i<n;i++){
            max = Math.max(max,piles[i]);
        }

        int left = 1;
        int right = max;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int totalHoursToEatAll = canEatAll(mid,piles);
            if(totalHoursToEatAll<=h){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    private int canEatAll(int perHour, int[] piles){
        int total = 0;
        for(int i=0;i<piles.length;i++){
            total += Math.ceil((double)piles[i]/(double)perHour);
        }
        return total;
    }
}