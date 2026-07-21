class Solution {
    HashMap<Integer,Integer>dp=new HashMap<>();
    private int func(int arr[],int i,int n){
        if(i==n-1)
            return arr[i];
        if(i>=n)
            return 0;
        if(dp.containsKey(i))
            return dp.get(i);
        int rob=arr[i]+func(arr,i+2,n);
        int skip=func(arr,i+1,n);
        int ans=Math.max(rob,skip);
        dp.put(i,ans);
        return ans;
        
    }
    public int rob(int[] arr) {
        int n=arr.length;
       return func(arr,0,n);
    }
}