class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        if(src==dest)
            return 0;
        ArrayList<ArrayList<int[]>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());

        }
        for(int flight[] :  flights){
            int u=flight[0];
            int v=flight[1];
            int wt=flight[2];
            adj.get(u).add(new int[]{v,wt});
        }
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{0,src,0});
        int min[]=new int[n];
        Arrays.fill(min,Integer.MAX_VALUE);
        while(!q.isEmpty()){
            int cell[]=q.poll();
            int stops=cell[0];
            int node=cell[1];
            int dis=cell[2];
            for(int neighbours[] : adj.get(node)){
                int adjnode=neighbours[0];
                int edgewt=neighbours[1];
                if(dis+edgewt<min[adjnode] && stops<=k){
                    min[adjnode]=dis+edgewt;
                    q.offer(new int[]{stops+1,adjnode,dis+edgewt});

                }
            }
        }
        if(min[dest]==Integer.MAX_VALUE)
            return -1;
        return min[dest];

    }
}