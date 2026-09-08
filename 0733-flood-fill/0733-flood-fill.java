class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ini=image[sr][sc];
        int ans[][]=image;
        dfs(image,sr,sc,color,ans,ini);
        return ans;

    }
    private boolean isvalid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;

    }
    private void dfs(int[][] image,int row,int col,int newcolor,int [][] ans,int ini){
        int n=image.length;
        int m=image[0].length;
        ans[row][col]=newcolor;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(isvalid(newrow,newcol,n,m) && image[newrow][newcol]==ini && ans[newrow][newcol]!=newcolor)
                dfs(image,newrow,newcol,newcolor,ans,ini);
        }
    }
}