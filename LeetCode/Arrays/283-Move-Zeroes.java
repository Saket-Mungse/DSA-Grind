class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        if(nums[i]!=0){
            while(i<n && nums[i]!=0){
                i++;
            }
        }
        for(int j=i+1;j<n;j++){
            if(nums[j]!=0){
                nums[i] = nums[j];
                nums[j] = 0;
            }
            while(i<=j && nums[i]!=0){
                i++;
            }
        }
    }
}