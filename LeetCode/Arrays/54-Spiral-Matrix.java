// Problem: Spiral Matrix
// LeetCode Link: https://leetcode.com/problems/spiral-matrix/
// Difficulty: Medium
// Topic: Arrays, Matrix
//
// Approach:
// This solution uses four boundary pointers (top, bottom, left, right) to simulate the spiraling path. 
// It traverses the matrix in four distinct loops (Right, Down, Left, Up), shrinking the boundaries 
// after each full traversal. The check (top <= bottom && left <= right) ensures the loops don't 
// overlap or traverse already visited cells, which is essential for non-square matrices.
//
// Time Complexity: O(m*n)
// Every element in the matrix is visited exactly once.
//
// Space Complexity: O(1) (Excluding the output list)
// The solution uses a fixed amount of extra space for the boundary pointers and variables.

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // 1. Traverse Right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            
            // 2. Traverse Down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // 3. Traverse Left (Only if there are rows remaining)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // 4. Traverse Up (Only if there are columns remaining)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}