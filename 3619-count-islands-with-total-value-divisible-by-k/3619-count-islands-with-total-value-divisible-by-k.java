class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    long s=dfs(grid,i,j);
                    if(s%k==0)
                        ans++;
                }
            }
        }
        return ans;
    }
    private static boolean isvalid(int i,int j,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n)
            return false;
        return true;
    }
    private static long dfs(int[][] grid,int i,int j){
        int m=grid.length;
        int n=grid[0].length;
        if(!isvalid(i,j,m,n) || grid[i][j]==0)
            return 0;
        long sum=grid[i][j];
        grid[i][j]=0;
        sum+=dfs(grid,i+1,j);
        sum+=dfs(grid,i-1,j);
        sum+=dfs(grid,i,j+1);
        sum+=dfs(grid,i,j-1);
        return sum;
    }
}