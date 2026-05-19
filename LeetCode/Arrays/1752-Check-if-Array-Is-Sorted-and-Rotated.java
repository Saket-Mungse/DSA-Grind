class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean rotate = false;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i]){
                if(rotate){
                    return false;
                }else{
                    rotateArray(nums,i,n);
                    boolean check = sortedAfterRotate(nums,i);
                    if(!check){
                        return false;
                    }
                    rotate = true;
                }
            }
        }
        return true;
    }

    private void rotateArray(int[] nums, int rotateTimes, int n){
        if(rotateTimes==0){
            return;
        }

        int temp = nums[0];
        for(int i=1;i<n;i++){
            nums[i-1] = nums[i];
        }
        nums[n-1] = temp;
        rotateArray(nums,rotateTimes-1,n);
    }

    private boolean sortedAfterRotate(int[] nums, int end){
        for(int i=1;i<=end;i++){
            if(nums[i]<nums[i-1]){
                return false;
            }
        }
        return true;
    }
}