// Problem: Rotate Image
// LeetCode Link: https://leetcode.com/problems/rotate-image/
// Difficulty: Medium
// Topic: Arrays, Matrix
//
// Approach:
// This solution performs the rotation in-place by dividing the matrix into concentric layers (or rings). 
// It then iterates through the elements of the outermost layer, performing a four-way swap to rotate the 
// elements in a cycle (Top -> Right -> Bottom -> Left -> Top). The process is repeated for inner layers 
// until the entire matrix is rotated.
//
// Time Complexity: O(n^2)
// Every element in the matrix is accessed and moved exactly once.
//
// Space Complexity: O(1)
// The rotation is performed in-place without using any extra data structures proportional to the input size.

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // Save Top

                // Left -> Top
                matrix[first][i] = matrix[last - offset][first];

                // Bottom -> Left
                matrix[last - offset][first] = matrix[last][last - offset];

                // Right -> Bottom
                matrix[last][last - offset] = matrix[i][last];

                // Top -> Right
                matrix[i][last] = top;
            }
        }
    }
}