class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        //your code goes here
        List<Integer>diary=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        func(1,k,target,diary,res);
        return res;
    }
    
    private void func(int start,int k,int target,List<Integer>diary,List<List<Integer>>res){
        if(target==0 && diary.size()==k){
            res.add(new ArrayList<>(diary));
            return;
        }
        for(int i=start;i<=9;i++){
            if(i>target)
                break;
            diary.add(i);
            func(i+1,k,target-i,diary,res);
            diary.remove(diary.size()-1);
        }
    }
}