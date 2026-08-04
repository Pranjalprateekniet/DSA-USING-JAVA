class Solution {
    public int rob(int[] arr) {
        int k=1;
        int n=arr.length;
        int dp[][]=new int[n][2];
        for(int rows[]:dp)
            Arrays.fill(rows,-1);
        int gain=func(arr,n,0,k,dp);
        return gain;
    }
    private static int func(int arr[],int n,int i,int k,int dp[][]){
        if(i==n)
            return 0;
        if(k==0)
            return func(arr,n,i+1,1,dp);
        if(dp[i][k]!=-1)
            return dp[i][k];
        int c1=arr[i]+func(arr,n,i+1,0,dp);
        int c2=func(arr,n,i+1,1,dp);
        dp[i][k]=Math.max(c1,c2);
        return dp[i][k];

    }
}