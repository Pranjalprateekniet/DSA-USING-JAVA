class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n=arr.length;
        int sum=0;
        int curr=0;
        for(int i=2;i<n;i++){
            if(arr[i]-arr[i-1]==arr[i-1]-arr[i-2])
            {
                curr++;
                sum+=curr;

            }
            else
                curr=0;
        }
        return sum;
    }
}