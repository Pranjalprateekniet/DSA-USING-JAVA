class Solution {
    public long minCost(int[] arr) {
        int n=arr.length;
        long ans=0L+arr[0]+arr[n-1];
        long negsum=0;
        long negcount=0;
        long smallestabs=Long.MAX_VALUE;
        for(int i=1;i<n-1;i++){
            if(arr[i]<0){
                negsum+=arr[i];
                negcount++;
            }
            smallestabs=Math.min(smallestabs,Math.abs(arr[i]));
        }
        ans+=negsum;
        if(negcount%2==1)
            ans+=smallestabs;
        return ans;
    }
}