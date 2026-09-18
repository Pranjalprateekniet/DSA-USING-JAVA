class Solution {
    public void moveZeroes(int[] arr) {
        if(arr.length==0 || arr.length==1)
            return;
        int n=arr.length;
        int j=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
    }
}