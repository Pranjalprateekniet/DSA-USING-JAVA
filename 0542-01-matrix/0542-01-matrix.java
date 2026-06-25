class Solution {
   private boolean isValid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }
    int[] delrow={-1,0,1,0};
    int[] delcol={0,1,0,-1};

    public int[][] updateMatrix(int[][] grid) {
        int n=grid.length;
       int m=grid[0].length;
       int dis[][] = new int[n][m];
       boolean vis[][] = new boolean[n][m];
       Queue<int[]>q=new LinkedList<>();
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==0){
                q.add(new int[]{i,j});
                dis[i][j]=0;
                vis[i][j]=true;
            }
        }
       }
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int row=cell[0];
            int col=cell[1];
            for(int i=0;i<4;i++)
            {
                int newrow=row+delrow[i];
                int newcol=col+delcol[i];
                if(isValid(newrow,newcol,n,m)&& !vis[newrow][newcol]){
                    vis[newrow][newcol]=true;
                    dis[newrow][newcol]=dis[row][col]+1;
                    q.add(new int[]{newrow,newcol});
                }
            }
        }
        return dis;
    }
}