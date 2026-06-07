class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int left = 1;
        int right = stalls[n-1] - stalls[0];
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(canWePlace(mid,stalls,k)){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
    
    private boolean canWePlace(int distance, int[] stalls, int cows){
        int currCowsPlaced = 1;
        int lastPlaced = stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastPlaced>=distance){
                currCowsPlaced++;
                lastPlaced = stalls[i];
            }
            if(currCowsPlaced>=cows){
                return true;
            }
        }

        return false;
    }
}