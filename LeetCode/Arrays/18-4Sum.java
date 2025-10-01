// Problem: 4Sum
// LeetCode Link: https://leetcode.com/problems/4sum/
// Difficulty: Medium
// Topic: Arrays, Two Pointers, Sorting
//
// Approach:
// This is the optimal solution achieved by extending the 3Sum algorithm.
// 1. Sort the array.
// 2. Use two nested outer loops to fix the first two numbers (nums[i] and nums[j]).
// 3. Use the Two Pointers technique on the remaining array (left = j + 1, right = n - 1) to find the remaining two numbers.
// 4. Crucially, duplicate elements are skipped in all three loops (i, j, and inside the two-pointer loop) to ensure a unique set of quadruplets in the result.
// 5. A 'long' type is used for the sum calculation to prevent potential integer overflow, as the sum of four integers can exceed Integer.MAX_VALUE.
//
// Time Complexity: O(n^3)
// O(n log n) for sorting + O(n^3) for the nested loops (O(n) outer * O(n) inner * O(n) two-pointer pass).
//
// Space Complexity: O(1) (or O(n) depending on sorting implementation)
// We use constant extra space for pointers and variables, excluding the space for the output list.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;

        // 1. Sort the array
        Arrays.sort(nums);

        // Outer loop (fixing the first number)
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first fixed number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Second loop (fixing the second number)
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second fixed number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                // Two Pointers on the remaining array
                while (left < right) {
                    // Use long to prevent integer overflow when calculating the sum
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        // Quadruplet found!
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Move pointers past duplicates
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return result;
    }
}