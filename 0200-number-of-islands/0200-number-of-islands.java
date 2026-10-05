class Solution {
    private boolean isvalid(int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m)
            return false;
        return true;
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int c=0;
        Queue<int[]> q=new LinkedList<>();
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                c++;
                q.add(new int[]{i,j});
                vis[i][j]=true;
                while(!q.isEmpty()){
                    int cell[]=q.poll();
                    int row=cell[0];
                    int col=cell[1];
                    for(int k=0;k<4;k++){
                        int newrow=row+delrow[k];
                        int newcol=col+delcol[k];
                        if(isvalid(newrow,newcol,n,m) && grid[newrow][newcol]=='1' && !vis[newrow][newcol]){
                            vis[newrow][newcol]=true;
                            q.add(new int[]{newrow,newcol});
                            }
                    }
                }
                }
            }
        }
        return c;
    }
}