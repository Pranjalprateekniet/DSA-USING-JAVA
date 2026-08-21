class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        int n=arr.length;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(i>k)
                set.remove(arr[i-k-1]);
            if(!set.add(arr[i]))
                return true;
        }
        return false;
    }
}