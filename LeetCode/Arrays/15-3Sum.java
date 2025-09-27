// Problem: 3Sum
// LeetCode Link: https://leetcode.com/problems/3sum/
// Difficulty: Medium
// Topic: Arrays, Two Pointers, Sorting
//
// Approach:
// 1. Sort the array: This allows us to use the Two Pointers technique and easily skip duplicates.
// 2. Iterate through the array (fixing 'a'): In the outer loop, fix the first number (nums[i]).
// 3. Use Two Pointers (l and r): Set 'l' to i + 1 and 'r' to the end of the array.
// 4. Find the remaining sum: The target for the two pointers is 'target = -nums[i]'.
// 5. Skip Duplicates: Crucially, after finding a triplet OR after moving the outer loop's 'i', 
//    skip any identical subsequent elements to avoid duplicate triplets in the result.
//
// Time Complexity: O(n^2)
// O(n log n) for sorting + O(n^2) for the nested loop (O(n) outer loop * O(n) inner two-pointer pass).
//
// Space Complexity: O(1) (or O(n) depending on sorting implementation)
// We use constant extra space for pointers, excluding the space required for the output list and sorting.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. Sort the array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Iterate through the array, fixing the first element (a)
        for (int i = 0; i < n; i++) {
            
            // Optimization: Skip duplicates for 'a' (the fixed element)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i]; // The sum of the remaining two elements must equal this target
            int left = i + 1;
            int right = n - 1;

            // Use Two Pointers on the remaining array
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum < target) {
                    left++; // Need a larger sum
                } else if (sum > target) {
                    right--; // Need a smaller sum
                } else {
                    // Triplet found! (nums[i] + nums[left] + nums[right] == 0)
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move pointers, but skip duplicates for 'b' and 'c'
                    left++;
                    right--;
                    
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}