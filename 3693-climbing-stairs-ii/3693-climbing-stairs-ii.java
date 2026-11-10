class Solution {
    public int climbStairs(int n, int[] arr) {
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int mincost=Integer.MAX_VALUE;
            for(int j=Math.max(0,i-3);j<i;j++){
                mincost=Math.min(mincost,dp[j]+(i-j)*(i-j)+arr[i-1]);
            }
            dp[i]=mincost;
        }
        return dp[n];

    }
}