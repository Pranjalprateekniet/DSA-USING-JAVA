class Solution {
    public long[] resultArray(int[] arr, int k) {
        long res[]=new long[k];
        int[] freq=new int[k];
        for(int n:  arr){
            n%=k;
            int[] cur=new int[k];
            cur[n]=1;
            for(int x=0;x<k;x++){
                cur[x*n%k]+=freq[x];
            }
            freq=cur;
            for(int x=0;x<k;x++)
                res[x]+=freq[x];
        }
        return res;
        
    }
}