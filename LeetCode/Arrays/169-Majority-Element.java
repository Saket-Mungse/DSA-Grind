class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int elem = nums[0];
        int count = 1;
        for(int i=1;i<n;i++){
            if(count==0){
                elem = nums[i];
                count = 1;
                continue;
            }
            if(nums[i]==elem){
                count++;
            }else{
                count--;
            }
        }
        return elem;
    }
}