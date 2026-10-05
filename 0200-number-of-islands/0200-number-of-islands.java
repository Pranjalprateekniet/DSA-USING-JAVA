class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    c++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return c;
    }
    private boolean isvalid(int i,int j,int n,int m){
        if(i<0 || j<0 ||i>=n || j>=m)
            return false;
        return true;
    }
    private void dfs(int row,int col,char grid[][],boolean[][] vis){
        vis[row][col]=true;
        int n=grid.length;
        int m=grid[0].length;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(isvalid(newrow,newcol,n,m) && grid[newrow][newcol]=='1' && !vis[newrow][newcol])
                dfs(newrow,newcol,grid,vis);
        }
    }
}