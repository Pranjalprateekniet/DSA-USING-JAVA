class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=arr[i];
        if(target>sum || target<(-sum))
            return 0;
        if((sum+target)%2!=0)
            return 0;
        int k=(sum+target)/2;
        long dp[][]=new long[n+1][k+1];
        dp[n][0]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=k;j++){
                if(arr[i]>j)
                    dp[i][j]=dp[i+1][j];
                else{
                    long c1=dp[i+1][j-arr[i]];
                    long c2=dp[i+1][j];
                    dp[i][j]=(c1+c2)% 1000000007;
                }
            }

        }
        return (int)dp[0][k];

    }
}