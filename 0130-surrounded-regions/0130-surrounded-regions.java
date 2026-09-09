class Solution {
    public void solve(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(!vis[i][0] && grid[i][0]=='O')
                dfs(i,0,grid,vis,n,m);
            if((!vis[i][m-1] )&& grid[i][m-1]=='O')
                dfs(i,m-1,grid,vis,n,m);
        }
        for(int j=0;j<m;j++){
            if(!vis[0][j] && grid[0][j]=='O')
                dfs(0,j,grid,vis,n,m);
            if(!vis[n-1][j] && grid[n-1][j]=='O')
                dfs(n-1,j,grid,vis,n,m);
            
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='O' && !vis[i][j])
                    grid[i][j]='X';
            }
        }
    }
    private boolean isvalid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;

    }
    private void dfs(int row,int col,char grid[][],boolean[][] vis,int n,int m){
        vis[row][col]=true;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(isvalid(newrow,newcol,n,m) && grid[newrow][newcol]=='O' && !vis[newrow][newcol])
                dfs(newrow,newcol,grid,vis,n,m);
        }
    }
}