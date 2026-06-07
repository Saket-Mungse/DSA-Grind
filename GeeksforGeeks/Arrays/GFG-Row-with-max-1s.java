class Solution {
    public int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        int max = 0;
        int ans = -1;
        for(int i=0;i<n;i++){
            int left = 0;
            int right = arr[i].length-1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(arr[i][mid]==0){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            if(max<arr[i].length-left){
                max = arr[i].length-left;
                ans = i;
            }
        }
        return ans;       
    }
}