class Solution {
    public int removeDuplicates(int[] arr) {
        int n=arr.length;
        if(n==0)
            return 0;
        int j=1;
        for(int i=1;i<n;i++){
            if(arr[i-1]!=arr[i]){
                arr[j]=arr[i];
                j++;
            }
        }
        return j;
    }
}