class Solution {
    private boolean isValid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }
    private void bfs(int i,int j,int n,int m,char[][] grid,boolean[][] vis){
        vis[i][j]=true;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int cell[]=q.poll();
            int row=cell[0];
            int col=cell[1];
            int delrow[]={-1,0,1,0};
            int delcol[]={0,1,0,-1};
            for(int k=0;k<4;k++){
                int newrow=row+delrow[k];
                int newcol=col+delcol[k];
                if(isValid(newrow,newcol,n,m) && grid[newrow][newcol]=='1' && !vis[newrow][newcol]){
                    bfs(newrow,newcol,n,m,grid,vis);
                } 
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    c++;
                    bfs(i,j,n,m,grid,vis);
                }
            }
        }
        return c;
    }
}