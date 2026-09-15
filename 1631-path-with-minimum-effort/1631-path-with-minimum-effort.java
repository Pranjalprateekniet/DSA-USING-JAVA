class Solution {
    private boolean isvalid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }
    public int minimumEffortPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int maxdiff[][]=new int[n][m];
        
        for(int[] rows:maxdiff)
            Arrays.fill(rows,Integer.MAX_VALUE);
        maxdiff[0][0]=0;
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int cell[]=pq.poll();
            int diff=cell[0];
            int row=cell[1];
            int col=cell[2];
            if(row==n-1 && col==m-1)
                return diff;
            int delrow[]={-1,0,1,0};
            int delcol[]={0,1,0,-1};
            for(int i=0;i<4;i++){
                int newrow=row+delrow[i];
                int newcol=col+delcol[i];
                if(isvalid(newrow,newcol,n,m))
                {
                    int curr=Math.abs(grid[newrow][newcol]-grid[row][col]);
                    if(Math.max(curr,diff)<maxdiff[newrow][newcol]){
                        maxdiff[newrow][newcol]=Math.max(curr,diff);
                        pq.add(new int[]{maxdiff[newrow][newcol],newrow,newcol});
                    }
                }
            }
        }
        return -1;
    }
}