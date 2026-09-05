class Solution {
    public int firstStableIndex(int[] arr, int k) {
        int n=arr.length;
        int ansind=0;
        int globalmax=Integer.MIN_VALUE;
        int ansmax=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            globalmax=Math.max(globalmax,arr[i]);
            if(i==ansind)
                ansmax=Math.max(ansmax,arr[i]);
            if(arr[i]<ansmax-k){
                ansind=i+1;
                ansmax=globalmax;
            }
        }
        return ansind<n ? ansind:-1;
    }
}