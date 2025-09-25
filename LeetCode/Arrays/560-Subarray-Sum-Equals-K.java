// Problem: Subarray Sum Equals K
// LeetCode Link: https://leetcode.com/problems/subarray-sum-equals-k/
// Difficulty: Medium
// Topic: Arrays, Hash Map, Prefix Sum
//
// Approach:
// This problem is solved using the Prefix Sum concept combined with a HashMap. 
// We maintain a running sum ('sum'). For each element, we check if the difference 
// (sum - k) exists in the HashMap. If it does, it means the subarray sum between 
// the index corresponding to (sum - k) and the current index is equal to k. 
// The HashMap stores {prefix_sum: count_of_occurrences}.
//
// Time Complexity: O(n)
// We iterate through the array once. HashMap operations (put and get) take O(1) time on average.
//
// Space Complexity: O(n)
// In the worst case, the HashMap stores up to n distinct prefix sums.

class Solution {
    public int subarraySum(int[] nums, int k) {
        // ... (Your code here)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}