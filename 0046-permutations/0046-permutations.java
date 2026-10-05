class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        func(list,new ArrayList<>(),nums);
        return list;
    }
    private void func(List<List<Integer>>ans,List<Integer>temp,int arr[]){
        if(temp.size()==arr.length)
            ans.add(new ArrayList<>(temp));
        else{
            for(int i=0;i<arr.length;i++){
                if(temp.contains(arr[i]))
                    continue;
                temp.add(arr[i]);
                func(ans,temp,arr);
                temp.remove(temp.size()-1);
            }
        }
    }
}