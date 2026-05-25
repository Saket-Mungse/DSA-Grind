class Solution {
    public void rotate(int[][] nums) {
        int n = nums.length;
        // Layer-by-layer rotation
        for(int i = 0; i < n / 2; i++) {
            for(int j = i; j < n - i - 1; j++) {
                goAndPlace(nums[i][j], i, j, 0, nums, n);
            }
        }
    }

    private void goAndPlace(int stored, int i, int j, int count, int[][] nums, int n) {
        if(count == 4) {
            return;
        }
        int swapWithIndex = n - i - 1;
        int toBeStored = nums[j][swapWithIndex];
        nums[j][swapWithIndex] = stored;
        goAndPlace(toBeStored, j, swapWithIndex, ++count, nums, n);
    }
}