class Solution {
    public int nthRoot(int n, int m) {
        int left = 1;
        int right = m;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long curr = (long)Math.pow(mid, n);
            
            if(curr == m) {
                return mid;
            } else if(m < curr) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}