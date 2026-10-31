class Solution {
        int dp[][][];
        long mod=(int)1e9+7;
        int help(int grid[][],int r,int c,int d){
            int n=grid.length;
            int m=grid[0].length;
            if(r==n-1 && c==m-1)
                return 1;
            if(r>=n || c>=m)
                return 0;
            if(dp[r][c][d]!=-1)
                return dp[r][c][d];
            if(grid[r][c]==1){
                if(d==0)
                    return dp[r][c][d]=help(grid,r+1,c,1);
                else
                    return dp[r][c][d]=help(grid,r,c+1,0);
            
            }
            return dp[r][c][d]=(int)((help(grid,r+1,c,1)+help(grid,r,c+1,0))%mod);
            
        }
    public int uniquePaths(int[][] grid) {
        dp=new int[grid.length][grid[0].length][2];
        for(int[][] rows : dp)
        {
            for(int[] k :rows)
                Arrays.fill(k,-1);

        }
        return help(grid,0,0,0);
    }
}