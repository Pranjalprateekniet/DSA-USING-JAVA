class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        int prev=0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(arr[i]>prev)
                prev++;
        }
        return prev;
    }
}