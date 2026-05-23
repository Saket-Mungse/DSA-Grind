class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int ap = 0; // Pointer for positive numbers
        int an = 1; // Pointer for negative numbers
        for(int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                ans[an] = nums[i];
                an += 2;
            } else {
                ans[ap] = nums[i];
                ap += 2;
            }
        }
        return ans;
    }
}