class Solution {
    public long countNonDecreasingSubarrays(int[] arr, int k) {
        int n=arr.length;
        int j=n-1;
        long ans=0;
        long cost=0;
        Deque<int[]>dq=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            int cnt=1;
            while(!dq.isEmpty() && dq.peekLast()[0]<arr[i]){
                int[] p=dq.pollLast();
                cnt+=p[1];
                cost+=(long)(arr[i]-p[0])*p[1];

            }
            dq.addLast(new int[]{arr[i],cnt});
            while(cost>k){
                int[] p=dq.pollFirst();
                cost-=p[0]-arr[j--];
                if(--p[1]>0)
                    dq.addFirst(p);
                
            }
            ans+=j-i+1;
        }
        return ans;
        
    }
}