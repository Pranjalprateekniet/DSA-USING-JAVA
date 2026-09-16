class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<int[]>[] adj=new ArrayList[n];
        int mod=1000000007;
        for(int i=0;i<n;i++){
            adj[i]=(new ArrayList<>());
        }
        for(int[] road : roads){
            int u=road[0];
            int v=road[1];
            int wt=road[2];
            adj[u].add(new int[]{v,wt});
            adj[v].add(new int[]{u,wt});

        }
        PriorityQueue<long[]>q=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        long mindist[]=new long[n];
        int ways[]=new int[n];
        Arrays.fill(mindist,Long.MAX_VALUE);
        ways[0]=1;
        mindist[0]=0;
        q.add(new long[]{0,0});
        while(!q.isEmpty()){
            long cell[]=q.poll();
            long time=cell[0];
            int node=(int)cell[1];
            for(int it[] : adj[node]){
                int adjnode=it[0];
                int edgewt=it[1];
                if(mindist[adjnode]>time+edgewt){
                    mindist[adjnode]=time+edgewt;
                    ways[adjnode]=ways[node];
                    q.add(new long[]{mindist[adjnode],adjnode});
                }
                else if(mindist[adjnode]==time+edgewt){
                    ways[adjnode]=(ways[adjnode]+ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;

    }
}