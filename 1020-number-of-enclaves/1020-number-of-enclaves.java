class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || i==n-1 || j==0 || j==m-1)&& (grid[i][j]==1))
                    dfs(i,j,vis,grid,n,m);
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j])
                    c++;
            }
        }
        return c;
    }
    private boolean isvalid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }
    private void dfs(int row,int col,boolean[][] vis,int grid[][],int n,int m){
        vis[row][col]=true;
        int delrow[]={0,1,0,-1};
        int delcol[]={-1,0,1,0};
        for(int i=0;i<4;i++){
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(isvalid(newrow,newcol,n,m) && grid[newrow][newcol]==1 && !vis[newrow][newcol]){
                dfs(newrow,newcol,vis,grid,n,m);
            }
        }
    }
}