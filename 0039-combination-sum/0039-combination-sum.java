class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        func(0,arr.length,arr,0,target,temp,ans);
        return ans;

    }
    private void func(int i,int n,int arr[],int sum,int target,List<Integer>temp,List<List<Integer>>ans){
        if(i==n)
        {
            if(sum==target)
                ans.add(new ArrayList<>(temp));
            return;
        }
        func(i+1,n,arr,sum,target,temp,ans);
        if(arr[i]+sum<=target){
            temp.add(arr[i]);
            sum+=arr[i];
            func(i,n,arr,sum,target,temp,ans);
            temp.remove(temp.size()-1);
            sum=sum-arr[i];
        }
        return;
    }
}