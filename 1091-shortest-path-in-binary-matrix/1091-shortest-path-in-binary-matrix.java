class Solution {
    private boolean isvalid(int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m)
            return false;
        return true;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length; 
        if((grid[0][0]==1 )|| (grid[n-1][m-1]==1))
            return -1;
        if(n==1)
            return 1;
        int source[]={0,0};
        int dest[]={n-1,m-1};
        Queue<int[]>q=new LinkedList<>();
        int dist[][]=new int[n][m];
        for(int[] rows: dist){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        dist[0][0]=1;
        q.add(new int[]{1,0,0});
        while(!q.isEmpty()){
            int cell[]=q.poll();
            int dis=cell[0];
            int row=cell[1];
            int col=cell[2];
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int newrow=row+delrow;
                    int newcol=col+delcol;
                    if(isvalid(newrow,newcol,n,m) && grid[newrow][newcol]==0 && dis+1<dist[newrow][newcol]){
                        dist[newrow][newcol]=dis+1;
                        if(newrow==dest[0] && newcol==dest[1])
                            return dis+1;
                        q.add(new int[]{dis+1,newrow,newcol});
                    }
                }
            }
        }
        return -1;
    }
}