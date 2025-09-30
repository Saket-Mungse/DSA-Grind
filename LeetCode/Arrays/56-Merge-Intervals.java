// Problem: Merge Intervals
// LeetCode Link: https://leetcode.com/problems/merge-intervals/
// Difficulty: Medium
// Topic: Arrays, Sorting, Intervals
//
// Approach:
// The key to solving this is to first sort the intervals based on their start times. 
// After sorting, we iterate through the intervals, maintaining a 'current' merged interval. 
// If the current interval overlaps with the next interval (i.e., current_end >= next_start), 
// we merge them by updating the current_end to the maximum of the two ends. 
// If there is no overlap (current_end < next_start), we finalize the current merged interval 
// and start a new one with the next interval.
//
// Time Complexity: O(n log n)
// This is dominated by the initial sorting step. The subsequent single pass takes O(n).
//
// Space Complexity: O(n)
// We use a new ArrayList to store the merged intervals, which in the worst case (no merges) 
// will store all 'n' intervals.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        if (intervals.length == 1) return intervals;

        // Sort intervals by the start time (a[0])
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int start2 = curr[0];
            int end2 = curr[1];

            // Check for NO overlap (Case 1: [a,b] [c,d] where b < c)
            if (end1 < start2) {
                // Finalize the current merged interval
                list.add(new ArrayList<>(Arrays.asList(start1, end1)));
                // Start a new interval
                start1 = start2;
                end1 = end2;
            } 
            // Check for overlap (Case 2: [a,c] [b,d] OR [a,d] [b,c], etc.)
            else {
                // Merge by extending the end time
                // The start time is already correct because of the initial sort
                start1 = Math.min(start1,start2);
                end1 = Math.max(end1, end2);
            }
        }

        // Add the last merged interval to the result list
        list.add(new ArrayList<>(Arrays.asList(start1, end1)));

        // Convert the ArrayList of Lists back into a 2D array
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;
    }
}