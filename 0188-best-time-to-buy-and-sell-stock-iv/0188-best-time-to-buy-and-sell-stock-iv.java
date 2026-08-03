class Solution {
    private int func(int arr[],int n,int i,int k,int [][] dp){
        if(i==n)
            return 0;
        if(k==0)
            return 0;
        if(dp[i][k]!=-1)
            return dp[i][k];
        if(k%2==0)
        {
            int c1=func(arr,n,i+1,k-1,dp)-arr[i];
            int c2=func(arr,n,i+1,k,dp);
            dp[i][k]=Math.max(c1,c2);
            return dp[i][k];
        }
        else{
            int c1=func(arr,n,i+1,k-1,dp)+arr[i];
            int c2=func(arr,n,i+1,k,dp);
            dp[i][k]=Math.max(c1,c2);
            return dp[i][k];
        }

    }
    public int maxProfit(int k, int[] arr) {
        int n=arr.length;
        k=k*2;
       int dp[][]=new int[n][k+1];
       for(int rows[]:dp)
        Arrays.fill(rows,-1);
       int gain=func(arr,n,0,k,dp);
       return gain;
    }
}