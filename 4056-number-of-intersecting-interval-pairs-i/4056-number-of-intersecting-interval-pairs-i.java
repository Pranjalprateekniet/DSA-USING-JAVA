class Solution {
    public int countIntersectingIntervals(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;  
        int c=0;
        for(int i=0;i<n;i++){
            int start1=grid[i][0];
            int end1=grid[i][1];
            for(int j=i+1;j<n;j++){
                int start2=grid[j][0];
                int end2=grid[j][1];
                if(start1<=end2 && start2<=end1)
                    c++;
            }
        }
        return c;
    }
}