class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int INF=n+1;
        int[] minlen=new int[n];
        Arrays.fill(minlen,INF);
        int left=0;
        int sum=0;
        int ans=INF;
        int best=INF;
        for(int right=0;right<n;right++){
            sum+=arr[right];
            while(sum>target){
                sum-=arr[left++];

            }
            if(sum==target)
            {
                int len=right-left+1;
                if(left>0 && minlen[left-1]!=INF)
                    ans=Math.min(ans,len+minlen[left-1]);
                best=Math.min(best,len);
            }
            minlen[right]=best;
        }
        return ans==INF?-1:ans;
    }
}