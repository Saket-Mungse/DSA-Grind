class Solution {
    public int totalFruit(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 1;
        }

        int left = 0;
        int right = 0;
        int max = 0;
        int basket1 = -1;
        int basket2 = -1;
        while(right<n){
            if(basket1==-1 || basket2==-1){
                if(basket1==-1){
                    basket1 = nums[right];
                }else{
                    if(basket1!=nums[right]){
                        basket2 = nums[right];
                    }
                }
                right++;
            }
            else if(nums[right]!=basket1 && nums[right]!=basket2){
                max = Math.max(max,right-left);
                int i = right-1;
                int stays = nums[i];
                while(i>=0 && nums[i]==stays){
                    i--;
                }
                left = i+1;
                basket1 = stays;
                basket2 = nums[right];
                right++;
            }else{
                right++;
            }
        }
        max = Math.max(max,right-left);
        return max;
    }
}