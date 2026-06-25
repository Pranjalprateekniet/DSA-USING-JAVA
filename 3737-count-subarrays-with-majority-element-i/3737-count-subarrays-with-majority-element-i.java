class Solution {
    public int countMajoritySubarrays(int[] arr, int target) {
        int n=arr.length;
        int c=0;
        for(int i=0;i<n;i++){
            int tc=0;
            for(int j=i;j<n;j++){
                if(arr[j]==target)
                    tc++;
                if(2*tc>(j-i+1))
                        c++;
            }
        }
        return c;
    }
}