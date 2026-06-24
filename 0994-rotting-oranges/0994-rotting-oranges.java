class Solution {
    private int[] delrow={-1,0,1,0};
    private int[] delcol={0,1,0,-1};
    private boolean isValid(int i,int j,int n,int m){
        if(i<0 || i>=n)
            return false;
        if(j<0 || j>=m)
            return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        int time =0;
        int total=0;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    total++;
                }
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int k=q.size();
            count+=k;
            while(k-->0){
                int[] cell=q.poll();
                int row=cell[0];
                int col=cell[1];
                for(int i=0;i<4;i++){
                    int newrow=row+delrow[i];
                    int newcol=col+delcol[i];
                    if(isValid(newrow,newcol,n,m)&& grid[newrow][newcol]==1){
                        grid[newrow][newcol]=2;
                        q.add(new int[]{newrow,newcol});
                    }
                }
            }
            if(!q.isEmpty()){
                time++;
            }
        }
        if(total==count)
            return time;
        return -1;
    }
}