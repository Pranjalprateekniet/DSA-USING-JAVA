class Solution {
    private static void func(int i,int n,int arr[],int target,List<Integer>temp,List<List<Integer>>res,int sum){
        if(i==n){
            if(sum==target)   
                res.add(new ArrayList<>(temp));
            return;
        }
        func(i+1,n,arr,target,temp,res,sum);
        if(arr[i]+sum<=target)
        {
            temp.add(arr[i]);
            sum+=arr[i];
            func(i,n,arr,target,temp,res,sum);
            temp.remove(temp.size()-1);
            sum=sum-arr[i];
        }
        return;

    }


    public List<List<Integer>> combinationSum(int[] arr, int target) {
        //your code goes here
        int n=arr.length;
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        func(0,n,arr,target,temp,res,0);
        return res;
    }
}