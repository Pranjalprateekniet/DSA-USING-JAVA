class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(m-1,n-1,dp,grid);
    }
    private int func(int i,int j,int [][]dp,int[][] grid){
        if(i==0 && j==0){
        if(grid[0][0]==1)
            return 0;
            return 1;
        
        }
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(grid[i][j]==1)
            return dp[i][j]=0;
        int up=func(i-1,j,dp,grid);
        int left=func(i,j-1,dp,grid);
        dp[i][j]=left+up;
        return dp[i][j];
    }

}