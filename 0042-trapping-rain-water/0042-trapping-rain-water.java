class Solution {
    
    public int trap(int[] arr) {
        int n = arr.length;
        int totalwater=0;
        int leftmax=0;
        int rightmax=0;
        int start=0;
        int end=n-1;
        while(start<end){
            leftmax=Math.max(leftmax,arr[start]);
            rightmax=Math.max(rightmax,arr[end]);
            if(leftmax<rightmax){
                totalwater+=leftmax-arr[start];
                start++;
            }
            else{
                totalwater+=rightmax-arr[end];
                end--;
            }
        }
        return totalwater;
    }
}