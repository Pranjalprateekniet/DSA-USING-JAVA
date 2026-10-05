package graphs;
import java.util.*;
public class q6 {
    private static boolean isvalid(int i,int j,int n,int m){
        if(i<0 || i>=n ||j<0 || j>=m)
            return false;
        return true;
    }
    private static int[][] nearestdistanceofcellhavingone(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int dis[][]=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    vis[i][j]=true;
                    dis[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!q.isEmpty()){
            int cell[]=q.poll();
            int row=cell[0];
            int col=cell[1];
            for(int i=0;i<4;i++){
                int newrow=row+delrow[i];
                int newcol=col+delcol[i];
                if(isvalid(newrow, newcol, n, m) && !vis[newrow][newcol]){
                    vis[newrow][newcol]=true;
                    dis[newrow][newcol]=dis[row][col]+1;
                    q.add(new int[]{newrow,newcol});
                }
            }
        }
        return dis;
    }
    public static void main(String[] args) {
        
    }
    
}
