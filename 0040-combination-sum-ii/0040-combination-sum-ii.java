class Solution {
    private void func(int[] arr,int start,int target,List<Integer>diary,List<List<Integer>>res){
        if(target==0)   
        {
            res.add(new ArrayList<>(diary));
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(i>start && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target)
                break;
            diary.add(arr[i]);
            func(arr,i+1,target-arr[i],diary,res);
            diary.remove(diary.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        //your code goes here
        Arrays.sort(arr);
        List<Integer>diary=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        func(arr,0,target,diary,res);
        return res;

    }
}