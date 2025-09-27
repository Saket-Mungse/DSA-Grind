// Problem: Majority Element II
// LeetCode Link: https://leetcode.com/problems/majority-element-ii/
// Difficulty: Medium
// Topic: Arrays, Sorting
//
// Approach:
// This solution leverages sorting to group identical elements together. After sorting, 
// a single pass is performed to count the occurrences of each unique element. 
// If an element's count exceeds n/3 (where n is the array length), it is added to the result list. 
// A final check after the loop ensures the last element's count is also considered.
//
// Time Complexity: O(n log n)
// This is dominated by the time complexity of the sorting algorithm (Arrays.sort in Java).
// The single pass afterward takes O(n).
//
// Space Complexity: O(1) (Excluding the output list)
// The space used is minimal, primarily for the 'list' and local variables.

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Handle edge case of empty array
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int prev = nums[0];
        // Calculate the threshold: elements must appear > n/3 times
        int n = nums.length / 3;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                count++;
            } else {
                // Check if the previous element met the majority threshold
                if (count > n) {
                    list.add(prev);
                }
                // Reset count for the new element
                count = 1;
                prev = nums[i]; // Update the previous element
            }
        }
        
        // Final check for the last element in the array
        if (count > n) {
            list.add(prev);
        }
        
        return list;
    }
}