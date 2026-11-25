class Solution {
    public int smallestUniqueSubarray(int[] arr) {
        int n=arr.length;
        int l=1;
        int h=n;int ans=n;
        while(l<=h){
            int m=l+(h-l)/2;
            if(isvalid(arr,m)){
                h=m-1;
                ans=m;
            }
            else
                l=m+1;
        }
        return ans;
    }
    private boolean isvalid(int arr[],int k){
        int n=arr.length;
        int l=0,r=0;
        HashMap<Long,Integer>map=new HashMap<>();
        long mod = 1000000007;
        long base = 100001;
        long p = 1;
        long hash = 0;
        for(int i=0;i<k-1;i++){
            p=(p*base)%mod;

        }
        while(r<n){
            hash=(hash*base+arr[r])%mod;
            if(r-l+1==k){
                map.put(hash,map.getOrDefault(hash,0)+1);
                hash=(hash-arr[l]*p%mod+mod)%mod;
                l++;
            }
            r++;
        }
        for(int e : map.values()){
            if(e==1)
                return true;
            
        }
        return false;
    }
}