// Problem: Rearrange Array Elements by Sign
// LeetCode Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/
// Difficulty: Medium
// Topic: Arrays
//
// Approach:
// This solution uses two pointers, one for positive numbers (p) and one for negative numbers (n), to fill a new result array. We iterate through the original array, and based on the sign of the number at the current index, we place it in the next available positive or negative slot in the new array.
//
// Time Complexity: O(n)
// We iterate through the array once to build the new result array.
//
// Space Complexity: O(n)
// We use a new array of the same size to store the result.


class Solution {
    public int[] rearrangeArray(int[] nums) {
        int  N = nums.length;
        int p = 0;
        int n = 0;
        if(nums[0]<0){
            p = 1;
        }else{
            n = 1;
        }
        int[] ans = new int[N];
        int currState = 0;
        while(p!=n && currState<N){
            while(p < N && nums[p] < 0){
                p++;
            }
            while(n < N && nums[n] >= 0){
                n++;
            }
            ans[currState++] = nums[p++];
            ans[currState++] = nums[n++];
        }
        return ans;
    }
}