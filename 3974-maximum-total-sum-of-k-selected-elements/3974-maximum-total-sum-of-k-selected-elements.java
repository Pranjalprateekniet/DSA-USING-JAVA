class Solution {
    public long maxSum(int[] arr, int k, int mul) {
        long sum=0;
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=n-1;i>=0;i--){
            if(k>0){
                if(mul>1){
                    sum+=1L*arr[i]*mul;
                }
                else{
                    sum+=arr[i];
                }
            }
            else{
                break;
            }
            mul--;
            k--;
        }
        return sum;
    }
}