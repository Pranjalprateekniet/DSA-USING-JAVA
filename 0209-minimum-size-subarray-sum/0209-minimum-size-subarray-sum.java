class Solution {
    public int minSubArrayLen(int k, int[] arr) {
        int n=arr.length;
        int left=0;
        int right=0;
        int curr=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        while(right<n){
            sum+=arr[right];
            while(sum>=k)
            {
                min=Math.min(min,right-left+1);
                sum=sum-arr[left];
                left++;
            }
        
        right++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}