class Solution {
    public int largestInteger(int[] arr, int k) {
        int f[]=new int[51];
        for(int x : arr){
            f[x]++;
        }
        int res=-1,n=arr.length;
        for(int i=0;i<n;i++){
            if(k==n || (f[arr[i]]==1 && (k==1 || i==0 || i==n-1)))
                res=Math.max(res,arr[i]);
        }
        return res;
    }
}