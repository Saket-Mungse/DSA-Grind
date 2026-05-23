class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = -1;
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(prices[i] < min) {
                if(max > 0) {
                    maxProfit = Math.max(maxProfit, max - min);
                }
                min = prices[i];
                max = -1;
            } else {
                if(prices[i] > max) {
                    max = prices[i];
                }
            }
        }
        if(max - min > 0 && max - min > maxProfit) {
            maxProfit = max - min;
        }

        return maxProfit > 0 ? maxProfit : 0;
    }
}