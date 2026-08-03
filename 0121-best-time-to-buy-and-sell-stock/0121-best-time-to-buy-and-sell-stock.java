class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
       int[][] dp=new int[n+1][3];
       for(int i=n-1;i>=0;i--){
        for(int k=1;k<=2;k++){
            
                if (k == 2) {
                    int buy = -arr[i] + dp[i + 1][k - 1];
                    int skip = dp[i + 1][k];

                    dp[i][k] = Math.max(buy, skip);
                } else {
                    int sell = arr[i] + dp[i + 1][k - 1];
                    int skip = dp[i + 1][k];

                    dp[i][k] = Math.max(sell, skip);
                }
        }
       }
       return dp[0][2];
    }
}