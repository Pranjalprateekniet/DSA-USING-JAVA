class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        int n=arr.length;
        int i=0;
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        backtrack(arr,n,i,temp,ans);
        return ans;

    }
        private void backtrack(int arr[],int n,int i,List<Integer>temp,List<List<Integer>>ans){
    if(i==n){
        ans.add(new ArrayList<>(temp));
        return;
    }
    backtrack(arr,n,i+1,temp,ans);
    temp.add(arr[i]);
    backtrack(arr,n,i+1,temp,ans);
    temp.remove(temp.size()-1);
    return;
}
}