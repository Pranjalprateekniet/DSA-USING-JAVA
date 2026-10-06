class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int diff1=Math.abs(arr[i]-arr[j]);
                    int diff2=Math.abs(arr[j]-arr[k]);
                    int diff3=Math.abs(arr[i]-arr[k]);
                    if(diff1<=a && diff2<=b && diff3<=c)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}