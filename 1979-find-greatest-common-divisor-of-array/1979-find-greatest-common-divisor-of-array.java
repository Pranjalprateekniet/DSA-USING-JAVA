class Solution {
    public int findGCD(int[] arr) {
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        for(int i=min;i>=2;i--){
            if(max%i==0 && min%i==0){
                return i;
            }
        }
        return 1;
    }
}