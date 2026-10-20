class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int i=0;
        if(n==0)
            return true;
        while(i<arr.length&& n>0){
            if(arr[i]==0){
                if(i==0 || arr[i-1]==0){
                    if(i==arr.length-1 || arr[i+1]==0)
                    {
                        arr[i]=1;
                        n--;
                    }
                }
            }
            if(n==0)
                return true;
            i++;
        }
        return false;
    }
}