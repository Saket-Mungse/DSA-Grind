// Problem: Find First and Last Position of Element in Sorted Array
// LeetCode Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Difficulty: Medium
// Topic: Arrays, Binary Search
//
// Approach:
// This is the optimal O(log n) solution which uses two separate binary search calls:
// 1. findFirstIndex: Finds the leftmost occurrence of the target. It adjusts the high pointer 
//    when target is found to keep searching on the left side.
// 2. findLastIndex: Finds the rightmost occurrence of the target. It adjusts the low pointer 
//    when target is found to keep searching on the right side.
// The overall time complexity remains O(log n).
//
// Time Complexity: O(log n)
// The array is searched twice, but each search takes only O(log n) time.
//
// Space Complexity: O(1)
// We use only a few pointers and variables.

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);

        // If the target is not found at all, we can return immediately.
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findBound(nums, target, false);

        return new int[]{first, last};
    }

    // Helper method to find either the first (left) or last (right) boundary
    private int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (isFirst) {
                    // Try to find an even earlier occurrence on the left
                    high = mid - 1;
                } else {
                    // Try to find a later occurrence on the right
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}