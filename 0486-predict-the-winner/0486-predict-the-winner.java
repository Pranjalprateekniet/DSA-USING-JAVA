class Solution {
    public boolean predictTheWinner(int[] arr) {
        int n=arr.length;
        if((n&1)==0)
            return true;
        int[][] dp=new int [n][n];
        for(int rows[]: dp){
            Arrays.fill(rows,-1);

        }
        return maxdiff(0,n-1,arr,dp)>=0;
    }
    private int maxdiff(int i,int j,int[] arr,int [][]dp){
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(i==j)
            return dp[i][j]=arr[i];
        dp[i][j]=Math.max(arr[i]-maxdiff(i+1,j,arr,dp),arr[j]-maxdiff(i,j-1,arr,dp));
        return dp[i][j];
    }
}