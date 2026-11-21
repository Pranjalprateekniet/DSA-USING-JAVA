class Solution {
    int ans[];
    public int[] findSubtreeSizes(int[] arr, String s) {
        int n=arr.length;
        List<Integer>[] adj=new ArrayList[n];
        List<Integer>[] tree=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
            tree[i]=new ArrayList<>();

        }
        for(int i=1;i<n;i++)
            adj[arr[i]].add(i);
        int[] last=new int[26];
        Arrays.fill(last,-1);
        dfs(0,adj,s,arr,last);
        for(int i=1;i<n;i++){
            tree[arr[i]].add(i);
        
        }
        ans=new int[n];
        calc(0,tree);
        return ans;
    }
    private void dfs(int u,List<Integer>[] adj,String s,int[] arr,int[] last){
        int c=s.charAt(u)-'a',old=last[c];
        if(u>0 && old!=-1)
            arr[u]=old;
        last[c]=u;
        for(int v : adj[u])
            dfs(v,adj,s,arr,last);
        last[c]=old;
    }
    private int calc(int u,List<Integer>[] tree){
        ans[u]=1;
        for(int v : tree[u])
            ans[u]+=calc(v,tree);
        return ans[u];
    }
}