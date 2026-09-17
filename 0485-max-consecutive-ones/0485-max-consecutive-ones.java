class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int n=arr.length;
        int max=0;
        int i=0;
        int c=0;
        while(i<n){
            if(arr[i]!=1){
                c=0;
            }
            else{
                c++;

            }
            max=Math.max(c,max);
            i++;
        }
        return max;
    }
}