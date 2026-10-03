class Solution {
     private static boolean isvalid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1')
                {
                    c++;
                    dfs(i,j,grid,vis,n,m);
                }
            }
        }
        return c;
    }
    private static void dfs(int i,int j,char grid[][],boolean[][] vis,int n,int m){
        vis[i][j]=true;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int k=0;k<4;k++){
            int newrow=i+delrow[k];
            int newcol=j+delcol[k];
            if(isvalid(newrow,newcol,n, m) && !vis[newrow][newcol] && grid[newrow][newcol]=='1')
                dfs(newrow, newcol, grid, vis, n, m);
        }

    }
}