package graphs;
import java.util.*;
public class q5 {
    private static boolean valid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }
    private static int rottenoranges(int grid[][]){
        int n=grid.length;
        int m=grid[0].length;
        int [][] vis=new int[n][m];
        Queue<int[]>q=new LinkedList<>();
        int total=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0)
                    total++;
                if(grid[i][j]==2){
                    vis[i][j]=2;
                    q.add(new int[]{i,j});
                }
            }
        }
        int tm=0;int c=0;
        while(!q.isEmpty()){
            int size=q.size();
            c+=size;
            while(size-->0){
                int cell[]=q.poll();
                int row=cell[0];
                int col=cell[1];
                int delrow[]={-1,0,1,0};
                int delcol[]={0,1,0,-1};
                for(int i=0;i<4;i++){
                    int nr=row+delrow[i];
                    int nc=col+delcol[i];
                    if(valid(nr,nc,n,m) && grid[nr][nc]==1 && vis[nr][nc]==0)
                    {
                        vis[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            if(!q.isEmpty())
            {
                tm++;
            }

        }
        if(total==c)
            return tm;
        return -1;
    }
    public static void main(String[] args) {
        
    }
}
