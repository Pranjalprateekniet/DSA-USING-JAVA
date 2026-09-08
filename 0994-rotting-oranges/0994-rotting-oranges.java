class Solution {
    private boolean isvalid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int total=0;
        int time=0;
        int c=0;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0)
                    total++;
                if(grid[i][j]==2){
                    vis[i][j]=2;
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int k=q.size();
            c+=k;
            while(k-->0){
                int cell[]=q.poll();
                int row=cell[0];
                int col=cell[1];
                int delrow[]={-1,0,1,0};
                int delcol[]={0,1,0,-1};
                for(int i=0;i<4;i++){
                    int newrow=row+delrow[i];
                    int newcol=col+delcol[i];
                    if(isvalid(newrow,newcol,n,m) && (grid[newrow][newcol]==1) && vis[newrow][newcol]==0){
                        vis[newrow][newcol]=2;
                        q.add(new int[]{newrow,newcol});
                    }
                }
            }
            if(!q.isEmpty())
                time++;
        }
        if(total==c)
            return time;
        return -1;

    }
}