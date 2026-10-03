package graphs;
import java.util.*;
public class q1 {
    private static void dfs(int node,int grid[][],boolean[] vis,int v){
        vis[node]=true;
        for(int adjnode=0;adjnode<v;adjnode++){
            if(grid[node][adjnode]==1 && !vis[adjnode])
                dfs(adjnode,grid,vis,v);
        }
    }
    private static int numberofprovinces(int[][] grid){
        int v=grid.length;
        boolean vis[]=new boolean[v];
        int c=0;
        for(int i=0;i<v;i++){
            if(!vis[i])
            {
                c++;
                dfs(i,grid,vis,v);
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int grid[][]=new int[n][m];
        System.out.println("enter the elements of the grid");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        int ans=numberofprovinces(grid);
        System.out.println("number of provinces ="+ans);
    }
}
