class Solution {
    public int numSubseq(int[] arr, int target) {
        Arrays.sort(arr);
        int n=arr.length;
        int left=0;
        int right =n-1;
        int c=0;
        int res=0;
        int pows[]=new int[n];
        pows[0]=1;
        int mod = (int)1e9 + 7;
        for(int i=1;i<n;i++){
            pows[i]=pows[i-1]*2%mod;
        }
        while(left<=right){
            if(arr[left]+arr[right]>target)
                right--;
            else
                res=(res+pows[right-left++])%mod;

        }
        return res;
    }
}