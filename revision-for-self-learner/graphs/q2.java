package graphs;

import java.util.*;

public class q2 {
    private static boolean isvalid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }
    private static void dfs(int i,int j,int grid[][],boolean[][] vis,int n,int m){
        vis[i][j]=true;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int k=0;k<4;k++){
            int newrow=i+delrow[k];
            int newcol=j+delcol[k];
            if(isvalid(newrow,newcol,n, m) && !vis[newrow][newcol] && grid[newrow][newcol]==1)
                dfs(newrow, newcol, grid, vis, n, m);
        }

    }
    private static int numberofislands(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1)
                {
                    c++;
                    dfs(i,j,grid,vis,n,m);
                }
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int grid[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        int ans=numberofislands(grid);
        System.out.println("NUmber of islands = "+ans);

    }
}
