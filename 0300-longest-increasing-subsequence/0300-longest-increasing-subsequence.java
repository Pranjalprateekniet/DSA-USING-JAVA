class Solution {
    private int func(int arr[],int i,int n,int prev,int [][] dp){
        if(i==n)
            return 0;
        if(dp[i][prev+1]!=-1)
            return dp[i][prev+1];
        if(prev==-1 || arr[i]>arr[prev])
        {
            int c1=1+func(arr,i+1,n,i,dp);
            int c2=func(arr,i+1,n,prev,dp);
            dp[i][prev+1]=Math.max(c1,c2);
        }
        else{
            dp[i][prev+1]=func(arr,i+1,n,prev,dp);
        }
        return dp[i][prev+1];
    }
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int i=0;
        int prev=-1;
        int dp[][]=new int[n+1][n+1];
        for(int rows[]: dp)
            Arrays.fill(rows,-1);
        return func(arr,i,n,prev,dp);
    }
}