class Solution {
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        if(sum%2!=0)
            return false;
        int k=sum/2;
        boolean dp[][]=new boolean[n+1][k+1];
        dp[n][0]=true;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=k;j++){
                if(arr[i]>j)
                    dp[i][j]=dp[i+1][j];
                else{
                    boolean c1=dp[i+1][j-arr[i]];
                    boolean c2=dp[i+1][j];
                    dp[i][j]=c1||c2;

                }
            }

        }
        return dp[0][k];

    }
}