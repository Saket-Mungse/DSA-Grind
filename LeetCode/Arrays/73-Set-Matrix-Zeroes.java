// Problem: Set Matrix Zeroes
// LeetCode Link: https://leetcode.com/problems/set-matrix-zeroes/
// Difficulty: Medium
// Topic: Arrays, Matrix
//
// Approach:
// This solution first iterates through the matrix to find all cells that contain a zero. The coordinates of these zero cells are stored in a list of Pair objects. Then, a second loop iterates through this list. For each stored coordinate, it calls a helper function to set the corresponding row and column in the matrix to zero.
//
// Time Complexity: O(m*n)
// The first loop to find zeros takes O(m*n). The second loop to set zeros takes O(k * (m + n)), where k is the number of zeros. In the worst case, this is roughly O(m*n + k*m + k*n). A tighter analysis is that it's O(m*n), since the outer loops are bounded.
//
// Space Complexity: O(k)
// We use a list to store the coordinates of the zero cells. In the worst-case scenario (all cells are zero), this list would store m*n pairs, leading to O(m*n) space.


class Pair{
    int row;
    int column;
    Pair(int row, int column){
        this.row = row;
        this.column = column;
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    list.add(new Pair(i,j));
                }
            }
        }

        for(int i=0;i<list.size();i++){
            int currRow = list.get(i).row;
            int currColumn = list.get(i).column;
            output(matrix,currRow,currColumn);
        }
    }

    private void output(int[][] matrix,int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
        if(j>0){
            int count = j-1;
            while(count>=0){
                matrix[i][count] = 0;
                count--;
            }   
        }
        if(i-1>=0){
            int count = i-1;
            while(count>=0){
                matrix[count][j] = 0;
                count--;
            }
        }
        if(j+1<n){
            int count = j+1;
            while(count<n){
                matrix[i][count] = 0;
                count++;
            }
        }
        if(i+1<m){
            int count = i+1;
            while(count<m){
                matrix[count][j] = 0;
                count++;
            }
        }
    }
}