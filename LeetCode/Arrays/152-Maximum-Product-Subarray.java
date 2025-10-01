// Problem: Maximum Product Subarray
// LeetCode Link: https://leetcode.com/problems/maximum-product-subarray/
// Difficulty: Medium
// Topic: Arrays, Dynamic Programming (Implicit)
//
// Approach:
// This is the optimal two-pass solution. We calculate the product from the start (prefix) and 
// from the end (suffix) simultaneously. This ensures that the maximum product, even if it 
// contains an even or odd number of negative signs, is captured.
// - The prefix product captures subarrays that start at the beginning.
// - The suffix product captures subarrays that end at the end.
// - If either product encounters a '0', it's reset to '1' because '0' breaks the continuity of the product.
// - This single loop correctly finds the maximum product in O(n) time.
//
// Time Complexity: O(n)
// We iterate through the array once.
//
// Space Complexity: O(1)
// We use a constant amount of extra space for variables (prefix, suffix, ans).

class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        // Initialize 'ans' to the smallest possible value to correctly handle negative numbers
        int ans = Integer.MIN_VALUE; 
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            // Reset prefix/suffix product if it becomes 0 (as 0 breaks product continuity)
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            
            // Calculate prefix product from the start
            prefix *= nums[i];
            
            // Calculate suffix product from the end (nums[n-i-1] is the element at reverse index i)
            suffix *= nums[n-i-1];
            
            // Update the maximum answer
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }
}