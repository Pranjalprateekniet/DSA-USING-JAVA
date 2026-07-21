class Solution {
    HashMap<Integer,Integer>dp=new HashMap<>();
    private int func(int arr[],int i,int n){
        if(i>n)
            return 0;
        if(i==n)
            return arr[n];
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
        if(arr.length==1)
            return arr[0];
        int ans1=func(arr,0,n-2);
        dp.clear();
        int ans2=func(arr,1,n-1);
        return Math.max(ans1,ans2);
    }
}