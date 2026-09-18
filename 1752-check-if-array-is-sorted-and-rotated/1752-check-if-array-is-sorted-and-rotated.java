class Solution {
    public boolean check(int[] arr) {
        int breaks=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]>arr[(i+1)%n])
                breaks++;
        }
        return breaks<=1;
    }
}