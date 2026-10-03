class Solution {
    private static boolean isvalid(int i,int j,int n,int m){
        if(i<0 || j<0 ||i>=n || j>=m)
            return false;
        return true;
    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        int n=grid.length;
        int m=grid[0].length;
        int ini=grid[sr][sc];
        int ans[][]=grid;
        dfs(sr,sc,grid,ans,newColor,ini);
        return ans;
    }
    private static void dfs(int row,int col,int grid[][],int[][] ans,int nc,int ini){
        ans[row][col]=nc;
        int n=grid.length;
        int m=grid[0].length;
        ans[row][col]=nc;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(isvalid(newrow,newcol,n,m) && grid[newrow][newcol]==ini && ans[newrow][newcol]!=nc)
                dfs(newrow,newcol,grid,ans,nc,ini);
        }
    }
}