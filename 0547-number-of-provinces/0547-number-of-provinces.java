class Solution {
    public int findCircleNum(int[][] adj) {
        int v=adj.length;
        boolean vis[]=new boolean[v+1];
        int c=0;
        for(int i=0;i<v;i++){
            if(!vis[i])
            {
                c++;
                dfs(i,adj,vis,v);
            }
        }
        return c;
    }
    private void dfs(int node,int [][]adj,boolean vis[],int v){
        vis[node]=true;
        for(int i=0;i<v;i++){
            if(adj[node][i]==1 && !vis[i]){
                dfs(i,adj,vis,v);
            }
        }
    }
}