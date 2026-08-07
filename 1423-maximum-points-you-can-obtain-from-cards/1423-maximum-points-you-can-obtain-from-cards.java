class Solution {
    public int maxScore(int[] arr, int k) {
        int pre=0;
        int n=arr.length;
        for(int i=0;i<k;i++){
            pre+=arr[i];
        }
        int max=pre;
        int curr=pre;
        int left=k-1;
        int right=arr.length-1;
        for(int i=0;i<k;i++){
            curr-=arr[left];
            curr+=arr[right];
            
            max=Math.max(curr,max);
            left--;
            right--;
        }
        return max;
    }
}