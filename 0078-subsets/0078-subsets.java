class Solution {
    private static void func(int i,int n,int arr[],List<Integer>temp,List<List<Integer>>ans){
        if(i==n){
            ans.add(new ArrayList<>(temp));
            return;
            }
        func(i+1,n,arr,temp,ans);
        temp.add(arr[i]);
        func(i+1,n,arr,temp,ans);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] arr) {
        int n=arr.length;
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        func(0,n,arr,temp,ans);
        return ans;
        
    }
}