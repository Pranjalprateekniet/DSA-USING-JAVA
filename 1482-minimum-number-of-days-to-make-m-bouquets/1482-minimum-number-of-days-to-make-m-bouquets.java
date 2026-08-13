class Solution {
     private boolean possible(int arr[],int day,int m,int k){
        int n=arr.length;
        int c=0;
        int nob=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=day){
                c++;
            }
            else{
                nob+=(c/k);
                c=0;
            }       
         }
         nob+=c/k;
        if(nob>=m)
            return true;
        return false;
    }
    public int minDays(int[] arr, int m, int k) {
        int n=arr.length;
        if(n<(long)m*k)
            return -1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
             min=Math.min(arr[i],min);
             max=Math.max(arr[i],max);

        }
        int low=min;
        int high=max;
        int ans=high;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(possible(arr,mid,m,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;

    }
}