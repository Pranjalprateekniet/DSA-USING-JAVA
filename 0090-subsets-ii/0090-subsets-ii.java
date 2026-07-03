class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        //your code goes here
        Arrays.sort(arr);
        int n=arr.length;
        int i=0;
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        HashSet<List<Integer>>set=new HashSet<>();
        backtrack(arr,n,i,temp,set,ans);
        return ans;
    }
    private void backtrack(int arr[],int n,int i,List<Integer>temp,HashSet<List<Integer>>set,List<List<Integer>>ans){
        if(i==n){
            List<Integer> curr = new ArrayList<>(temp);
            if(!set.contains(temp)){
                set.add(curr);
                ans.add(curr);
            }
            return;
        }
        backtrack(arr,n,i+1,temp,set,ans);
        temp.add(arr[i]);
        backtrack(arr,n,i+1,temp,set,ans);
        temp.remove(temp.size()-1);
        return;
    }
}