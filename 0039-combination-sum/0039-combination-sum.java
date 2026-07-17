class Solution {
    private void func(int [] arr,int n,int i,int sum,int target,List<Integer>diary,List<List<Integer>>res){
        if(i==n)
        {
            if(sum==target){
                res.add(new ArrayList<>(diary));
            }
            return;
        }
        func(arr,n,i+1,sum,target,diary,res);
        if(arr[i]+sum<=target){
            diary.add(arr[i]);
            sum=sum+arr[i];
            func(arr,n,i,sum,target,diary,res);
            diary.remove(diary.size()-1);
            sum=sum-arr[i];
        }
        return;
    }


    public List<List<Integer>> combinationSum(int[] arr, int target) {
        //your code goes here
        int n=arr.length;
        List<Integer>diary=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        func(arr,n,0,0,target,diary,res);
        return res;
    }
}