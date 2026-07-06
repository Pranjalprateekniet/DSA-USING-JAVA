class Solution {
    public boolean isMiddleElementUnique(int[] arr) {
        int n=arr.length;
        int target=arr[n/2];
        int mid=n/2;
        for(int i=0;i<n;i++){
            if(i!=mid && arr[i]==target)
                return false;
        }
        return true;
    }
}