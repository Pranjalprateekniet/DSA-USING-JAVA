class Solution {
    public int minimumSumSubarray(List<Integer> arr, int l, int r) {
        int min=Integer.MAX_VALUE;
        int n=arr.size();
        int prefix[]=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+arr.get(i);

        }
        for(int i=0;i<n;i++){
            int limit=Math.min(n,i+r);
            for(int j=i+l;j<=limit;j++){
                int sum=prefix[j]-prefix[i];
                if(sum>0)
                    min=Math.min(sum,min);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}