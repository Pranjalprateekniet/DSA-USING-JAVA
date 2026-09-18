class Solution {
    public int majorityElement(int[] arr) {
        int n=arr.length;
        int k=n/2;
        int c=0;
        int x=arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]==x)
                c++;
            else
                c--;
            if(c<0)
            {
                x=arr[i];
                c=0;
            }
        }
        return x;
    }
}