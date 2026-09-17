class Solution {
    public boolean containsDuplicate(int[] arr) {
        HashSet<Integer>set=new HashSet<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(set.contains(arr[i]))
                return true;
            set.add(arr[i]);
        }
        return false;
    }
}