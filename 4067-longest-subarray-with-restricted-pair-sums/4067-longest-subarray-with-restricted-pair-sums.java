class Solution {
    public int maxSubarray(int[] arr) {
        int left=0;
        int right=0;
        int n=arr.length;
        int ans=0;
        int p[]=new int[501];
        for(int i=0;i<n;i++){
            while(left<i && isvalid(p,arr[i])){
                p[arr[left]]--;
                left++;
            }
            p[arr[i]]++;
            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
    private boolean isvalid(int[] p,int x){
        for(int d=1;d<=500;d++){
            if(p[d]==0)
                continue;
            int other=x-d;
            if(other>=0 && other<=500)
            {
                if(other==d && p[d]>=2)
                    return true;
                if(other!=d && p[other]>0)
                    return true;
            }
            int t=x+d;
            if(t>=0 && t<=500)
            {
                if(p[t]>0)
                    return true;
            }
        }
        return false;
    }
}