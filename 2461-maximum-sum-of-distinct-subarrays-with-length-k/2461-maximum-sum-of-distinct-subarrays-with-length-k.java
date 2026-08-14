class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int n=arr.length;
        int left=0;
        int right=0;
        int size=0;
        long curr=0;
        long max=0;
        HashSet<Integer>set=new HashSet<>();
        while(right<n){
            if(!set.contains(arr[right])){
                set.add(arr[right]);
                curr+=arr[right];
                size=right-left+1;
                right++;
            }
            else{
                while(set.contains(arr[right])){
                    set.remove(arr[left]);
                    curr-=arr[left];
                    left++;
                    size=right-left+1;
                }
                set.add(arr[right]);
                curr+=arr[right];
                size=right-left+1;
                right++;
            }
            while(size>k){
                set.remove(arr[left]);
                curr-=arr[left];
                left++;
                size--;
            }
            
            if(size==k)
                max=Math.max(curr,max);
        }
        return max;
    }
}