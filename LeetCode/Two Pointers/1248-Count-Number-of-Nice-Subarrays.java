class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int left = 0;
        int right = 0;
        int currCount = 0;
        while(right<n){
            if(nums[right]%2!=0){
                ++currCount; 
            }

            if(currCount<k){
                right++;
            }
            else if(currCount==k){
                count++;
                int temp = left;
                while(temp<right && nums[temp]%2==0){
                    temp++;
                    count++;
                }
                right++;
            }else{
                int dummyCount = 0;
                while(dummyCount!=currCount-k){
                    if(nums[left]%2!=0){
                        dummyCount++;
                    }
                    left++;
                }
                currCount-=dummyCount;
                int temp = left;
                while(nums[temp]%2==0){
                    count++;
                    temp++;
                }
                count++;
                right++;
            }
        }
        return count;
    }
}