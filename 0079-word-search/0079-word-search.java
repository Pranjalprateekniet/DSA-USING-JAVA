class Solution {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    private boolean dfs(char[][]grid,String word,boolean[][] vis,int row,int col,int index){
        int n=grid.length;
        int m=grid[0].length;
        if(!isvalid(row,col,n,m))
            return false;
        if(vis[row][col])
            return false;
        if(grid[row][col]!=word.charAt(index))
            return false;
        if(index==word.length()-1)
            return true;
        vis[row][col]=true;
        for(int k=0;k<4;k++){
            int nrow=delRow[k]+row;
            int ncol=delCol[k]+col;
            if(dfs(grid,word,vis,nrow,ncol,index+1)){
                vis[row][col]=false;
                return true;
            }
        }
        
        vis[row][col]=false;
        return false;
    }

    private boolean isvalid(int i,int j,int n,int m){
        if(i<0 || i>=n ||j<0 ||j>=m)
            return false;
        return true;
    }

    public boolean exist(char[][] grid, String word) {
        //your code goes here
        int n=grid.length;
        int m=grid[0].length;
        boolean [][]vis=new boolean[n][m];
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(dfs(grid,word,vis,row,col,0))
                    return true;
                else
                    continue;
            }
        }
        return false;
    }
}