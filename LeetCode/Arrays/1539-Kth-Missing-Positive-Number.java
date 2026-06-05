class Solution {
    public int findKthPositive(int[] vec, int k) {
        int low = 0, high = vec.length - 1;

        // Binary search to find the position where the kth missing number lies
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Number of missing elements before index mid:
            // Expected value at index mid is (mid + 1). 
            // The count of missing numbers is: vec[mid] - (mid + 1)
            int missing = vec[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // After the loop, 'high' is the index such that 
        // the kth missing number is between vec[high] and vec[high + 1].
        // Result formula: vec[high] + k - missing_at_high
        // Substituting missing_at_high: k + high + 1
        return k + high + 1;
    }
}