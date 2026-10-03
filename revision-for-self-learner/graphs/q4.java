package graphs;
import java.util.*;
public class q4 {
    private static boolean isvalid(int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m)
            return false;
        return true;
    }
    private static void bfs(int[][] grid,Queue<int[]>q,boolean[][] vis){
        int n=grid.length;
        int m=grid[0].length;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!q.isEmpty()){
            int cell[]=q.poll();
            int row=cell[0];
            int col=cell[1];
            for(int i=0;i<4;i++){
                int newrow=row+delrow[i];
                int newcol=col+delcol[i];
                if(isvalid(newrow, newcol, n, m) && !vis[newrow][newcol] && grid[newrow][newcol]==1){
                    vis[newrow][newcol]=true;
                    q.add(new int[]{newrow,newcol});
                }
            }
        }
    }
    private static int numberofenclaves(int [][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || i==n-1 || j==0 || j==m-1)){
                    if(grid[i][j]==1){
                        vis[i][j]=true;
                        q.add(new int[]{i,j});
                    }
                }
            }

        }
        bfs(grid, q, vis);
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j])
                    c++;
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
        int ans=numberofenclaves(grid);
        System.out.println(ans+"are the number of enclaves");
        sc.close();
    }
}
