class Solution {
    public int countGoodRotations(int[] arr) {
        int n=arr.length;
        long sum=0;
        for(int i=0;i<n;i++)
            sum+=arr[i];
        long pre=0;
        long c=0;
        for(int i=0;i<n;i++){
            if(i>=n/2){
                if(pre!=sum-pre)
                    c++;
                pre-=arr[i-n/2];
        }
        pre+=arr[i];
        }
        return (int)c;
    }
    
}