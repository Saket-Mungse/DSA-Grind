class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int currSum = 0;
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            currSum += nums[i];
            list.add(nums[i]);
            if(currSum==k){
                max = Math.max(list.size(),max);
            }
            if(map.containsKey(currSum-k)){
                max = Math.max(list.size()-map.get(currSum-k),max);
            }
            if(!map.containsKey(currSum)){
                map.put(currSum,i+1);   
            }
        }
        return max;
    }
}