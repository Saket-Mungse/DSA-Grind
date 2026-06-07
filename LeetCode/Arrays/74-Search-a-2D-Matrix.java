class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(target<=matrix[mid][m-1] && target>=matrix[mid][0]){
                return findOut(matrix[mid],target,m);
            }
            else if(target>matrix[mid][m-1]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }

    private boolean findOut(int[] arr, int target, int n){
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==target){
                return true;
            }
            else if(target<arr[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}