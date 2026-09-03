class Solution {
    public boolean uniformArray(int[] arr) {
        int min=arr[0],odd=0;
        for(int x : arr){
            min=Math.min(min,x);
            odd |=x&1;
        }
        return (min & 1)==odd;
    }
}