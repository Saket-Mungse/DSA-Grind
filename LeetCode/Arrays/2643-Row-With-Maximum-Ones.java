class Solution {
    public int[] rowAndMaximumOnes(int[][] arr) {
        int n = arr.length;
        int max = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int num : arr[i]){
                sum+=num;
            }
            if(max<sum){
                max = sum;
                ans = i;
            }
        }
        return new int[]{ans,max};   
    }
}